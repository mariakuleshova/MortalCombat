/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;

import Components.GameCharacter;

/**
 *
 * @author maria
 */
public abstract class Action {
    public abstract String getType();
    public abstract void realization(GameCharacter gameCharacter, GameCharacter enemy, String enemyActionType);
}
