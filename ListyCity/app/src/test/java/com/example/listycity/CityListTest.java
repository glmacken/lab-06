package com.example.listycity;

import org.junit.Test;
import static org.junit.Assert.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");

        assertTrue(cityList.hasCity(cityList.getCities().get(0)));
        assertFalse(cityList.hasCity(city));

        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        // Test deletion of city within list
        cityList.deleteCity(city);
        assertFalse(cityList.getCities().contains(city));
        assertEquals(1, cityList.getCities().size());

        // Test attempted deletion of city not in list
        assertThrows(IllegalArgumentException.class, () -> cityList.deleteCity(city));
    }

    @Test
    public void testCountCities() {
        // Test initial list
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        // Test empty list
        cityList.deleteCity(cityList.getCities().get(0));
        assertEquals(0, cityList.countCities());

        // Test list with inserted test values
        String[] cityNames = {"City1", "City2", "City3"};
        for (String name : cityNames) {
            cityList.add(new City(name, ""));
        }
        assertEquals(cityNames.length, cityList.countCities());
    }
}