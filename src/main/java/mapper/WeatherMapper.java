package mapper;

import entity.Weather;
import utils.MybatisUtils;

import java.util.List;

public class WeatherMapper {
public void insertWeather(Weather weather){
    MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("insertWeather", weather));
}
}
