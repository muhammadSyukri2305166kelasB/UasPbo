/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.pokemons;

/**
 *
 * @author HP
 */
import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.DiceRoller;
import com.syukri.uaspbo.Moves;
import java.io.Serializable;
import java.util.ArrayList;

//import com.syukri.uaspbo.pokemons.MonsterViewer;

public abstract class Monster implements Serializable {
    private String name;
    private String Description = "Default Monster Description";
    private int level;
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<Moves> moves;
    private String element; // element adalah variabel konstanta/tidak bisa diubah
    private String ViewSource; // doksli gambar pixel nya
    private int spawnRarity;
    private int exp = 0;

    // konstruktor

    public Monster(String name, int level, String ViewSource, int spawnRarity) {
        // basic attribute
        this.name = name;
        this.level = level;
        this.maxHp = 10 + level * 21; // 10 + rollDice(6 * level, 6)
        this.hp = this.maxHp;
        this.attack = 8 + Math.round(level * 1.5f); // 8 + rollDice(level, 2)
        this.defense = 6 + level; // 6 + (rollDice(level, 3) / 2)
        this.speed = DiceRoller.rollDice(1, 10); // roll 1 d10
        this.moves = new ArrayList<>(); // masih kosong, akan diisi di class konkret
        this.element = "none";
        this.ViewSource = ViewSource;
        this.spawnRarity = spawnRarity;
    }

    public Monster(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = new ArrayList<>(moves);
        this.element = "none";
        this.ViewSource = ViewSource;
        this.spawnRarity = spawnRarity;
    }

    public Monster(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = new ArrayList<>(moves);
        this.element = element;
        this.ViewSource = ViewSource;
        this.spawnRarity = spawnRarity;
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
                ((Attack) this.getMoves().get(i)).setIsUsable(true);
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

    public String getViewSource() {
        return ViewSource;
    }

    public String getDescription() {
        return Description;
    }

    public void setName(String name) {
        this.name = name;
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

    // element tidak bisa diubah
    protected void setElement(String element) {
        this.element = element;
    }

    public void setViewSource(String viewSource) {
        ViewSource = viewSource;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSpawnRarity() {
        return spawnRarity;
    }
    
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
    // tidak bisa sembarangan atur level, tapi bisa level up
    // public void setLevel(int level) {
    // this.level = level;
    // }

    public void levelUp () {
        if (this.exp >= this.level * 20) {
            //bisa level up
            this.exp -= this.level * 20;
            this.level++;
            this.maxHp += DiceRoller.rollDice(6, 6); // average 21.5
            this.hp = this.maxHp;
            this.attack += DiceRoller.rollDice(1, 2);
            this.defense += DiceRoller.rollDice(1, 3) / 2;
            
            System.out.println("Berhasil level up!");
        } else {
            System.out.printf("Exp belum cukup (%d / %d)\n", this.getExp(), this.getLevel() * 20);
            System.out.println("Gagal level up!");
        }
        
    }

    public void view() {
        try {
            MonsterViewer.CharacterSelectionView(this.ViewSource);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.printf("%s : %s\n", getName(), getDescription());
        System.out.println("Rarity \t\t: " + getSpawnRarity() + "%");
        System.out.println("Level \t\t: " + getLevel());
        System.out.println("Hp \t\t: " + getMaxHp());
        System.out.println("Attack \t\t: " + getAttack());
        System.out.println("Defense \t: " + getDefense());
        System.out.println("Element \t: " + getElement());
        System.out.println("Speed \t\t: " + getSpeed());
        System.out.println("Moves \t\t: ");
        for (int i = 0; i < getMoves().size(); i++) {
            System.out.println("[" + i + "] " + getMoves().get(i).view());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monster{");
        sb.append("name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", maxHp=").append(maxHp);
        sb.append(", hp=").append(hp);
        sb.append(", attack=").append(attack);
        sb.append(", defense=").append(defense);
        sb.append(", speed=").append(speed);
        sb.append(", moves=[");
        for (int i = 0; i < moves.size(); i++) {
            sb.append(moves.get(i).getName());
            if (i < moves.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append(", element=").append(element);
        sb.append('}');
        return sb.toString();
    }

}
