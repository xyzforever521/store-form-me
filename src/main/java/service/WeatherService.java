package service;

import entity.Weather;
import mapper.WeatherMapper;
import utils.MybatisUtils;

import java.util.List;

public class WeatherService {
    public void createWeather(Weather weather){
        new WeatherMapper().insertWeather(weather);
    }
    public List<Weather> selectWeekend(){
        List<Weather> list = (List<Weather>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("selectWeekend"));
        return list;
    }
    public Weather selectToday(){
        return (Weather) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("selectToday"));
    }
}
