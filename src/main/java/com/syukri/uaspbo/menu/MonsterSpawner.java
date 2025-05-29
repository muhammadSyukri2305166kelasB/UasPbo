package com.syukri.uaspbo.menu;

import java.util.*;

import com.syukri.uaspbo.DiceRoller;
import com.syukri.uaspbo.PlayerData;
import com.syukri.uaspbo.pokemons.Monster;
import com.syukri.uaspbo.pokemons.MonsterSelector;

public class MonsterSpawner {
    public static Monster getMonster(String element, PlayerData myDeck) {
        ArrayList<Monster> PlayersMonsters = myDeck.getPlayersMonsters();

        int sum = 0;
        int count = 0;
        int avg = 0;
        for (int i = 0; i < PlayersMonsters.size(); i++) {
            if (PlayersMonsters.get(i).getElement().equalsIgnoreCase(element)) {
                sum += PlayersMonsters.get(i).getLevel();
                count++;
            }
        }
        if (count == 0) {
            avg = 1;
        } else if (sum == 0) {
            avg = 1;
        } else {
            avg = sum / count;
        }

        int totalRarity = 0;
        MonsterSelector CS = new MonsterSelector();
        ArrayList<Monster> wildMonster = CS.all(element, avg);

        for (int i = wildMonster.size() - 1; i >= 0; i--) {
            totalRarity += wildMonster.get(i).getSpawnRarity();
        }
        int mainChance = DiceRoller.rollDice(1, totalRarity);
        mainChance += 99;
        int i = 0;
        Monster picked = wildMonster.get(1);
        while (mainChance >= 0 && i < wildMonster.size()) {
            if (wildMonster.get(i).getSpawnRarity() < mainChance) {
                mainChance -= wildMonster.get(i).getSpawnRarity();
            } else {
                picked = wildMonster.get(i);
                break;
            }
            i++;
        }
        return picked;
    }

    public static void main(String[] args) {
        PlayerData myDeck = new PlayerData();
        myDeck.test();
        // System.out.println(getMonster("none", myDeck));
        // System.out.println(getMonster("fire", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        System.out.println(getMonster("water", myDeck));
        // System.out.println(getMonster("plant", myDeck));
    }

}
