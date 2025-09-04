/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SectionB;

/**
 *
 * @author lab_services_student
 */
public class Player {
    
    //fields
    private String name;
    private String position;
    private int number;
    
    //Constructor to initialize the fields
    public Player (String name, String position, int number){
        this.name = name;
        this.position = position;
        this.number = number;
        
    }
    
    //my getters
    public String getName(){return name;}
    public int getNumber(){ return number;}
    public String getPosition(){return position;}
    
       //method to display player info
    public String getPlayerInfo(){
        
        return "Name: " + name + " | Position: " + position + " | Number: " + number; 
    
    
    }
}
