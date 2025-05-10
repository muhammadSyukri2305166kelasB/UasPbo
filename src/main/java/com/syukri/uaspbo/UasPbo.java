/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.syukri.uaspbo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class UasPbo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Moves flamingArrow = new Attack("Flaming Arrow", 6, "fire");
//
//        Moves crashingWave = new Attack("Crashing Wave", 6, "water");
//        Moves waterGun = new Attack("Water Gun", 4, "water");
//        
//        Moves growThorn = new Attack("Grow Thorn", 4, "plant");
//        Moves thousandLeavesHurricane = new Attack("Thousand Leaves Hurricane", 8, "plant");
//        
//        Moves lickWounds = new Heal("Lick Wounds", 6);
//        Moves cauterize = new Heal("Cauterize", 4);
//        Moves calmingWater = new Heal("Calming Water", 8);
//        Moves barkSkin = new Heal("Bark Skin", 6);
        
        Monster embercub = new MonsterEmbercub("Embercub", 1);

        Monster droplett = new MonsterDroplett("Droplett", 1);

//        Monster jethorn = new MonsterJethorn("Jethorn", 1);
        
        Battle.PlayerVsWild(embercub, droplett);

        scanner.close();
    }
}