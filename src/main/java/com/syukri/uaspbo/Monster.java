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

class Monster {
    String name;
    int level;
    int maxHp;
    int hp;
    int attack;
    int defense;
    int speed = 2;
    Moves[] moves;
    String element = "none";

    public Monster(String name, int level, int hp, int attack, int defense, Moves[] moves, String element) {
        this.name = name;
        this.level = level;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
        this.element = element;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public int rollDice(int numDice, int sides) {
        Random rand = new Random();
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += rand.nextInt(sides) + 1;
        }
        return total;
    }

    public void useMoves(int index, Monster target) {
        moves[index].execute(this, target);
    }
    
    public void resetAfterBattle() {
        this.hp = this.maxHp;
        for (int i = 0; i < this.moves.length; i++) {
            this.moves[i].isUsable = true;
        }
    }
}
