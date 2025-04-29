/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Components.GameCharacter;

import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Location {
    private int currentLocation = 1;
    private int currentEnemyNumber = 0;
    private ArrayList<GameCharacter> currentEnemiesList = new ArrayList<>();
    private GameCharacter[] fullEnemiesList = null;
    private int locationSize;

    public void setFullEnemiesList(GameCharacter[] list) {
        fullEnemiesList = list;
    }

    public ArrayList<GameCharacter> getCurrentEnemies() {
        return currentEnemiesList;
    }

    public void setCurrentEnemies(int maxEnemies) {
        currentEnemiesList = new ArrayList<>();
        locationSize = 1 + (int) (Math.random() * maxEnemies);
        for (int i = 0; i < locationSize; i++) {
            GameCharacter enemy = getRandomEnemy();
            currentEnemiesList.add(enemy);
        }
    }

    public static final int MAX_ENEMIES = 4;
    public static final int DEFAULT_ENEMY_INDEX = 4;

    private GameCharacter getRandomEnemy() {
        int enemyIndex = (int) (Math.random() * MAX_ENEMIES);
        GameCharacter enemy = fullEnemiesList[enemyIndex];
        setEnemyPhoto(enemy);
        return enemy;
    }

    private void setEnemyPhoto(GameCharacter enemy) {
        try {
            // Формируем имя файла: lowercase без дефисов + .jpg
            String imageName = enemy.getStringName().toLowerCase().replace("-", "") + ".jpg";
            // Путь внутри JAR-файла или ресурсов
            String resourcePath = "/images/" + imageName;
            java.net.URL imgURL = getClass().getResource(resourcePath);

            if (imgURL != null) {
                // Используем существующий метод setPhoto
                enemy.setPhoto(imgURL.getPath()); 
            } else {
                System.err.println("Image not found: " + resourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetLocation(boolean isNextLocation, int maxEnemies) {
        if (isNextLocation) {
            currentLocation += 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(maxEnemies);
        } else {
            currentLocation = 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(0);
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentEnemyNumber() {
        return currentEnemyNumber;
    }

    public GameCharacter getCurrentEnemy() {
        GameCharacter enemy;
        if (currentEnemyNumber != locationSize) {
            currentEnemyNumber += 1;
            return currentEnemiesList.get(currentEnemyNumber - 1);
        } else {
            currentEnemyNumber = 0;
            enemy = fullEnemiesList[DEFAULT_ENEMY_INDEX];
            setEnemyPhoto(enemy);
            return enemy;
        }
    }
}