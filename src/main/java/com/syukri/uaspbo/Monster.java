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
    int hp;
    int attack;
    int defense;
    Moves[] moves;

    public Monster(String name, int level, int hp, int attack, int defense, Moves[] moves) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
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
}
