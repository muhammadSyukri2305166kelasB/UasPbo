/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
import java.util.Random;

public class Attack extends Moves {
    public Attack(String name) {
        super(name);
    }

    @Override
    public void execute(Monster self, Monster target) {
        int diceSum = self.rollDice(self.level, 6);
        double ratio = (double) self.attack / target.defense;
        int damage = (int) Math.round(diceSum * ratio);
        target.hp -= damage;
        System.out.println(self.name + " uses " + name + " on " + target.name + " for " + damage + " damage! (" + target.name + " HP: " + target.hp + ")");
    }
}
