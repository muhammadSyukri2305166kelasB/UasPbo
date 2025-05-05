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
    int diceSide = 1;
    String element = "none";
    
    public Attack(String name, int diceSide, String element) {
        super(name);
        this.diceSide = diceSide;
        this.element = element;
    }

    @Override
    public void execute(Monster self, Monster target) {
        int diceSum = self.rollDice(self.level, this.diceSide);
        double ratio = (double) self.attack / target.defense;
        double mult = 1.0;
        
        if (this.element.equals(self.element) && !this.element.equals("none")) {
            mult += 0.2;
        }
        
        if (self.element.equals("water") && target.element.equals("fire") ||
            self.element.equals("fire") && target.element.equals("plant") ||
            self.element.equals("plant") && target.element.equals("water"))
        {
            mult += 0.3;
        } else if (!self.element.equals(target.element)) {
            mult -= 0.3;
        }
        
        int damage = (int) Math.round(diceSum * ratio * mult);
        target.hp -= damage;
        
        String effectiveness;
        
        if (mult == 1) {
            effectiveness = "ordinary";
        } else if (mult < 1) {
            effectiveness = "ineffective";
        } else if (mult < 1.4) {
            effectiveness = "effective";
        } else {
            effectiveness = "very effective";
        }
        
        if (this.diceSide >= 8 && damage >= (this.diceSide+1)*self.level/2 * ratio * mult) {
            this.isUsable = false;
        }
        
        System.out.println(self.name + " uses " + this.name + " on " + target.name + " for " + damage + " damage! (" + target.name + " HP: " + target.hp + ")");
        if (!isUsable) {
            System.out.println(self.name + " went all out to deal massive damage! " + this.name + " becomes unusable until the end of this battle");
        } else {
            System.out.println("It was " + effectiveness + "!");
        }
    }
}
