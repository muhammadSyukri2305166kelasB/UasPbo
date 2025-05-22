/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

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

        player.resetAfterBattle();
        wild.resetAfterBattle();
        waitAndClear();
        
        System.out.println("\nBattle Over!");
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
            return true;
        } else if (wild.isAlive()) {
            System.out.println(wild.getName() + " wins!");
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
    private static void waitAndClear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        // clearConsole();
        // scanner.close(); // jangan di close
    }

    private static void PlayersTurn(Monster player, Monster wild, Scanner scanner, PlayersMonsters myDeck) {
        // Player's turn
        int choice = -1;
        while (choice < 1 || choice >= player.getMoves().size() + 1) {
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
                choice = scanner.nextInt() - 1;
                if (choice == -1) {
                    if (TangkapMonster.TangkapMonsterLiar(wild, myDeck)) {
                        //berhasil ditangkap, dan battle otomatis selesai
                        // "otomatis selesai" dilaksanakan dengan meng-0-kan hp musuh
                        wild.setHp(0);
                        return;
                    } else {
                        // gagal, battle berlanjut seperti biasa
                    }
                } else {
                    scanner.nextLine();
                    System.out.println(player.getMoves().get(choice).toString());
                    System.out.println("Apakah Anda yakin? (y/t)");
                    String confirm = scanner.nextLine().trim();

                    if (confirm.equalsIgnoreCase("t")) {
                        choice = -1; // ulangi input
                    } else {
                        player.useMoves(choice, wild);
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
