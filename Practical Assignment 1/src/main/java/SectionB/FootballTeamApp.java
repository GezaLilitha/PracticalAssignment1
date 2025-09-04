/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SectionB;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class FootballTeamApp {
    private static Player[] team = new Player[11]; //obviously theres a max of 11 players
    private static int playerCount = 0;
    
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int choice;
     
        do{
            System.out.println("--- Football Team Management ---");
            System.out.println("1. Add Player");
            System.out.println("2. View Team Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1 -> addPlayer(sc);   
                case 2 -> viewReport(sc);  
                case 3 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }
    
    //mehtod to add player
    private static void addPlayer(Scanner sc){
        if(playerCount >= team.length){
            System.out.println("Team is full! (Max 11 players");
            return;
        }
        System.out.println("Enter player name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter player number");
        int number = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Player added successfully!");
    }
    
    //method to view the player report
    private static void viewReport(Scanner sc){
        System.out.println("----Team Report----");
        if(playerCount == 0){
            System.out.println("No players in the team");
        }else{
            for(int i = 0; i < playerCount; i++){
                System.out.println(team[i].getPlayerInfo());
            }
        }
    }
    
}
