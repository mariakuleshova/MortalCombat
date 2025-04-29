/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author maria
 */
public class GameResults {
    private String name;
    private int points;
    
    public GameResults(String name, int points){
        this.name = name;
        this.points = points;
    }

    public String getName(){
        return this.name;
    }
    
    public int getPoints(){
        return this.points;
    }   
}

