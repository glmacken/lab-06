package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<Object> {
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
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
