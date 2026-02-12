package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCityName() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public int compareTo(City other) {
        City city = (City) other;
        return this.city.compareTo(city.getCityName());
    }
}
