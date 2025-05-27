package com.syukri.uaspbo.menu;

import java.util.*;

import com.syukri.uaspbo.Battle;
import com.syukri.uaspbo.pokemons.Monster;
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
        this.interactionOptions = new ArrayList<>(interactionOptions); // fix here
    }

    @Override
    public List<Option> getOptions() {
        return interactionOptions;
    }

    public void addOptions(Option interactionOptions) {
        this.interactionOptions.add(interactionOptions);
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
    private int dayCounter;

    public Explore(Scanner scanner, PlayersMonsters myDeck) {
        this.myDeck = myDeck;
        this.scanner = scanner;
        this.dayCounter = 1;
    }

    public void addLocation(String name, String description, Runnable view, List<Option> interactionOptions) {
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

    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void tidur(Explore map, PlayersMonsters myDeck) {
        map.dayCounter++;
        System.out.println(">> Kamu beristirahat ");
        map.locations.get("Gurun pasir").monster = MonsterSpawner.getMonster("fire", myDeck);
        map.locations.get("Sungai").monster = MonsterSpawner.getMonster("water", myDeck);
        map.locations.get("Hutan").monster = MonsterSpawner.getMonster("plant", myDeck);
        map.locations.get("Pegunungan").monster = MonsterSpawner.getMonster("none", myDeck);
        Battle.waitAndClear();
    }

    void lawanMonster() {
        clearScreen();
        Monster wildMonster = locations.get(currentLocation).monster;
        System.out.println("kamu melawan monster " + locations.get(currentLocation).monster.getName() + " :\n\n");
        wildMonster.viewQuickDesc();
        Monster pickedMonster = MonsterSelector.pickMonster(myDeck, scanner);
        System.out.println("Apakah Anda yakin? (y/t)");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("t")) {
            return;
        }
        // ini return boolean, kalah = false
        boolean isWon = Battle.PlayerVsWild(pickedMonster, wildMonster, scanner, myDeck);
        pickedMonster.resetAfterBattle();
        wildMonster.resetAfterBattle();
        Battle.waitAndClear();
        if (isWon) {
            locations.get(currentLocation).monster = null;
        }
    }

    static void ascendMonster(PlayersMonsters myDeck, Scanner scanner) {
        System.out.println("Pilih Monster yang ingin kamu naikkan levelnya");
        Monster pickedMonster = MonsterSelector.pickMonster(myDeck, scanner);
        boolean isBerhasil = pickedMonster.levelUp();
        if (isBerhasil) {
            pickedMonster.view();
            System.out.println("Berhasil level up!");
            System.out.println(pickedMonster.toString());
        } else {
            System.out.println("Level up gagal!");
            System.out.println(pickedMonster.toString());
        }
        Battle.waitAndClear();
        myDeck.Save();
    }

    public void run() {
        while (true) {
            clearScreen();
            Location loc = locations.get(currentLocation);
            loc.view.run();
            System.out.print("Sekarang hari ke-" + dayCounter);
            loc.describe();
            List<Option> menu = new ArrayList<>(loc.getOptions());
            Monster localMonster = loc.monster;
            
            if (localMonster != null) {
                String desc = "Lawan Monster " + localMonster.getElement() + " : " + localMonster.getName()
                        + " (level " + localMonster.getLevel() + ")";
                menu.add(new Option(desc, () -> lawanMonster()));
            }
            if (GuideNPC.checkNPC(dayCounter, currentLocation)) {
                menu.add(new Option("Bicara dengan NPC (Digga, Guider)", () -> GuideNPC.conversation(dayCounter, currentLocation)));
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

    public static void init(Scanner scanner, PlayersMonsters myDeck) {
        clearScreen();
        Explore map = new Explore(scanner, myDeck);
        map.addLocation("Main menu", "Selamat datang di kerenmon", View::MainMenu, Arrays.asList(
                new Option("Credit", () -> System.out.println(">> Kamu masuk menu credit "))));

        map.addLocation("Rumah", "Tempat tinggal mu", View::Home, Arrays.asList(
                new Option("Istirahat", () -> tidur(map, myDeck)),
                new Option("Ascend Pokemon", () -> ascendMonster(myDeck, scanner))));

        map.addLocation("Toko", "Penuhi kebutuhan Pokemon mu", View::Home, Arrays.asList(
                new Option("Jual", () -> System.out.println(">> Kamu mendapatkan uang ")),
                new Option("Belanja", () -> System.out.println(">> Kamu mendapatkan barang "))));

        map.addLocation("Gurun pasir", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Dessert, new ArrayList<Option>());

        map.addLocation("Sungai", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::River, new ArrayList<Option>());

        map.addLocation("Hutan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Forest, new ArrayList<Option>());

        map.addLocation("Pegunungan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Mountain, new ArrayList<Option>());

        map.connecLocations("Rumah", "Main menu");
        map.connecLocations("Rumah", "Toko");
        map.connecLocations("Rumah", "Gurun pasir");
        map.connecLocations("Rumah", "Sungai");
        map.connecLocations("Rumah", "Hutan");
        map.connecLocations("Pegunungan", "Hutan");
        map.setStartLocation("Main menu");
        map.run();
    }
}
