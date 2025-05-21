/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;

import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Heal;
import com.syukri.uaspbo.Monster;
import com.syukri.uaspbo.Moves;

/**
 *
 * @author HP
 */
public class WaterMizumon extends Monster {

    public WaterMizumon(String name, int level) {
        super(name, level, "assets/Banyu.png", 20);
        this.setElement("water");
        int baseHp = 5;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        // default moves untuk Droplett
        Moves waterGun = new Attack("Water Gun", 8, 4, "water");
        Moves WaterFlood= new Attack("Water Flood", 10, 4, "water");
        Moves calmingWater = new Heal("Calming Water", 4, 8);

        this.addMoves(waterGun);
        this.addMoves(WaterFlood);
        this.addMoves(calmingWater);
    }

    public WaterMizumon(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public WaterMizumon(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
