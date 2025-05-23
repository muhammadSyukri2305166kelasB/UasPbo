/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;

import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Moves;
/**
 *
 * @author HP
 */
public class BasicLopreign extends Monster {

    public BasicLopreign(String name, int level) {
        super(name, level, "assets/Lopreign.png", 20);
        this.setElement("none");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves TailSwipe = new Attack("Tail Swipe", 6, 6, "none");
        Moves TailDashes = new Attack("Tail Dashes", 8, 4, "none");
        Moves TailGun = new Attack("Tail Gun", 10, 4, "none");

        this.addMoves(TailSwipe);
        this.addMoves(TailDashes);
        this.addMoves(TailGun);
    }

    public BasicLopreign(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public BasicLopreign(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
