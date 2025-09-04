/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicalassignment1;


import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class PracticalAssignment1 {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();
        
        //this will show the menu and loop
        int choice = 0;
        do {
            System.out.println("\n=== SERIES MANAGEMENT MENU ===");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update a series");
            System.out.println("4. Delete a series");
            System.out.println("5. Display series report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            if (!input.matches("[1-6]")) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    seriesManager.CaptureSeries();
                    break;
                case 2:
                    seriesManager.SearchSeries();
                    break;
                case 3:
                    seriesManager.UpdateSeries();
                    break;
                case 4:
                    seriesManager.DeleteSeries();
                    break;
                case 5:
                    seriesManager.SeriesReport();
                    break;
                case 6:
                    seriesManager.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
}