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
        
//        Monster jethorn = new MonsterJethorn("Jethorn", 1);

        kerenmonExe(scanner);
        
        Monster embercub = new MonsterEmbercub("Embercub", 1);
        Monster droplett = new MonsterDroplett("Droplett", 1);
        
        Battle.PlayerVsWild(embercub, droplett);

        scanner.close();
    }
    
    public static void kerenmonExe (Scanner scanner) {
        int pilihan = 0;
        do {
            System.out.println("""
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@            @@@@@@            @@@@@@          @@@@@@@@            @@@@@@@            @@@@@@              @@@@@@@        @@@@@@@@            @@@@@@@@
@@@@@@@   @@    @@   @@@@   @@@@@@@@   @@@@   @@@@@@    @@@@@   @@@@@@@@   @@@@@   @@    @@   @@@@   @@      @@   @@@@    @@@@    @@@@@   @@    @@   @@@@@@@
@@@@@@@   @@  @@    @@@@@   @@        @@@@@   @@    @@   @@@@   @@        @@@@@@   @@@@  @@   @@@@   @@@@  @@@@   @@@   @@    @@   @@@@   @@@@  @@   @@@@@@@
@@@@@@@   @@@@    @@@@@@@   @@@@@@     @@@@   @@@@@@    @@@@@   @@@@@@     @@@@@   @@  @@@@   @@@@   @@  @@  @@   @@@   @@    @@   @@@@   @@  @@@@   @@@@@@@
@@@@@@@   @@  @@    @@@@@   @@        @@@@@   @@  @@    @@@@@   @@        @@@@@@   @@    @@   @@@@   @@      @@   @@@   @@    @@   @@@@   @@    @@   @@@@@@@
@@@@@@@   @@    @@   @@@@   @@@@@@@@   @@@@   @@    @@   @@@@   @@@@@@@@   @@@@@   @@    @@   @@@@   @@      @@   @@@@    @@@@    @@@@@   @@    @@   @@@@@@@
@@@@@@@@            @@@@@@            @@@@@@            @@@@@@            @@@@@@@            @@@@@@              @@@@@@         @@@@@@@@            @@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                                                                                                                                version: 1.0
            """);
            System.out.println("[1] Start");
            System.out.println("[2] Credits");
            System.out.println("[3] Exit");
            System.out.println();
            
            System.out.print("Masukkan pilihan Anda: ");
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        } while (pilihan < 1 || pilihan > 3);
    }
}