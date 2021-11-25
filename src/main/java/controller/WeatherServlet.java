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
import java.util.Date;

@WebServlet("/api/weather")
public class WeatherServlet extends HttpServlet {
    private WeatherService weatherService = new WeatherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String weatherTime = request.getParameter("weather_time");
        String weatherName = request.getParameter("weather_name");
        String weatherLow = request.getParameter("weather_low");
        String weatherHigh = request.getParameter("weather_high");
        Weather weather = new Weather();
        weather.setWeatherTime(new Date(Long.parseLong(weatherTime)));
        weather.setWeatherName(weatherName);
        weather.setWeatherLow(Integer.parseInt(weatherLow));
        weather.setWeatherHigh(Integer.parseInt(weatherHigh));
        ResponseUtils resp = null;
        try{
            weatherService.createWeather(weather);
            resp = new ResponseUtils();
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }
}
