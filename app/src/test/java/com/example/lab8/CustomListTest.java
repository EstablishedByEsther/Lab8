package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * Create a mocklist for my cityList.
     * @return The mock list.
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list, increase the list by adding a new city,
     * check if our current size matches the initial size.
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estavan","SK"));
        assertEquals(list.getCount(),listSize+1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void doesNotHaveCityTest(){
        list = MockCityList();
        City city = new City("Halifax","NS");
        assertFalse(list.hasCity(city));
    }
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City cityToDelete = new City("Canada","NA");
        list.addCity(cityToDelete);
        assertEquals(1, list.getCount());
        list.deleteCity(cityToDelete);
        assertEquals(0,list.getCount());
        assertFalse(list.hasCity(cityToDelete));
    }

    @Test
    public void deleteCityExceptionTest(){
        list = MockCityList();
        City notInList = new City("District","12");
        assertThrows(RuntimeException.class,() -> {
            list.deleteCity(notInList);
        });
    }

    @Test
    public void countCitiesTest(){
        list = MockCityList();
        assertEquals(0,list.countCities());
        City addedCity = new City("Niagara","ON");
        list.addCity(addedCity);
        assertEquals(1,list.countCities());
    }

}
