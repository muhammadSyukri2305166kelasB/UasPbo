package com.syukri.uaspbo.menu;

import java.util.*;

import com.syukri.uaspbo.Battle;
import com.syukri.uaspbo.Monster;
import com.syukri.uaspbo.PlayersMonsters;
import com.syukri.uaspbo.pokemons.MonsterSelector;

class Option {
    String description;
    Runnable action;

    public Option(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }
}

interface Interactable {
    List<Option> getOptions(); // untuk inject kode saat runtime
}

class Location implements Interactable {
    String name;
    Runnable view;
    Monster monster;
    String description;
    List<Option> interactionOptions; // untuk inject kode saat runtime

    public Location(String name, String description, Runnable view, List<Option> interactionOptions) {
        this.name = name;
        this.description = description;
        this.view = view;
        this.interactionOptions = interactionOptions;
    }

    @Override
    public List<Option> getOptions() {
        return interactionOptions;
    }

    public void describe() {
        System.out.println("\nKamu berada di " + name);
    }
}

public class Explore {
    private Map<String, Location> locations = new HashMap<>(); // menyimpan list objek-objek Location
    private Map<String, List<String>> graph = new HashMap<>(); // Membuat struktur data graf
    private String currentLocation;
    PlayersMonsters myDeck;
    Scanner scanner;

    public Explore(Scanner scanner, PlayersMonsters myDeck) {
        this.myDeck = myDeck;
        this.scanner = scanner;
    }

    public void addlocation(String name, String description, Runnable view, List<Option> interactionOptions) {
        locations.put(name, new Location(name, description, view, interactionOptions));
        graph.putIfAbsent(name, new ArrayList<>());
    }

    public void connecLocations(String from, String to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public void setStartLocation(String start) {
        currentLocation = start;
    }

    void lawanMonster() {
        System.out.println("kamu melawan monster " + locations.get(currentLocation).monster);
        Monster pickedMonster = MonsterSelector.pickMonster(myDeck, scanner);
        Monster wildMonster = locations.get(currentLocation).monster;
        Battle.PlayerVsWild(pickedMonster, wildMonster, scanner);
        System.out.println(">> Kamu mendapatkan uang dan exp ");
        // TODO: sistem level up, exp dan uang?
    }

    public void run() {
        while (true) {
            Location loc = locations.get(currentLocation);
            loc.view.run();
            loc.describe();
            List<Option> menu = new ArrayList<>(loc.getOptions());

            if (locations.get(currentLocation).monster != null) {
                menu.add(new Option("Lawan Monster", () -> lawanMonster()));
            }

            for (String neighbor : graph.get(currentLocation)) {
                menu.add(new Option("Pergi ke " + neighbor, () -> {
                    currentLocation = neighbor;
                }));
            }

            menu.add(new Option("Keluar", () -> {
                System.out.println("dadah");
                System.exit(0);
            }));

            System.out.println("Pilih aksi : ");
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("[%d] %s%n", i + 1, menu.get(i).description);
            }

            System.out.print("Masukkan nomor pilihan : ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid");
                continue;
            }

            if (choice < 1 || choice > menu.size()) {
                System.out.println("Pilihan diluar jangkauan");
                continue;
            }

            menu.get(choice - 1).action.run();
        }
    }
    
    static void tidur(Explore map) {
        System.out.println(">> Kamu beristirahat ");
        map.locations.get("Gurun pasir").monster = MonsterSpawner.getMonster("fire");
        map.locations.get("Sungai").monster = MonsterSpawner.getMonster("water");
        map.locations.get("Hutan").monster = MonsterSpawner.getMonster("plant");
        map.locations.get("Pegunungan").monster = MonsterSpawner.getMonster("none");
    }

    public static void init(Scanner scanner, PlayersMonsters myDeck) {
        Explore map = new Explore(scanner, myDeck);
        map.addlocation("Main menu", "Selamat datang di kerenmon", View::MainMenu, Arrays.asList(
                new Option("Credit", () -> System.out.println(">> Kamu masuk menu credit "))));

        map.addlocation("Rumah", "Tempat tinggal mu", View::Home, Arrays.asList(
                new Option("Istirahat", () -> tidur(map)),
                new Option("Ascend Pokemon", () -> System.out.println(">> Kamu masuk menu ascend "))));

        map.addlocation("Toko", "Penuhi kebutuhan Pokemon mu", View::Home, Arrays.asList(
                new Option("Jual", () -> System.out.println(">> Kamu mendapatkan uang ")),
                new Option("Belanja", () -> System.out.println(">> Kamu mendapatkan barang "))));

        map.addlocation("Gurun pasir", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Dessert, Arrays.asList(
                        new Option("Tangkap Pokemon", () -> System.out.println(">> Kamu mendapatkan Pokemon "))));

        map.addlocation("Sungai", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::River, Arrays.asList(
                        new Option("Tangkap Pokemon", () -> System.out.println(">> Kamu mendapatkan Pokemon "))));

        map.addlocation("Hutan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Forest, Arrays.asList(
                        new Option("Tangkap Pokemon", () -> System.out.println(">> Kamu mendapatkan Pokemon "))));

        map.addlocation("Pegunungan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Mountain, Arrays.asList(
                        new Option("Tangkap Pokemon", () -> System.out.println(">> Kamu mendapatkan Pokemon "))));

        map.connecLocations("Rumah", "Main menu");
        map.connecLocations("Rumah", "Toko");
        map.connecLocations("Rumah", "Gurun pasir");
        map.connecLocations("Rumah", "Sungai");
        map.connecLocations("Rumah", "Hutan");
        map.connecLocations("Pegunungan", "Hutan");
        map.setStartLocation("Main menu");
        tidur(map);
        map.run();
    }
}
