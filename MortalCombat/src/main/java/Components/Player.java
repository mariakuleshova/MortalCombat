/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author maria
 */
public class Player extends GameCharacter {

    private int points;
    private int experience;
    private int nextExperience;
    private Items[] items;

    public Player(int level, int health, int damage, CharacterName name) {
        super(level, health, damage, name);
        this.points = 0;
        this.experience = 0;
        this.nextExperience = 40;
    }
    
    public void setItems(Items[] items){
        this.items = items;
    }
    public Items[] getItems(){
        return this.items;
    }
    public int getPoints() {
        return this.points;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getNextExperience() {
        return this.nextExperience;
    }
    
    public void resetPoints() {
        this.points = 0;
    }
    
    public void setPoints(int points) {
        this.points += points;
    }

    public void resetExperience() {
        this.experience = 0;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public void setNextExperience(int nextExperience) {
        this.nextExperience = nextExperience;
    }
}

