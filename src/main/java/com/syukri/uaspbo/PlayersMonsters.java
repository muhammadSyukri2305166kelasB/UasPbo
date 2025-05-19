/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class PlayersMonsters {
    private ArrayList<Monster> PlayersMonsters;
    
    public static void saveGame(ArrayList<Monster> PlayersMonsters, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(PlayersMonsters);
            System.out.println("Game saved");
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }
    }
    
    public static ArrayList<Monster> loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            ArrayList<Monster> loaded = (ArrayList<Monster>) ois.readObject();
            System.out.println("Game loaded");
            return loaded;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load game: " + e.getMessage());
            return null;
        }
    }
    
    public static ArrayList<Monster> CreateNewList () {
        ArrayList<Monster> newList = new ArrayList<>();
        return newList;
    }
    
    public static void ViewListOfMonsters (ArrayList<Monster> PlayersMonsters){
        for (int i = 0; i < PlayersMonsters.size(); i++) {
//            System.out.println(1+ ". " + PlayersMonsters.get(i).getName());
            System.out.println(PlayersMonsters.get(i).toString());
        }
    }
    
    public void AddMonster (Monster newMonster) {
        this.PlayersMonsters.add(newMonster);
    }
    
    public static void main(String[] args) {
        ArrayList<Monster> myMonsters = CreateNewList();
        Monster monster1 = new MonsterEmbercub("Embercub1", 1);
        Monster monster2 = new MonsterEmbercub("Embercub2", 2);
        Monster monster3 = new MonsterDroplett("Droplett1", 3);
        Monster monster4 = new MonsterDroplett("Droplett2", 4);
        
        myMonsters.add(monster1);
        myMonsters.add(monster2);
        myMonsters.add(monster3);
        myMonsters.add(monster4);
        
        ViewListOfMonsters(myMonsters);
        saveGame(myMonsters, "abc.dat");
        
        ArrayList<Monster> myMonsters2 = loadGame("abc.dat");
        ViewListOfMonsters(myMonsters2);
    }
}
