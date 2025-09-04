/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practicalassignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*import static org.junit.Asser.*;
import org.junit.Before;
import org.junit.Test;/*

/**
 *
 * @author lab_services_student
 */
public class SeriesTest {
    
   
    public SeriesTest() {
    }

    
    //this is going to test that searching with a valid ID, should return the correct show
        @Test
    public void TestSearchSeries() {
        Series series = new Series();
        series.getSeriesList().add(new SeriesModel("S1", "Breaking Bad", 13, 20));

        SeriesModel found = series.searchSeriesByID("S1");

        assertNotNull(found, "Series should be found");
        assertEquals("Breaking Bad", found.seriesName, "Series name should match");
    }
    
//
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series();
        series.getSeriesList().add(new SeriesModel("S1", "Breaking Bad", 13, 20));

        SeriesModel found = series.searchSeriesByID("S2");

        assertNull(found, "Searching with wrong ID should return null");
    }
    
//the upadated shows should have their infp chnaged
    @Test
    public void TestUpdateSeries() {
        Series series = new Series();
        series.getSeriesList().add(new SeriesModel("S1", "Breaking Bad", 13, 20));

        boolean result = series.updateSeriesLogic("S1", "Better Call Saul", 15, 25);

        assertTrue(result, "Update should return true when successful");
        assertEquals("Better Call Saul", series.searchSeriesByID("S1").seriesName);
        assertEquals(15, series.searchSeriesByID("S1").seriesAge);
        assertEquals(25, series.searchSeriesByID("S1").numberOfEpisodes);
    }

    //that deleting the show by the id number works
    @Test
    public void TestDeleteSeries() {
        Series series = new Series();
        series.getSeriesList().add(new SeriesModel("S1", "Breaking Bad", 13, 20));

        boolean result = series.deleteSeriesLogic("S1");

        assertTrue(result, "Delete should return true when successful");
        assertEquals(0, series.getSeriesList().size(), "List should be empty after delete");
    }

    //that using th ewrong id nunmber to delete the series should not change the list
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series();
        series.getSeriesList().add(new SeriesModel("S1", "Breaking Bad", 13, 20));

        boolean result = series.deleteSeriesLogic("S2");

        assertFalse(result, "Delete should fail if ID does not exist");
        assertEquals(1, series.getSeriesList().size(), "List should remain unchanged");
    }
//that ages between 2-18 should be accepted
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series series = new Series();

        assertTrue(series.isValidAge(10), "Age 10 should be valid");
        assertTrue(series.isValidAge(18), "Age 18 should be valid");
        assertTrue(series.isValidAge(2), "Age 2 should be valid");
    }
//ages outside the parameters of 2-18 are rejected
    @Test
    public void TestSeriesAgeRestriction_AgeInvalid() {
        Series series = new Series();

        assertFalse(series.isValidAge(1), "Age 1 should be invalid");
        assertFalse(series.isValidAge(19), "Age 19 should be invalid");
        assertFalse(series.isValidAge(0), "Age 0 should be invalid");
    }
}