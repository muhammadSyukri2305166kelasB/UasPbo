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
    private boolean isUsable = true;
    private int baseDamage;
    
    public Attack(String name, int baseDamage, int diceSide, String element) {
        super(name, diceSide);
        this.setElement(element);
        this.baseDamage = baseDamage;
    }

    @Override
    public void execute(Monster self, Monster target) {
        int diceSum = this.baseDamage + DiceRoller.rollDice(self.getLevel(), this.getDiceSide());
        double ratio = (double)self.getAttack() / (double)target.getDefense();
        double mult = 1.0; // elemen
        
        if (this.getElement().equals(self.getElement()) && !this.getElement().equals("none")) {
            mult += 0.2; // karena elemen gerakan sama dengan elemen monster
        }
        
        if (this.getElement().equals("water") && target.getElement().equals("fire") ||
            this.getElement().equals("fire") && target.getElement().equals("plant") ||
            this.getElement().equals("plant") && target.getElement().equals("water"))
        {
            mult += 0.5; // karena elemen gerakan ini unggul terhadap elemen monster lawan
        } else if (!this.getElement().equals("none") && !this.getElement().equals(target.getElement())) {
            mult -= 0.5; // karena elemen gerakan ini lemah terhadap elemen monster lawan
        }
        
        int damage = (int) Math.floor(diceSum * ratio * mult);
        target.setHp(target.getHp() - damage);
        
        String effectiveness;
        
        if (mult == 1) {
            effectiveness = "biasa saja";
        } else if (mult < 1) {
            effectiveness = "Kurang Efektif";
        } else if (mult <= 1.6) {
            effectiveness = "Efektif";
        } else {
            effectiveness = "Sangat Efektif!";
        }
        
        if (this.getDiceSide() >= 8 && diceSum >= (this.getDiceSide()+1)*self.getLevel()/2) {
            this.setIsUsable(false);
        }
        
        System.out.println(self.getName() + " menyerang dengan " + this.getName() + " ke " + target.getName() + " dan memberikan " + damage + " damage! (" + target.getName() + " HP: " + (target.getHp()+damage) + " - " + damage + ")");
        if (!this.isIsUsable()) {
            System.out.println(self.getName() + " mengerahkan segala kekuatannya untuk damage yang besar! " + this.getName() + " tidak bisa dipakai lagi, akan bisa dipakai lagi setelah Battle ini berakhir");
        } else {
            System.out.println(effectiveness);
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
        sb.append(super.toString());
        sb.append("\n  Attack{");
        sb.append("\n  element=").append(this.getElement());
        if (this.getDiceSide() >=8) {
            sb.append(", \n  Habis Terpakai= Monster mungkin mengerahkan seluruh kemampuannya untuk serangan ini (hasil roll dadu lebih dari average), sehingga gerakan ini tidak bisa dipakai lagi. Akan bisa dipakai lagi di Battle selanjutnya");
        }
        sb.append("\n  }\n");
        return sb.toString();
    }
    
}
