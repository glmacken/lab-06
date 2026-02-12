package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of City objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a City to the list if the City does not exist
     * @param city
     *      This is a candidate City to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Removes a specified City from the list. Throws an exception if the City is not in the list
     * @param city
     *      The city to be removed from the list
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Returns whether or not a City is contained within the list based on Object ID
     * @param city
     *      The city to check the membership of.
     * @return
     *      returns true if city is in the CityList. False otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Returns the number of Cities in the list
     * @return
     *      The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
