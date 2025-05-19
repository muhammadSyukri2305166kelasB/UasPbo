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
    private final int baseHeal;

    public Heal(String name, int diceSide, int baseHeal) {
        super(name, diceSide);
        this.baseHeal = baseHeal;
    }
    
    public Heal(String name, int diceSide, boolean canOverHeal, int baseHeal) {
        super(name, diceSide);
        this.baseHeal = baseHeal;
        this.canOverHeal = canOverHeal; // apakah bisa overheal atau tidak
    }

    @Override
    public void execute(Monster self, Monster target) {
        int healAmount = self.getLevel()/2*this.getBaseHeal() + DiceRoller.rollDice(Math.ceilDiv(self.getLevel(), 2), this.getDiceSide());
        self.setHp(self.getHp() + healAmount);
        System.out.println(self.getName() + " melakukan " + this.getName() + " untuk menyembuhkan  " + healAmount + " HP! (HP: " + (self.getHp()-healAmount) + "+" + healAmount + ")");
        if (!canOverHeal && self.getHp() > self.getMaxHp()) {
            self.setHp(self.getMaxHp());
        }
    }

    public boolean isCanOverHeal() {
        return canOverHeal;
    }
    
    public int getBaseHeal() {
        return baseHeal;
    }

    public void setCanOverHeal(boolean canOverHeal) {
        this.canOverHeal = canOverHeal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Heal{");
        sb.append("canOverHeal=").append(canOverHeal);
        sb.append(", baseHeal=").append(baseHeal);
        sb.append('}');
        return sb.toString();
    }
    
}
