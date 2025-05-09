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
        
        while (player.isAlive() && wild.isAlive()) {
            System.out.println("\n---- Round " + round + " ----");
            System.out.println("Your HP: " + player.getHp() + "/" + player.getMaxHp() + " | "
                             + "Enemy HP: " + wild.getHp() + "/" + wild.getMaxHp());
            
            if (wild.getSpeed() > player.getSpeed() && round == 1) {
                // wild's turn (basic random AI)
                int wildMoveIndex = rand.nextInt(wild.getMoves().length - 1);
                if (wild.getMoves()[wildMoveIndex] instanceof Heal) {
                    wild.useMoves(wildMoveIndex, wild); // Heal
                } else {
                    wild.useMoves(wildMoveIndex, player); // Punch
                }
            }
            
            // Player's turn
            System.out.println("Choose your Moves:");
            // List available Moves
            for (int i = 0; i < player.getMoves().length; i++) {
                if (!player.getMoves()[i].isIsUsable()) {
                    continue;
                }
                System.out.println(i + ": " + player.getMoves()[i].getName());
            }

            int choice = -1;
            while (choice < 0 || choice >= player.getMoves().length) {
                System.out.print("Enter Moves number: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    scanner.next(); // consume invalid input
                }
            }

            player.useMoves(choice, wild);
            if (!wild.isAlive()) break;
            
            if (wild.getSpeed() > player.getSpeed()) {
                round++;
            }
            
            int wildMoveIndex = rand.nextInt(wild.getMoves().length - 1);
            if (wild.getMoves()[wildMoveIndex] instanceof Heal) {
                wild.useMoves(wildMoveIndex, wild); // Heal
            } else {
                wild.useMoves(wildMoveIndex, player); // Punch
            }

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
            System.out.println("It's a draw!");
        }
        
        player.resetAfterBattle();
        wild.resetAfterBattle();
        
        scanner.close();
    }
    
    
}
