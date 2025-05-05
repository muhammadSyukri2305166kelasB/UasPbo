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

        Moves punch = new Attack("Punch");
        Moves claw = new Attack("Claw");
        Moves heal = new Heal("Recover", 8);

        // Embercub (Player)
        Moves[] embercubMovess = { punch, claw, null };
        Monster embercub = new Monster("Embercub", 3, 30, 12, 8, embercubMovess);

        // Droplett (AI)
        Moves[] droplettMovess = { punch, heal, null };
        Monster droplett = new Monster("Droplett", 3, 28, 10, 10, droplettMovess);

        int round = 1;
        while (embercub.isAlive() && droplett.isAlive()) {
            System.out.println("\n---- Round " + round + " ----");
            System.out.println("Your HP: " + embercub.hp + " | Enemy HP: " + droplett.hp);
            System.out.println("Choose your Moves:");

            // List available Movess
            for (int i = 0; i < embercub.moves.length - 1; i++) {
                System.out.println(i + ": " + embercub.moves[i].name);
            }

            int choice = -1;
            while (choice < 0 || choice >= embercub.moves.length) {
                System.out.print("Enter Moves number: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    scanner.next(); // consume invalid input
                }
            }

            // Player's turn
            embercub.useMoves(choice, droplett);
            if (!droplett.isAlive()) break;

            // Droplett's turn (basic AI)
            if (droplett.hp < 15) {
                droplett.useMoves(1, droplett); // Heal
            } else {
                droplett.useMoves(0, embercub); // Punch
            }

            round++;
        }

        System.out.println("\nBattle Over!");
        if (embercub.isAlive()) {
            System.out.println("🔥 " + embercub.name + " wins!");
        } else if (droplett.isAlive()) {
            System.out.println("💧 " + droplett.name + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }
}