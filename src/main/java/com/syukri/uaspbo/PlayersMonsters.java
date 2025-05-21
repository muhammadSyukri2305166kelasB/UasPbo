/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import java.util.ArrayList;

import com.syukri.uaspbo.pokemons.WaterMizumon;
import com.syukri.uaspbo.pokemons.WaterSamequill;

import java.io.*;

/**
 *
 * @author HP
 */
public class PlayersMonsters {
    private ArrayList<Monster> PlayersMonsters;
    private String filename = "abc.dat";

    public PlayersMonsters() {
        this.PlayersMonsters = new ArrayList<>();
    }

    public void Save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.PlayersMonsters);
            System.out.println("Game saved");
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void Load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            PlayersMonsters = (ArrayList<Monster>) ois.readObject();
            System.out.println("Game loaded");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load game: " + e.getMessage());
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
    }

    public void test() {
        Monster monster1 = new WaterSamequill("Embercub1", 1);
        Monster monster2 = new WaterSamequill("Embercub2", 2);
        Monster monster3 = new WaterMizumon("Droplett1", 3);
        Monster monster4 = new WaterMizumon("Droplett2", 4);
        this.AddMonster(monster1);
        this.AddMonster(monster2);
        this.AddMonster(monster3);
        this.AddMonster(monster4);
        this.Save();
    }

    public static void main(String[] args) {
        PlayersMonsters data = new PlayersMonsters();
        data.test();
        data.Load();
        data.ViewListOfMonsters();
    }
}
