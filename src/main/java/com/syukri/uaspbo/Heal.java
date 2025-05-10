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
    private boolean canOverHeal = false;

    public Heal(String name, int diceSide) {
        super(name, diceSide);
    }
    
    public Heal(String name, int diceSide, boolean canOverHeal) {
        super(name, diceSide);
        this.canOverHeal = canOverHeal; // apakah bisa overheal atau tidak
    }

    @Override
    public void execute(Monster self, Monster target) {
        int healAmount = DiceRoller.rollDice(Math.ceilDiv(self.getLevel(), 2), this.getDiceSide());
        self.setHp(self.getHp() + healAmount);
        
        if (!canOverHeal && self.getHp() > self.getMaxHp()) {
            self.setHp(self.getMaxHp());
        }
        System.out.println(self.getName() + " melakukan " + this.getName() + " untuk menyembuhkan  " + healAmount + " HP! (HP: " + (self.getHp()-healAmount) + "+" + healAmount + ")");
    }

    public boolean isCanOverHeal() {
        return canOverHeal;
    }

    public void setCanOverHeal(boolean canOverHeal) {
        this.canOverHeal = canOverHeal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n  Heal{");
        if (canOverHeal) {
            sb.append("\n  Bisa Overheal= Hasil Heal dari gerakan ini bisa menyebabkan hp Monster melebihi batas maxHp Monster");
        }
        sb.append("\n  }\n");
        return sb.toString();
    }
    
}
