/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;
import java.util.Random;

/**
 *
 * @author HP
 */
public abstract class Moves {
    private String name;
    private String desc = "defaultDescription";
    private int diceSide;
    private boolean isUsable = true;

    public Moves(String name, int diceSide) {
        this.name = name;
        this.diceSide = diceSide;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isIsUsable() {
        return isUsable;
    }

    public void setIsUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }
    

    public abstract void execute(Monster self, Monster target);

    public int getDiceSide() {
        return diceSide;
    }

    public void setDiceSide(int diceSide) {
        this.diceSide = diceSide;
    }
}
