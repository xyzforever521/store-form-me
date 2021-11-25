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
import java.util.List;

@WebServlet("/api/weekend/list")
public class WeekendServlet extends HttpServlet {
    private WeatherService weatherService = new WeatherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseUtils resp;
        try{
            List<Weather> list = weatherService.selectWeekend();
            resp = new ResponseUtils().put("list", list);
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
