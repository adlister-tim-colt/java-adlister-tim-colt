package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> findAds(String keywords) {
        String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + keywords + "%");
            stmt.setString(2, "%" + keywords + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding an ad by keywords", e);
        }
    }

    @Override
    public List<Ad> findAds(Long id) {
        return null;
    }

    @Override
    public boolean deleteAd(Long id) {
        return false;
    }

    @Override
    public void updateAd(Ad adToBeUpdate) {

    }


    public long deleteAd(long id) {
        PreparedStatement stmt;
        String sql = "DELETE FROM ads WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            long result = stmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }


    public int update(Ad ad) {

        PreparedStatement stmt;
        String sql = "UPDATE ads set  user_id = ?, title = ?, description = ? WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getId());

            int result = stmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Ad> setCategoryWithAd(List<Ad> ad) {
        List<Ad> ads;
        PreparedStatement statement = null;
        for (Ad x : ad) {
            String query = "SELECT name FROM categories JOIN ad_category ON categories.id = ad_category.category_id JOIN ads ON ad_category.ad_id = ads.id WHERE ads.id = '" + x.getId() + "'";
            try {
                statement = connection.prepareStatement(query);
                ResultSet rs = statement.executeQuery();
                rs.next();
                x.setCategory(rs.getString("name"));
            } catch (SQLException e) {
                throw new RuntimeException("Error adding category to ad.", e);
            }
        }
        return ad;
    }

    @Override
    public List<Ad> adsByUserId(Long userId) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, userId);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

    }


    @Override
    public Ad findById(Long id){
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding specified Ad Object.", e);
        }
    }

    @Override
    public int getIdFromAd(String title) {
        return 0;
    }


//    @Override
//    public List<Ad> findAds(Long id) {
//        return null;
//    }

//    @Override
//    public void updateAd(Ad adToBeUpdate) {
//
//    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
