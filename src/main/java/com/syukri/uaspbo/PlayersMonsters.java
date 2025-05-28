package com.syukri.uaspbo;

import com.syukri.uaspbo.pokemons.*;
import java.util.*;
import java.io.*;

class GameData implements Serializable {
    public ArrayList<Monster> monsterList;
    public int dayCounter;
    public Map<String, Set<String>> monsterCounter;
    public String currentLocation;
    public Map<String, Monster> monstersPerLocation;
}

public class PlayersMonsters {
    private ArrayList<Monster> PlayersMonsters;
    private final String filename;
    private int savedDayCounter;
    private Map<String, Set<String>> savedMonsterCounter;
    private String savedCurrentLocation;
    private Map<String, Monster> savedMonstersPerLocation;

    public PlayersMonsters() {
        PlayersMonsters = new ArrayList<>();
        filename = "savegame.dat";
    }

    public void Save(int dayCounter, Map<String, Set<String>> monsterCounter, String currentLocation, Map<String, Monster> monstersPerLocation) {
        GameData data = new GameData();
        data.monsterList = PlayersMonsters;
        data.dayCounter = dayCounter;
        data.monsterCounter = monsterCounter;
        data.currentLocation = currentLocation;
        data.monstersPerLocation = monstersPerLocation;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println("Game state saved.");
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }
    }

    public boolean Load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GameData data = (GameData) ois.readObject();
            this.PlayersMonsters = data.monsterList;
            this.savedDayCounter = data.dayCounter;
            this.savedMonsterCounter = data.monsterCounter;
            this.savedCurrentLocation = data.currentLocation;
            this.savedMonstersPerLocation = data.monstersPerLocation;
            System.out.println("Game state loaded.");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load game: " + e.getMessage());
            return false;
        }
    }

    public int getSavedDayCounter() {
        return savedDayCounter;
    }

    public Map<String, Set<String>> getSavedMonsterCounter() {
        return savedMonsterCounter;
    }

    public String getSavedCurrentLocation() {
        return savedCurrentLocation;
    }

    public Map<String, Monster> getSavedMonstersPerLocation() {
        return savedMonstersPerLocation;
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

    public void addMonster(Monster m) {
        PlayersMonsters.add(m);
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
    }

    public Monster get(int i) {
        return PlayersMonsters.get(i);
    }

    public int size() {
        return PlayersMonsters.size();
    }

    public static void main(String[] args) {
        PlayersMonsters data = new PlayersMonsters();
        data.test();
        data.Save(1, new HashMap<>(), "Rumah", new HashMap<>());
        data.Load();
        data.ViewListOfMonsters();
    }
}
