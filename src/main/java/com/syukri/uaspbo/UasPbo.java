/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.syukri.uaspbo;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class UasPbo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Moves kick = new Attack("Kick", 4, "none");
        Moves claw = new Attack("Claw", 6, "none");
        
        Moves flamingArrow = new Attack("Flaming Arrow", 6, "fire");
        Moves firePunch = new Attack("Fire Punch", 4, "fire");
        
        Moves crashingWave = new Attack("Crashing Wave", 6, "water");
        Moves waterGun = new Attack("Water Gun", 4, "water");
        
        Moves growThorn = new Attack("Grow Thorn", 4, "plant");
        Moves thousandLeavesHurricane = new Attack("Thousand Leaves Hurricane", 8, "plant");
        
        Moves lickWounds = new Heal("Lick Wounds", 6);
        Moves cauterize = new Heal("Cauterize", 4);
        Moves calmingWater = new Heal("Calming Water", 8);
        Moves barkSkin = new Heal("Bark Skin", 6);
        
        
        Moves[] embercubMoves = { kick, claw, firePunch };
        Monster embercub = new Monster("Embercub", 3, 42, 12, 8, embercubMoves, "fire");

        Moves[] droplettMoves = { waterGun, calmingWater};
        Monster droplett = new Monster("Droplett", 3, 30, 10, 10, droplettMoves, "water");

        Moves[] jethornMoves = { growThorn, thousandLeavesHurricane, kick };
        Monster jethorn = new Monster("Jethorn", 3, 42, 14, 6, jethornMoves, "plant");
        
        Battle.PlayerVsWild(jethorn, embercub);

        scanner.close();
    }
}