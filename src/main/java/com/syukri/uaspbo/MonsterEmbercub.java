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
public class MonsterEmbercub extends Monster {

    public MonsterEmbercub(String name, int level) {
        super(name, level);
        this.setElement("fire");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());
        
        // default moves untuk Embercub
        Moves kick = new Attack("Kick", 1, 4, "none");
        Moves claw = new Attack("Claw", 2, 4, "none");
        Moves firePunch = new Attack("Fire Punch", 1, 6, "fire");
        
        this.addMoves(kick);
        this.addMoves(claw);
        this.addMoves(firePunch);
    }

    public MonsterEmbercub(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves) {
        super(name, level, maxHp, attack, defense, speed, moves);
    }

    public MonsterEmbercub(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves, String element) {
        super(name, level, maxHp, attack, defense, speed, moves, element);
    }
    
}
