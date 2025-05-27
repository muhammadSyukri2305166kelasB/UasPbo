/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import com.syukri.uaspbo.pokemons.Monster;
import java.util.ArrayList;

import com.syukri.uaspbo.pokemons.*;

import java.io.*;

/**
 *
 * @author HP
 */
public class PlayersMonsters {
    private ArrayList<Monster> PlayersMonsters;
    private final String filename;

    public PlayersMonsters() {
        PlayersMonsters = new ArrayList<>();
        filename = "abc.dat";
    }

    public void Save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(PlayersMonsters);
            System.out.println("Game saved");
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public boolean Load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            PlayersMonsters = (ArrayList<Monster>) ois.readObject();
            System.out.println("Game loaded");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            test();
            System.err.println("Failed to load game: " + e.getMessage());
            return false;
        }
    }

    public void ViewListOfMonsters() {
        for (int i = 0; i < PlayersMonsters.size(); i++) {
            System.out.println(i + 1 + ". " + PlayersMonsters.get(i));
        }
    }

    public ArrayList<Monster> getPlayersMonsters() {
        return PlayersMonsters;
    }

    public void AddMonster(Monster newMonster) {
        this.PlayersMonsters.add(newMonster);
        Save();
    }

    public void test() {
        Monster monster1 = new WaterSamequill("Samequill1", 1);
        Monster monster2 = new WaterSamequill("Samequill2", 2);
        Monster monster3 = new WaterMizumon("Mizumon1", 3);
        Monster monster4 = new WaterMizumon("Mizumon2", 4);
        AddMonster(monster1);
        AddMonster(monster2);
        AddMonster(monster3);
        AddMonster(monster4);
        Save();
    }

    public static void main(String[] args) {
        PlayersMonsters data = new PlayersMonsters();
        data.test();
        data.Load();
        data.ViewListOfMonsters();
    }
}
