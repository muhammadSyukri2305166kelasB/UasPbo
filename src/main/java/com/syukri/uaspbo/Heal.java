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
    int healAmount;

    public Heal(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void execute(Monster self, Monster target) {
        self.hp += healAmount;
        System.out.println(self.name + " uses " + name + " and heals for " + healAmount + " HP! (HP: " + self.hp + ")");
    }
}
