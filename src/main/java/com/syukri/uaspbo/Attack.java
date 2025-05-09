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
    private String element = "none";
    
    public Attack(String name, int diceSide, String element) {
        super(name, diceSide);
        this.element = element;
    }

    @Override
    public void execute(Monster self, Monster target) {
        int diceSum = self.rollDice(self.getLevel(), this.getDiceSide());
        double ratio = (double) self.getAttack() / target.getDefense();
        double mult = 1.0;
        
        if (this.element.equals(self.getElement()) && !this.element.equals("none")) {
            mult += 0.2;
        }
        
        if (self.getElement().equals("water") && target.getElement().equals("fire") ||
            self.getElement().equals("fire") && target.getElement().equals("plant") ||
            self.getElement().equals("plant") && target.getElement().equals("water"))
        {
            mult += 0.3;
        } else if (!self.getElement().equals(target.getElement())) {
            mult -= 0.3;
        }
        
        int damage = (int) Math.round(diceSum * ratio * mult);
        target.setHp(target.getHp() - damage);
        
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
        
        if (this.getDiceSide() >= 8 && damage >= (this.getDiceSide()+1)*self.getLevel()/2 * ratio * mult) {
            this.setIsUsable(false);
        }
        
        System.out.println(self.getName() + " uses " + this.getName() + " on " + target.getName() + " for " + damage + " damage! (" + target.getName() + " HP: " + target.getHp() + ")");
        if (!this.isIsUsable()) {
            System.out.println(self.getName() + " went all out to deal massive damage! " + this.getName() + " becomes unusable until the end of this battle");
        } else {
            System.out.println("It was " + effectiveness + "!");
        }
    }

    public String getElement() {
        return element;
    }

//    public void setElement(String element) {
//        this.element = element;
//    }
    
    
}
