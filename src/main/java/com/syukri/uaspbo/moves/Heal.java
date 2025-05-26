/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.moves;

import com.syukri.uaspbo.pokemons.Monster;
import java.io.Serializable;
import com.syukri.uaspbo.DiceRoller;

/**
 *
 * @author HP
 */
public class Heal extends Moves implements Serializable{
    private boolean canOverHeal;
    int averageHeal = (this.getBaseValue() + this.getDiceSide() + 1)/2; //dikali level

    public Heal(String name, int diceSide, int baseHeal) {
        super(name, diceSide, baseHeal);
        this.canOverHeal = false;
    }
    
    public Heal(String name, int diceSide, boolean canOverHeal, int baseHeal) {
        super(name, diceSide, baseHeal);
        this.canOverHeal = canOverHeal; // apakah bisa overheal atau tidak
    }

    @Override
    public void execute(Monster self, Monster target) {
        int healAmount = (self.getLevel()*this.getBaseValue()+ DiceRoller.rollDice(self.getLevel(), this.getDiceSide())) / 2 ;
        self.setHp(self.getHp() + healAmount);
        System.out.println(self.getName() + " melakukan " + this.getName() + " untuk menyembuhkan  " + healAmount + " HP! (HP: " + (self.getHp()-healAmount) + "+" + healAmount + ")");
        if (!canOverHeal && self.getHp() > self.getMaxHp()) {
            self.setHp(self.getMaxHp());
        }
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
        sb.append("Heal{");
        sb.append("canOverHeal=").append(canOverHeal);
        sb.append('}');
        return sb.toString();
    }
    
}
