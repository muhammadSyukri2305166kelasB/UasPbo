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
    private String name;
    private int level;
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int speed = 2;
    private Moves[] moves;
    private String element;

    public Monster(String name, int level, int maxHp, int hp, int attack, int defense, Moves[] moves) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
        this.element = "none";
    }

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
            this.moves[i].setIsUsable(true);
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public Moves[] getMoves() {
        return moves;
    }

    public String getElement() {
        return element;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMoves(Moves[] moves) {
        this.moves = moves;
    }

    public void setElement(String element) {
        this.element = element;
    }
    
    
}
