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
    List<Option> getOptions();
}

class Location implements Interactable {
    String name;
    Runnable view;
    Monster monster;
    String description;
    List<Option> interactionOptions;

    public Location(String name, String description, Runnable view, List<Option> interactionOptions) {
        this.name = name;
        this.description = description;
        this.view = view;
        this.interactionOptions = new ArrayList<>(interactionOptions);
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
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, List<String>> graph = new HashMap<>();
    private String currentLocation;
    PlayersMonsters myDeck;
    Scanner scanner;
    int dayCounter;
    Map<String, Set<String>> monsterCounter = new HashMap<>();

    public void initializeMonsterCounter() {
        monsterCounter.put("none", new HashSet<>());
        monsterCounter.put("fire", new HashSet<>());
        monsterCounter.put("plant", new HashSet<>());
        monsterCounter.put("water", new HashSet<>());
    }

    private void addMonster(Monster m) {
        String type = m.getType();
        String name = m.getName();
        if (!monsterCounter.get(type).contains(name)) {
            monsterCounter.get(type).add(name);
            System.out.println("Monster baru ditangkap: " + name);
        } else {
            System.out.println("Monster " + name + " sudah pernah ditangkap.");
        }
    }

    public Explore(Scanner scanner, PlayersMonsters myDeck) {
        this.myDeck = myDeck;
        this.scanner = scanner;
        this.dayCounter = 0;
        initializeMonsterCounter();
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

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Map<String, Monster> getMonsterPerLocation() {
        Map<String, Monster> map = new HashMap<>();
        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            map.put(entry.getKey(), entry.getValue().monster);
        }
        return map;
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
        map.locations.get("Gurun pasir").monster = MonsterSpawner.getMonster("fire", map.myDeck);
        map.locations.get("Sungai").monster = MonsterSpawner.getMonster("water", map.myDeck);
        map.locations.get("Hutan").monster = MonsterSpawner.getMonster("plant", map.myDeck);
        map.locations.get("Pegunungan").monster = MonsterSpawner.getMonster("none", map.myDeck);
        map.myDeck.Save(map.dayCounter, map.monsterCounter, map.getCurrentLocation(), map.getMonsterPerLocation());
        Battle.waitAndClear();
    }

    void lawanMonster() {
        clearScreen();
        Monster wildMonster = locations.get(currentLocation).monster;
        System.out.println("kamu melawan monster " + wildMonster.getName() + " :\n\n");
        wildMonster.viewQuickDesc();
        Monster pickedMonster = MonsterSelector.pickMonster(myDeck, scanner);
        System.out.println("Apakah Anda yakin? (y/t)");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("t")) {
            return;
        }
        boolean isWon = Battle.PlayerVsWild(pickedMonster, wildMonster, scanner, myDeck);
        pickedMonster.resetAfterBattle();
        wildMonster.resetAfterBattle();
        Battle.waitAndClear();
        if (isWon) {
            addMonster(wildMonster);
            locations.get(currentLocation).monster = null;
            myDeck.Save(dayCounter, monsterCounter, currentLocation, getMonsterPerLocation());
        }
    }

    static void ascendMonster(PlayersMonsters myDeck, Scanner scanner, Explore map) {
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
        myDeck.Save(map.dayCounter, map.monsterCounter, map.getCurrentLocation(), map.getMonsterPerLocation());
    }

    public void run() {
        while (true) {
            if (checkEnding.hasWon(monsterCounter)) {
                Battle.waitAndClear();
                System.out.println("Kamu menang! Semua jenis monster telah dikumpulkan.");
                return;
            }
            if (checkEnding.hasLost(dayCounter)) {
                Battle.waitAndClear();
                System.out.println("Hari sudah melebihi batas (14 hari). Kamu kalah!");
                return;
            }

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
                menu.add(new Option("Pergi ke " + neighbor, () -> currentLocation = neighbor));
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
                new Option("Ascend Pokemon", () -> ascendMonster(myDeck, scanner, map))));

        map.addLocation("Toko", "Penuhi kebutuhan Pokemon mu", View::Home, Arrays.asList(
                new Option("Jual", () -> System.out.println(">> Kamu mendapatkan uang ")),
                new Option("Belanja", () -> System.out.println(">> Kamu mendapatkan barang "))));

        map.addLocation("Gurun pasir", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Dessert, new ArrayList<>());
        map.addLocation("Sungai", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::River, new ArrayList<>());
        map.addLocation("Hutan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Forest, new ArrayList<>());
        map.addLocation("Pegunungan", "Persiapkan bekal yang banyak, kamu tidak tahu apa yang ada di depan sana",
                View::Mountain, new ArrayList<>());

        map.connecLocations("Rumah", "Main menu");
        map.connecLocations("Rumah", "Toko");
        map.connecLocations("Rumah", "Gurun pasir");
        map.connecLocations("Rumah", "Sungai");
        map.connecLocations("Rumah", "Hutan");
        map.connecLocations("Pegunungan", "Hutan");

        if (myDeck.Load()) {
            map.dayCounter = myDeck.getSavedDayCounter();
            map.monsterCounter = myDeck.getSavedMonsterCounter();
            String savedLocation = myDeck.getSavedCurrentLocation();
            Map<String, Monster> restoredMonsters = myDeck.getSavedMonstersPerLocation();
            if (restoredMonsters != null) {
                for (Map.Entry<String, Monster> entry : restoredMonsters.entrySet()) {
                    if (map.locations.containsKey(entry.getKey())) {
                        map.locations.get(entry.getKey()).monster = entry.getValue();
                    }
                }
            }

            map.setStartLocation("Main menu"); 
            clearScreen();
            System.out.println("🔄 Game ditemukan.");
            System.out.println("[1] Lanjutkan Permainan");
            System.out.println("[2] Mulai baru");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("2")) {
                map.dayCounter = 0;
                map.monsterCounter.clear();
                map.initializeMonsterCounter();
            }
        } else {
            map.setStartLocation("Main menu");
        }

        GuideNPC.conversation(map.dayCounter, "rumah");
        map.run();

    }
}