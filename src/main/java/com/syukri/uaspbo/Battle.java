/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import com.syukri.uaspbo.moves.*;
import com.syukri.uaspbo.pokemons.Monster;
import java.util.Scanner;

import com.syukri.uaspbo.pokemons.MonsterViewer;
//import com.syukri.uaspbo.pokemons.*;

/**
 *
 * @author HP
 */
public class Battle {

    public static boolean PlayerVsWild(Monster player, Monster wild, Scanner scanner, PlayersMonsters myDeck) {
        try {
            MonsterViewer.BattleView(player.getViewSource(), wild.getViewSource());
        } catch (Exception e) {
            System.out.println("gagal menampilkan view");
        }
        int round = 1;

        System.out.println("Monster player:");
        System.out.println(player.toString());
        System.out.println("---------------");
        System.out.println("Monster liar:");
        System.out.println(wild.toString());

        waitAndClear();

        while (player.isAlive() || wild.isAlive()) {
            System.out.println("\n---- Round " + round + " ----");
            System.out.println("Your HP: " + player.getHp() + "/" + player.getMaxHp() + " | "
                    + "Enemy HP: " + wild.getHp() + "/" + wild.getMaxHp());

            if (wild.getSpeed() > player.getSpeed()) {
                WildsTurn(player, wild);
                if (!player.isAlive() || !wild.isAlive()) {
                    break;
                }

                PlayersTurn(player, wild, scanner, myDeck);
                if (!player.isAlive() || !wild.isAlive()) {
                    break;
                }

                round++;
            } else {
                PlayersTurn(player, wild, scanner, myDeck);
                if (!player.isAlive() || !wild.isAlive()) {
                    break;
                }

                WildsTurn(player, wild);
                if (!player.isAlive() || !wild.isAlive()) {
                    break;
                }

                round++;
            }
        }

        System.out.println("\nBattle Over!");
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
            int exp;
            if ((player.getLevel() - wild.getLevel()) < 1) {
                exp = (int) Math.round(
                        ((player.getLevel() + 1) / (double) player.getLevel() * (5 + DiceRoller.rollDice(3, 4))));
            } else {
                exp = (player.getLevel() - wild.getLevel()) * (int) Math.round(
                        ((player.getLevel() + 1) / (double) player.getLevel() * (5 + DiceRoller.rollDice(3, 4))));
            }
            player.setExp(player.getExp() + exp);
            System.out.printf("Monstermu mendapatkan %d exp!\n", exp);
            return true;
        } else if (wild.isAlive()) {
            System.out.println(wild.getName() + " wins!");
            System.out.println("You lose :(");
            return false;
        } else {
            System.out.println("Draw!");
            return true;
        }
    }

    // tidak bisa dilakukan di netbeans
    // private static void clearConsole() {
    // System.out.print("\033[H\033[2J");
    // System.out.flush();
    // }
    public static void waitAndClear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        // clearConsole();
        // scanner.close(); // jangan di close
    }

    private static void PlayersTurn(Monster player, Monster wild, Scanner scanner, PlayersMonsters myDeck) {
        // Player's turn
        int choice = -1;
        while (choice <= 0 || choice >= player.getMoves().size() + 1) {
            System.out.println("Pilih Gerakan:");
            // pilihan untuk menangkap monster liar
            System.out.println("0: Tangkap Monster liar ini");
            // List available Moves
            for (int i = 0; i < player.getMoves().size(); i++) {
                if (player.getMoves().get(i) instanceof Attack attack) { // instanceof pattern
                    if (!attack.isIsUsable()) {
                        continue;
                    }
                }
                System.out.println((i + 1) + ": " + player.getMoves().get(i).getName());
            }
            System.out.print("Masukkan nomor gerakan: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 0) {
                    if (TangkapMonster.TangkapMonsterLiar(wild, myDeck)) {
                        // berhasil ditangkap, dan battle otomatis selesai
                        // "otomatis selesai" dilaksanakan dengan meng-0-kan hp musuh
                        System.out.println(wild.getName() + " Berhasil di tangkap!\nSekarang dia ada di Deck mu");
                        wild.setHp(0);
                        return;
                    } else {
                        // gagal, battle berlanjut seperti biasa
                        return;
                    }
                } else {
                    scanner.nextLine();
                    System.out.println(player.getMoves().get(choice - 1).toString());
                    System.out.println("Apakah Anda yakin? (y/t)");
                    String confirm = scanner.nextLine().trim();

                    if (confirm.equalsIgnoreCase("t")) {
                        choice = -1; // ulangi input
                    } else {
                        player.useMoves(choice - 1, wild);
                        waitAndClear();
                    }
                }
            } else {
                scanner.next(); // consume invalid input
            }
        }
    }

    private static void WildsTurn(Monster player, Monster wild) {
        // wild's turn (basic random AI)
        int wildMoveIndex = DiceRoller.rollDice(1, wild.getMoves().size()) - 1;
        if (wild.getMoves().get(wildMoveIndex) instanceof Heal) {
            wild.useMoves(wildMoveIndex, wild); // Heal
        } else {
            wild.useMoves(wildMoveIndex, player); // Punch
        }
        waitAndClear();
    }
}
