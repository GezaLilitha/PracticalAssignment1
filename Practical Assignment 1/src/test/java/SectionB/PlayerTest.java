/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SectionB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    @Test
    public void testGetName() {
        Player p = new Player("Messi", "Forward", 10);
        assertEquals("Messi", p.getName(), "getName should return the player's name");
    }

    @Test
    public void testGetPosition() {
          Player p = new Player("Messi", "Forward", 10);
        assertEquals("Forward", p.getPosition(), "getPosition should return the player's position");
    }

    @Test
    public void testGetNumber() {
        Player p = new Player("Messi", "Forward", 10);
        assertEquals(10, p.getNumber(), "getNumber should return the player's number");
    }

    @Test
    public void testGetPlayerInfo() {
         Player p = new Player("Messi", "Forward", 10);
    String expected = "Name: Messi | Position: Forward | Number: 10";
    assertEquals(expected, p.getPlayerInfo());
    }
    
}
