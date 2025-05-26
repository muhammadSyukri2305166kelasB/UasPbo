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

public class Attack extends Moves implements Serializable{
    private boolean isUsable = true;
    int averageDamage = (this.getBaseValue() + this.getDiceSide() + 1)/2; // dikali level
    // damage = (roll(level, 4) + baseDamage*level)/2
    
    public Attack(String name, int baseDamage, int diceSide, String element) {
        super(name, diceSide, baseDamage);
        this.setElement(element);
    }

    @Override
    public void execute(Monster self, Monster target) {
        // damage = (roll(level, 4) + baseDamage*level)/2
        double diceSum = DiceRoller.rollDice(self.getLevel(), this.getDiceSide());
        double damage = (this.getBaseValue()*self.getLevel() + diceSum)/2;
        double ratio = (double)self.getAttack() / (double)target.getDefense();
        double mult = 1.0; // elemen
        
        if (this.getElement().equals(self.getElement()) && !this.getElement().equals("none")) {
            mult += 0.1; // karena elemen gerakan sama dengan elemen monster
        }
        
        if (this.getElement().equals("water") && target.getElement().equals("fire") ||
            this.getElement().equals("fire") && target.getElement().equals("plant") ||
            this.getElement().equals("plant") && target.getElement().equals("water"))
        {
            mult += 0.1; // karena elemen gerakan ini unggul terhadap elemen monster lawan
        } else if (!this.getElement().equals("none") && !this.getElement().equals(target.getElement())) {
            mult -= 0.2; // karena elemen gerakan ini lemah terhadap elemen monster lawan
        }
        
        damage = Math.round(damage * ratio * mult);
        target.setHp(target.getHp() - (int) damage);
        
        if (this.getDiceSide() >= 8 && diceSum >= (this.getDiceSide()+1)*self.getLevel()/2) {
            this.setIsUsable(false);
        }
        
        System.out.println(self.getName() + " menyerang dengan " + this.getName() + " ke " + target.getName() + " dan memberikan " + damage + " damage! (" + target.getName() + " HP: " + (target.getHp()+damage) + " - " + damage + ")");
        if (!this.isIsUsable()) {
            System.out.println(self.getName() + " mengerahkan segala kekuatannya untuk damage yang besar! " + this.getName() + " tidak bisa dipakai lagi, akan bisa dipakai lagi setelah Battle ini berakhir");
        }
    }
    
    public boolean isIsUsable() {
        return isUsable;
    }

    public void setIsUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attack{");
        sb.append("isUsable=").append(isUsable);
        sb.append(", averageDamage=").append(averageDamage);
        sb.append('}');
        return sb.toString();
    }

}
