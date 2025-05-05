/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
public class Heal extends Moves {
    int diceSide;

    public Heal(String name, int diceSide) {
        super(name);
        this.diceSide = diceSide;
    }

    @Override
    public void execute(Monster self, Monster target) {
        int healAmount = self.rollDice(Math.ceilDiv(self.level, 2), diceSide);
        self.hp += healAmount;
        System.out.println(self.name + " uses " + name + " and heals for " + healAmount + " HP! (HP: " + self.hp + ")");
    }
}
