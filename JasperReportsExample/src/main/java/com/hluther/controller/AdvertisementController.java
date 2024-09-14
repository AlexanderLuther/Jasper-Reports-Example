package com.hluther.controller;

import com.hluther.entity.Advertisement;
import com.hluther.model.AdvertisementModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdvertisementController", urlPatterns = {"/advertisement"})
public class AdvertisementController extends HttpServlet {

    private final AdvertisementModel advertisementModel;
    public AdvertisementController() {
        this.advertisementModel = new AdvertisementModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Advertisement> customerList = advertisementModel.getAdvertisementList();
        req.setAttribute("advertisementList", customerList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list-advertisement.jsp");
        requestDispatcher.forward(req, resp);
    }
}
