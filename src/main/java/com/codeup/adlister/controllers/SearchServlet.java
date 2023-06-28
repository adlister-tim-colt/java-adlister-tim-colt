package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Ad> ads = DaoFactory.getAdsDao().findAds(keyword);
        req.setAttribute("foundAds", ads);
        req.setAttribute("keywords", keyword);
        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keywords = req.getParameter("search");
        req.setAttribute("keywords", keywords);
        req.setAttribute("foundAds", DaoFactory.getAdsDao().findAds(keywords));
        resp.sendRedirect("/ad-info/show");
    }
}
