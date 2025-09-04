/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicalassignment1;

/**
 *
 * @author lab_services_student
 */
public class SeriesModel {
    
public String seriesID;
    public String seriesName;
    public int seriesAge;
    public int numberOfEpisodes;
    
    //constructor
    public SeriesModel (String seriesID, String seriesName, int seriesAge, int numberOfEpisodes){
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
                
    }
    //method to print the detials of the seris
    public void displaySeries(){
        System.out.println("Series ID: " + seriesID);
        System.out.println("Series Name: " + seriesName);
        System.out.println("Series Age: " + seriesAge);
        System.out.println("Nnumber of Episodes: " + numberOfEpisodes);
        
    }
            
    
}
