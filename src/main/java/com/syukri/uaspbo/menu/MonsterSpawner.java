package com.syukri.uaspbo.menu;

import java.util.*;

import com.syukri.uaspbo.DiceRoller;
import com.syukri.uaspbo.pokemons.Monster;
import com.syukri.uaspbo.pokemons.MonsterSelector;

public class MonsterSpawner {
    public static Monster getMonster(String element) {
        int totalRarity = 0;
        MonsterSelector CS = new MonsterSelector();
        ArrayList<Monster> wildMonster = CS.all();
        for (int i = wildMonster.size()-1; i >= 0; i--) {
            if (!wildMonster.get(i).getElement().equalsIgnoreCase(element)) {
                wildMonster.remove(i);
                continue;
            }
            totalRarity += wildMonster.get(i).getSpawnRarity();
        }
        int mainChance = DiceRoller.rollDice(1, totalRarity);
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
        
        System.out.println(getMonster("none"));
        System.out.println(getMonster("fire"));
        System.out.println(getMonster("water"));
        System.out.println(getMonster("plant"));
    }

}
