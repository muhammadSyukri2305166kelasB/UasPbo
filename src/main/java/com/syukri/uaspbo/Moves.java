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
    String name;
    boolean isUsable = true;

    public Moves(String name) {
        this.name = name;
    }

    public abstract void execute(Monster self, Monster target);
}
