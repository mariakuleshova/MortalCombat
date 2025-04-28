/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author maria
 */
public enum CharacterName {
    You("You") ,
    BARAKA ("Baraka"),
    LIU_KANG ("Liu-Kang"),
    SONYA_BLADE ("Sonya-Blade"),
    SUB_ZERO ("Sub-Zero"),
    SHAO_KAHN ("Shao-Kahn");

    private String name;

    CharacterName(String name) {
        this.name = name;
    }

    public String getString() {
        return name;
    }
}
