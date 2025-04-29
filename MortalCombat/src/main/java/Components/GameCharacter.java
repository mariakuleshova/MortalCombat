/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.ImageIcon;

/**
 *
 * @author maria
 */
public class GameCharacter {

    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private int turnsWithDebuff;
    public ImageIcon icon;
    private final CharacterName name;

    public GameCharacter(int level, int health, int damage, CharacterName name) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
        this.name=name;
    }

    public boolean isDebuffed() {
        return turnsWithDebuff > 0;
    }

    public void loseDebuffTurn() {
        if (turnsWithDebuff > 0) {
            turnsWithDebuff--;
        }
    }

    public void setDebuffTurns(int turns) {
        turnsWithDebuff = turns;
    }

    public int getDebuffTurns() {
        return turnsWithDebuff;
    }

    public void setPhoto(String path) {
        icon = new ImageIcon(path);
    }

    public ImageIcon getPhoto() {
        return icon;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void addLevel() {
        this.level++;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void addMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public CharacterName getName() {
        return name;
    }
    
    public String getStringName(){
       return name.getString();
    }
}