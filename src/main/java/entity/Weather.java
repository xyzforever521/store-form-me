package entity;

import java.util.Date;

public class Weather {
    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    private Integer weatherId;
    private Date weatherTime;
    private String weatherName;
    private Integer weatherLow;
    private Integer weatherHigh;

    @Override
    public String toString() {
        return "Weather{" +
                "weatherId=" + weatherId +
                ", weatherTime=" + weatherTime +
                ", weatherName='" + weatherName + '\'' +
                ", weatherLow=" + weatherLow +
                ", weatherHigh=" + weatherHigh +
                '}';
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public Integer getWeatherLow() {
        return weatherLow;
    }

    public void setWeatherLow(Integer weatherLow) {
        this.weatherLow = weatherLow;
    }

    public Integer getWeatherHigh() {
        return weatherHigh;
    }

    public void setWeatherHigh(Integer weatherHigh) {
        this.weatherHigh = weatherHigh;
    }

    public Date getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(Date weatherTime) {
        this.weatherTime = weatherTime;
    }
}
