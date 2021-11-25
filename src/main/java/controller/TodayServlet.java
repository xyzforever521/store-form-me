package controller;

import entity.Weather;
import service.WeatherService;
import utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/api/today")
public class TodayServlet extends HttpServlet {
    private WeatherService weatherService = new WeatherService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Weather weather = weatherService.selectToday();
        ResponseUtils resp;
        try{
            resp = new ResponseUtils().put("weather", weather);
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(resp.toJsonString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
