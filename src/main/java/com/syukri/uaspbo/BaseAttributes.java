/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
public class BaseAttributes {
    private int hitpoints;
    private int basicAttack;
    private int basicDefense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public BaseAttributes(int hitpoints, int basicAttack, int basicDefense, int specialAttack, int specialDefense, int speed) {
        this.hitpoints = hitpoints;
        this.basicAttack = basicAttack;
        this.basicDefense = basicDefense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getBasicAttack() {
        return basicAttack;
    }

    public void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }

    public int getBasicDefense() {
        return basicDefense;
    }

    public void setBasicDefense(int basicDefense) {
        this.basicDefense = basicDefense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    
}
