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
public class BasicFluffawn extends Monster {

    public BasicFluffawn(String name, int level) {
        super(name, level, "assets/Fluffawn.png", 40);
        this.setElement("none");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves MultiPunch = new Attack("Multi Punch", 6, 6, "none");
        Moves HeadKick = new Attack("HeadKick", 8, 4, "none");
        Moves PunchDash = new Attack("Punch Dash", 8, 4, "none");

        this.addMoves(MultiPunch);
        this.addMoves(HeadKick);
        this.addMoves(PunchDash);
    }

    public BasicFluffawn(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public BasicFluffawn(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
