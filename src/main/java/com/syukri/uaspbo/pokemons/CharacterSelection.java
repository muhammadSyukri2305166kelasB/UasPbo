package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import java.util.Scanner;
import com.syukri.uaspbo.Monster;
import com.syukri.uaspbo.PlayersMonsters;

public class CharacterSelection {
    public static void main(String[] args) {
        PlayersMonsters myDeck = new PlayersMonsters();
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

    public ArrayList<Monster> all() {
        ArrayList<Monster> allMonsters = new ArrayList<Monster>();
        allMonsters.add(new BasicFluffawn("Fluffawn", 1));
        allMonsters.add(new BasicNubbi("Nubbi", 1));
        allMonsters.add(new BasicLopreign("Lopreign", 1));
        allMonsters.add(new FireSmolava("Smolava", 1));
        allMonsters.add(new FireSukaryon("Sukaryon", 1));
        allMonsters.add(new FireVoltrik("Voltrik", 1));
        allMonsters.add(new PlantChurippi("Churippi", 1));
        allMonsters.add(new PlantKurikar("Kurikar", 1));
        allMonsters.add(new PlantOriza("Oriza", 1));
        allMonsters.add(new WaterBanyu("Banyu", 1));
        allMonsters.add(new WaterMizumon("Mizumon", 1));
        allMonsters.add(new WaterSamequill("Samequill", 1));
        return allMonsters;
    }
}
