/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class MonsterDroplett extends Monster{

    public MonsterDroplett(String name, int level) {
        super(name, level);
        this.setElement("water");
        int baseHp = 5;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());
        
        // default moves untuk Droplett
        Moves waterGun = new Attack("Water Gun", 8, 4, "water");
        Moves calmingWater = new Heal("Calming Water", 4, 8);
        
        this.addMoves(waterGun);
        this.addMoves(calmingWater);
    }

    public MonsterDroplett(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves) {
        super(name, level, maxHp, attack, defense, speed, moves);
    }

    public MonsterDroplett(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves, String element) {
        super(name, level, maxHp, attack, defense, speed, moves, element);
    }
    
}
