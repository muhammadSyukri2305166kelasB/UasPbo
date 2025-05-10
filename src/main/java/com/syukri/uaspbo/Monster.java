/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
import java.util.List;
import java.util.ArrayList;

public abstract class Monster {
    private String name;
    private int level;
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<Moves> moves;
    private String element; // element adalah variabel konstanta/tidak bisa diubah

    // konstruktor

    public Monster(String name, int level) {
        // random attribute
        this.name = name;
        this.level = level;
        this.maxHp = DiceRoller.rollTotalKeepHighest(2+this.level, 10, this.level); // roll 4d8, ambil 1 terbesar
        this.hp = this.maxHp;
        this.attack = DiceRoller.rollTotalKeepHighest(2+this.level, 3, this.level);
        this.defense = DiceRoller.rollTotalKeepLowest(2+this.level, 3, this.level);
        this.speed = DiceRoller.rollDice(1, 10); // roll 1 d10
        this.moves = new ArrayList<>(); // masih kosong, akan diisi di class konkret
        this.element = "none";
    }
    
    public Monster(String name, int level, int maxHp, int attack, int defense,int speed, ArrayList<Moves> moves) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = new ArrayList<>(moves);
        this.element = "none";
    }

    public Monster(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves, String element) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = new ArrayList<>(moves);
        this.element = element;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void useMoves(int index, Monster target) {
        moves.get(index).execute(this, target);
    }
    
    public void resetAfterBattle() {
        this.hp = this.maxHp;
        for (int i = 0; i < this.moves.size(); i++) {
            if (this.getMoves().get(i) instanceof Attack) {
                ((Attack)this.getMoves().get(i)).setIsUsable(true);
            }
        }
    }

    // getter dan setter
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

    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public String getElement() {
        return element;
    }

    public void setName(String name) {
        this.name = name;
    }

//    tidak bisa sembarangan atur level, tapi bisa level up
//    public void setLevel(int level) {
//        this.level = level;
//    }
    
    public void levelUp(){
        this.level++;
        this.maxHp += DiceRoller.rollTotalKeepHighest(2, 10, 1);
        this.hp = this.maxHp;
        this.attack += DiceRoller.rollTotalKeepLowest(2, 3, 1);
        this.defense += DiceRoller.rollTotalKeepHighest(2, 3, 1);
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

    public void setMoves(ArrayList<Moves> moves) {
        this.moves = (moves == null) ? new ArrayList<>() : new ArrayList<>(moves);
    }
    // selain bisa "menimpa" list moves, bisa juga hanya menambah atau menghilangkan
    public void addMoves(Moves moves) {
        this.moves.add(moves);
    }

//    element tidak bisa diubah
    protected void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monster{");
        sb.append("\nname=").append(name);
        sb.append(", \nlevel=").append(level);
        sb.append(", \nmaxHp=").append(maxHp);
        sb.append(", \nhp=").append(hp);
        sb.append(", \nattack=").append(attack);
        sb.append(", \ndefense=").append(defense);
        sb.append(", \nspeed=").append(speed);
        sb.append(", \nmoves=[");
        for (int i = 0; i < moves.size(); i++) {
            sb.append(moves.get(i).getName());
            if (i < moves.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append(", \nelement=").append(element);
        sb.append("\n}");
        return sb.toString();
    }
    
}
