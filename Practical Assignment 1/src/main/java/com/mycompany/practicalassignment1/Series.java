/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicalassignment1;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author lab_services_student
 */
public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    //this is to capture a new series
    public void CaptureSeries(){
        System.out.println("Capture A New Seriess");
        System.out.println("***************");
        
        System.out.println("Enter the SeriesID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        
    int validAge = 0;
        while(true){
        System.out.println("Enter the series age restriction (2-18): ");
        String input = scanner.nextLine();
        
        
        //to check if the input is a digit
        if(input.matches("\\d+")){
            int age = Integer.parseInt(input);
            if(age >= 2 && age <= 18){
                validAge = age; //if it's valid, this will save and break th eloop
                break;
            }else{
                System.out.println("Age must be between 2 and 18.");
            }
        }else{
            System.out.println("Please enter numbers only.");
            }
        }
        
        // the numbr of episodes
        System.out.println("Enter the number of episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());
        
        //The arraylist that will save the series in meory
        seriesList.add(new SeriesModel(id, name, validAge, episodes));
        System.out.println("Series has been successfully captured");
        
        backToMenu();
    }
    
    private void backToMenu(){
        System.out.print("Enter (1) to launch the menu or any other key to exit: ");
        String input = scanner.nextLine();
        if (input.equals("1")){
            backToMenu();
        }
    }
    
    //method to to search up a series
    public void SearchSeries(){
        System.out.println("Enter the series id to search: ");
        String id = scanner.nextLine();
        
        for(SeriesModel s : seriesList){
            if (s.seriesID.equals(id)){ // if the seeries is found
                s.displaySeries();
                return;
                
            }   
        }
        //this is if it isnt found
        System.out.println("Series with Series Id: " + id + "was not found" );
    }
    
    //method to update series 
    public void UpdateSeries(){
        System.out.println("Enter the series ID to search: ");
        String id = scanner.nextLine();
        
        for (SeriesModel s : seriesList){
            if (s.seriesID.equals(id)){
                
                //update the name
                 System.out.println("Enter the series name: ");
                 s.seriesName = scanner.nextLine();
                
                 //to update the restrictioin
             int newAge;
                while(true){
                System.out.println("Enter the age restiction (2-18): ");
                String input = scanner.nextLine();
                
                if(input.matches("\\d+")){
                 newAge = Integer.parseInt(input);
                 if(newAge >= 2 && newAge <= 18){
                 s.seriesAge = newAge;
                break;
             }else{
                 System.out.println("Invalid age restriction. Age restriction must be between 2-18");
            }
              }else{
                System.out.println("Please enter numbers only.");
                return;
            }   
        
    }
 
}
        }
    }
    //mehtod to delete a series
    public void DeleteSeries(){
        System.out.println("Enter the series ID you whis to delete: ");
        String id = scanner.nextLine();
        
        for(int i = 0; i < seriesList.size(); i++){
            SeriesModel s = seriesList.get(i);
            if(s.seriesID.equals(id)){
                //asks if they're sure they want to delete
                System.out.println("Are you sure you want to delete series" + id + "from the system? Yes (y) to delete: ");
                //System.out.println("*****************************");
                String confirm = scanner.nextLine();
                
                if(confirm.equalsIgnoreCase("y")){
                    seriesList.remove(i);
                    System.out.println("Series with series ID" + id + "WAS DELETED!");
                    return;
                }
                        
            }
        }
    }
    
    
    public void SeriesReport(){
        System.out.println("===========================");
        System.out.print("          SERIES REPORT            ");
        System.out.println("===========================");
        
        if(seriesList.isEmpty()){
            System.out.println("No sereis has been captured yet.");
            backToMenu();
            return;
        }
        
        //Print table headers 
        System.out.printf("%-12s %-20s %-18s %-15s",
                           "Series ID", "Series Name", "Series Age Restriction", "Number of Episodes");
        System.out.println("--------------------------------------------------------------------------");
        
        //loop through the sereis
        for (SeriesModel s : seriesList){
            System.out.printf("%-12s %-20s %-18s %-15s",
                           s.seriesID, s.seriesName , s.seriesAge , s.numberOfEpisodes);
        }
        
        backToMenu();
        
    }
    
    public void ExitSeriesApplication(){
        System.out.println("Exiting application");
        System.exit(0);
    }
    
    //this will find a series by its ID and return the object
    public SeriesModel searchSeriesByID(String id){
        for (SeriesModel s : seriesList){
            if (s.seriesID.equalsIgnoreCase(id)){
                return s;
            }
            
        }
         return null;
    }
   
//updating a series (The JUnit will call this
    public boolean updateSeriesLogic(String id, String newName, int newAge, int newEpisodes){
      SeriesModel s = searchSeriesByID(id);
    if (s != null) {
        s.seriesName = newName;
        s.seriesAge = newAge;
        s.numberOfEpisodes = newEpisodes;
        return true; // The update has worked
    }
    return false; // The series has not found
}

// for deeleting a series (The JUnit will call this)
public boolean deleteSeriesLogic(String id) {
    SeriesModel s = searchSeriesByID(id);
    if (s != null) {
        seriesList.remove(s);
        return true; // the delete worked
    }
    return false; // nothing has been deleted
}

// Check if an age is valid, used for validation tests
public boolean isValidAge(int age) {
    return (age >= 2 && age <= 18);
}

// Let JUnit see what’s inside the list
public ArrayList<SeriesModel> getSeriesList() {
    return seriesList;
}
}
