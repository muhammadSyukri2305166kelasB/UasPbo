/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.moves.*;;
/**
 *
 * @author HP
 */
public class BasicNubbi extends Monster {

    public BasicNubbi(String name, int level) {
        super(name, level, "assets/Nubbi.png", 40);
        this.setElement("none");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves HeadButt = new Attack("Head Butt", 6, 6, "none");
        Moves TailsSpike = new Attack("Tails Spike", 8, 4, "none");
        Moves Heal = new Heal("Comfy Fur", 4, 8);

        this.addMoves(HeadButt);
        this.addMoves(TailsSpike);
        this.addMoves(Heal);
    }

    public BasicNubbi(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public BasicNubbi(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
