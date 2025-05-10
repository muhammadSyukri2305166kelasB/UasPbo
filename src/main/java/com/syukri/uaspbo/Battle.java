/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Battle {
    public static void PlayerVsWild (Monster player, Monster wild) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int round = 1;
        
        System.out.println("Monster player:");
        System.out.println(player.toString());
        System.out.println("---------------");
        System.out.println("Monster liar:");
        System.out.println(wild.toString());
        
        waitAndClear();
        
        while (player.isAlive() && wild.isAlive()) {
            System.out.println("\n---- Round " + round + " ----");
            System.out.println("Your HP: " + player.getHp() + "/" + player.getMaxHp() + " | "
                             + "Enemy HP: " + wild.getHp() + "/" + wild.getMaxHp());
            
            if (wild.getSpeed() > player.getSpeed() && round == 1) {
                // wild's turn (basic random AI)
                int wildMoveIndex = rand.nextInt(wild.getMoves().size() - 1);
                if (wild.getMoves().get(wildMoveIndex) instanceof Heal) {
                    wild.useMoves(wildMoveIndex, wild); // Heal
                } else {
                    wild.useMoves(wildMoveIndex, player); // Punch
                }
            }
            waitAndClear();
            
            // Player's turn
            int choice = -1;
            while (choice < 0 || choice >= player.getMoves().size()) {
                System.out.println("Pilih Gerakan:");
//                List available Moves
                for (int i = 0; i < player.getMoves().size(); i++) {
                    if (player.getMoves().get(i) instanceof Attack) {
                        if (!((Attack)player.getMoves().get(i)).isIsUsable()) {
                            continue;
                        }
                    }
                    System.out.println(i + ": " + player.getMoves().get(i).getName());
                }
                System.out.print("Masukkan nomor gerakan: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(player.getMoves().get(choice).toString());
                    System.out.println("Apakah Anda yakin? (y/t)");
                    String confirm = scanner.nextLine().trim();
                    
                    if (confirm.equalsIgnoreCase("t")) {
                        choice = -1; // ulangi input
                    }
                } else {
                    scanner.next(); // consume invalid input
                }
            }

            player.useMoves(choice, wild);
            waitAndClear();
            if (!wild.isAlive()) break;
            
            if (wild.getSpeed() > player.getSpeed()) {
                round++;
            }
            
            int wildMoveIndex = rand.nextInt(wild.getMoves().size() - 1);
            if (wild.getMoves().get(wildMoveIndex) instanceof Heal) {
                wild.useMoves(wildMoveIndex, wild); // Heal
            } else {
                wild.useMoves(wildMoveIndex, player); // Punch
            }
            waitAndClear();

            if (wild.getSpeed() <= player.getSpeed()) {
                round++;
            }
        }
        
        System.out.println("\nBattle Over!");
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
        } else if (wild.isAlive()) {
            System.out.println(wild.getName() + " wins!");
        } else {
            System.out.println("Draw!");
        }
        waitAndClear();
        
        player.resetAfterBattle();
        wild.resetAfterBattle();
        
        scanner.close();
    }
    
//    tidak bisa dilakukan di netbeans
//    private static void clearConsole() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
    
    private static void waitAndClear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
//        clearConsole();
//        scanner.close(); // jangan di close
    }

}
