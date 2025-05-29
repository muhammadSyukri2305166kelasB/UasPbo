package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import java.util.Scanner;
import com.syukri.uaspbo.PlayerData;

public class MonsterSelector {

    public static void main(String[] args) {
        PlayerData myDeck = new PlayerData();
        myDeck.test();
        myDeck.Load();
        for (int i = 0; i < myDeck.getPlayersMonsters().size(); i++) {
            Monster pokemon = myDeck.getPlayersMonsters().get(i);
            System.out.printf("[%d] %s : %s\n", i + 1, pokemon.getName(), pokemon.getDescription());
        }
        System.out.print("Masukkan Kerenmon yang akan kamu pilih : ");
        Scanner in = new Scanner(System.in);
        Monster picked = myDeck.getPlayersMonsters().get(in.nextInt() - 1);
        picked.view();
        in.close();
    }

    public static Monster pickMonster(PlayerData myDeck, Scanner in) {
        int choice = -1;
        Monster picked = myDeck.getPlayersMonsters().get(0);

        for (int i = 0; i < myDeck.getPlayersMonsters().size(); i++) {
            Monster pokemon = myDeck.getPlayersMonsters().get(i);
            System.out.printf("[%d] %s level %d (%s) \n", i + 1, pokemon.getName(), pokemon.getLevel(),
                    pokemon.getElement());
        }
        System.out.print("Masukkan Kerenmon yang akan kamu pilih : ");
        do {
            choice = in.nextInt() - 1;
            if (choice >= 0 && choice < myDeck.getPlayersMonsters().size()) {
                picked = myDeck.getPlayersMonsters().get(choice);
                return picked;
            } else
                System.out.print("Pilihan tidak valid! silahkan pilih lagi : ");
            choice = -1;
        } while (choice == -1);
        return picked;
    }

    public static ArrayList<Monster> all() {
        ArrayList<Monster> allMonsters = new ArrayList<>();
        allMonsters.add(new FireSmolava("Smolava", 1));
        allMonsters.add(new FireSukaryon("Sukaryon", 1));
        allMonsters.add(new FireVoltrik("Voltrik", 1));
        allMonsters.add(new WaterBanyu("Banyu", 1));
        allMonsters.add(new WaterMizumon("Mizumon", 1));
        allMonsters.add(new WaterSamequill("Samequill", 1));
        allMonsters.add(new PlantChurippi("Churippi", 1));
        allMonsters.add(new PlantKurikar("Kurikar", 1));
        allMonsters.add(new PlantOriza("Oriza", 1));
        allMonsters.add(new BasicFluffawn("Fluffawn", 1));
        allMonsters.add(new BasicNubbi("Nubbi", 1));
        allMonsters.add(new BasicLopreign("Lopreign", 1));
        return allMonsters;
    }

    public ArrayList<Monster> all(String element, int level) {
        ArrayList<Monster> allMonsters = new ArrayList<>();
        if (level == 1) {
            for (int i = 0; i < 2; i++) {
                if (element.equalsIgnoreCase("fire")) {
                    allMonsters.add(new FireSmolava("Smolava", level));
                    allMonsters.add(new FireSukaryon("Sukaryon", level));
                    allMonsters.add(new FireVoltrik("Voltrik", level));
                } else if (element.equalsIgnoreCase("water")) {
                    allMonsters.add(new WaterBanyu("Banyu", level));
                    allMonsters.add(new WaterMizumon("Mizumon", level));
                    allMonsters.add(new WaterSamequill("Samequill", level));
                } else if (element.equalsIgnoreCase("plant")) {
                    allMonsters.add(new PlantChurippi("Churippi", level));
                    allMonsters.add(new PlantKurikar("Kurikar", level));
                    allMonsters.add(new PlantOriza("Oriza", level));
                } else {
                    allMonsters.add(new BasicFluffawn("Fluffawn", level));
                    allMonsters.add(new BasicNubbi("Nubbi", level));
                    allMonsters.add(new BasicLopreign("Lopreign", level));
                }
            }

            if (element.equalsIgnoreCase("fire")) {
                allMonsters.add(new FireSmolava("Smolava", level + 1));
                allMonsters.add(new FireSukaryon("Sukaryon", level + 1));
                allMonsters.add(new FireVoltrik("Voltrik", level + 1));
            } else if (element.equalsIgnoreCase("water")) {
                allMonsters.add(new WaterBanyu("Banyu", level + 1));
                allMonsters.add(new WaterMizumon("Mizumon", level + 1));
                allMonsters.add(new WaterSamequill("Samequill", level + 1));
            } else if (element.equalsIgnoreCase("plant")) {
                allMonsters.add(new PlantChurippi("Churippi", level + 1));
                allMonsters.add(new PlantKurikar("Kurikar", level + 1));
                allMonsters.add(new PlantOriza("Oriza", level + 1));
            } else {
                allMonsters.add(new BasicFluffawn("Fluffawn", level + 1));
                allMonsters.add(new BasicNubbi("Nubbi", level + 1));
                allMonsters.add(new BasicLopreign("Lopreign", level + 1));
            }
        } else if (level == 10) {
            for (int i = 0; i < 2; i++) {
                if (element.equalsIgnoreCase("fire")) {
                    allMonsters.add(new FireSmolava("Smolava", level));
                    allMonsters.add(new FireSukaryon("Sukaryon", level));
                    allMonsters.add(new FireVoltrik("Voltrik", level));
                } else if (element.equalsIgnoreCase("water")) {
                    allMonsters.add(new WaterBanyu("Banyu", level));
                    allMonsters.add(new WaterMizumon("Mizumon", level));
                    allMonsters.add(new WaterSamequill("Samequill", level));
                } else if (element.equalsIgnoreCase("plant")) {
                    allMonsters.add(new PlantChurippi("Churippi", level));
                    allMonsters.add(new PlantKurikar("Kurikar", level));
                    allMonsters.add(new PlantOriza("Oriza", level));
                } else {
                    allMonsters.add(new BasicFluffawn("Fluffawn", level));
                    allMonsters.add(new BasicNubbi("Nubbi", level));
                    allMonsters.add(new BasicLopreign("Lopreign", level));
                }
            }

            if (element.equalsIgnoreCase("fire")) {
                allMonsters.add(new FireSmolava("Smolava", level - 1));
                allMonsters.add(new FireSukaryon("Sukaryon", level - 1));
                allMonsters.add(new FireVoltrik("Voltrik", level - 1));
            } else if (element.equalsIgnoreCase("water")) {
                allMonsters.add(new WaterBanyu("Banyu", level - 1));
                allMonsters.add(new WaterMizumon("Mizumon", level - 1));
                allMonsters.add(new WaterSamequill("Samequill", level - 1));
            } else if (element.equalsIgnoreCase("plant")) {
                allMonsters.add(new PlantChurippi("Churippi", level - 1));
                allMonsters.add(new PlantKurikar("Kurikar", level - 1));
                allMonsters.add(new PlantOriza("Oriza", level - 1));
            } else {
                allMonsters.add(new BasicFluffawn("Fluffawn", level - 1));
                allMonsters.add(new BasicNubbi("Nubbi", level - 1));
                allMonsters.add(new BasicLopreign("Lopreign", level - 1));
            }
        } else {
            for (int i = 0; i < 2; i++) {
                if (element.equalsIgnoreCase("fire")) {
                    allMonsters.add(new FireSmolava("Smolava", level));
                    allMonsters.add(new FireSukaryon("Sukaryon", level));
                    allMonsters.add(new FireVoltrik("Voltrik", level));
                } else if (element.equalsIgnoreCase("water")) {
                    allMonsters.add(new WaterBanyu("Banyu", level));
                    allMonsters.add(new WaterMizumon("Mizumon", level));
                    allMonsters.add(new WaterSamequill("Samequill", level));
                } else if (element.equalsIgnoreCase("plant")) {
                    allMonsters.add(new PlantChurippi("Churippi", level));
                    allMonsters.add(new PlantKurikar("Kurikar", level));
                    allMonsters.add(new PlantOriza("Oriza", level));
                } else {
                    allMonsters.add(new BasicFluffawn("Fluffawn", level));
                    allMonsters.add(new BasicNubbi("Nubbi", level));
                    allMonsters.add(new BasicLopreign("Lopreign", level));
                }
            }

            if (element.equalsIgnoreCase("fire")) {
                allMonsters.add(new FireSmolava("Smolava", level + 1));
                allMonsters.add(new FireSukaryon("Sukaryon", level + 1));
                allMonsters.add(new FireVoltrik("Voltrik", level + 1));
            } else if (element.equalsIgnoreCase("water")) {
                allMonsters.add(new WaterBanyu("Banyu", level + 1));
                allMonsters.add(new WaterMizumon("Mizumon", level + 1));
                allMonsters.add(new WaterSamequill("Samequill", level + 1));
            } else if (element.equalsIgnoreCase("plant")) {
                allMonsters.add(new PlantChurippi("Churippi", level + 1));
                allMonsters.add(new PlantKurikar("Kurikar", level + 1));
                allMonsters.add(new PlantOriza("Oriza", level + 1));
            } else {
                allMonsters.add(new BasicFluffawn("Fluffawn", level + 1));
                allMonsters.add(new BasicNubbi("Nubbi", level + 1));
                allMonsters.add(new BasicLopreign("Lopreign", level + 1));
            }

            if (element.equalsIgnoreCase("fire")) {
                allMonsters.add(new FireSmolava("Smolava", level - 1));
                allMonsters.add(new FireSukaryon("Sukaryon", level - 1));
                allMonsters.add(new FireVoltrik("Voltrik", level - 1));
            } else if (element.equalsIgnoreCase("water")) {
                allMonsters.add(new WaterBanyu("Banyu", level - 1));
                allMonsters.add(new WaterMizumon("Mizumon", level - 1));
                allMonsters.add(new WaterSamequill("Samequill", level - 1));
            } else if (element.equalsIgnoreCase("plant")) {
                allMonsters.add(new PlantChurippi("Churippi", level - 1));
                allMonsters.add(new PlantKurikar("Kurikar", level - 1));
                allMonsters.add(new PlantOriza("Oriza", level - 1));
            } else {
                allMonsters.add(new BasicFluffawn("Fluffawn", level - 1));
                allMonsters.add(new BasicNubbi("Nubbi", level - 1));
                allMonsters.add(new BasicLopreign("Lopreign", level - 1));
            }
        }
        return allMonsters;
    }
}
