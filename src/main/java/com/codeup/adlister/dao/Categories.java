package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    List<Category> listAll();
    String getCategoryByAdsId(int id);
    String getCategory(Ad ad);
    void insertAdCat(Ad ad, String category);
    int getIdByCategory(String category);

}
