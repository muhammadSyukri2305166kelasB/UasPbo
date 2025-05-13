// BEKAS NYOBA
// JANGAN DI HAPUS ATAU DI PAKAI
























// package com.syukri.uaspbo.menu;

// import java.util.*;

// interface Interactable {
// void interact(Scanner scanner);// untuk inject kode saat runtime
// }

// class Location {
// String name;
// String description;
// Interactable interaction; // menyimpan kode yang di inject ketika runtime

// public Location(String name, String description, Interactable interaction) {
// this.name = name;
// this.description = description;
// this.interaction = interaction;
// }

// public void interact(Scanner scanner) { // jalankan kode yang di inject ke
// variable interaction
// while (true) {
// System.out.println("\nSaat ini Kamu sedang berada di " + name);
// System.out.println(description);
// interaction.interact(scanner); // interaction akan bergantung pada objek nya
// }
// }
// }

// public class MovementGraph {
// private Map<String, Location> locations; // menyimpan list objek-objek
// Location
// private Map<String, List<String>> graph; // Membuat struktur data graf
// private String currentLocation;

// public MovementGraph() {
// locations = new HashMap<>();
// graph = new HashMap<>();
// }

// public void addlocation(String name, String description, Interactable
// interaction) {
// locations.put(name, new Location(name, description, interaction));
// graph.putIfAbsent(name, new ArrayList<>());
// }

// public void connecLocations(String from, String to) {
// graph.get(from).add(to);
// graph.get(to).add(from);
// }

// public void moveTo(String destination, Scanner scanner) {
// if (graph.get(currentLocation).contains(destination)) {
// currentLocation = destination;
// locations.get(destination).interact(scanner);
// } else {
// System.out.println("Tidak bisa pergi ke " + destination + " dari " +
// currentLocation);
// }
// }

// public void setStartLocation(String start, Scanner scanner) {
// currentLocation = start;
// locations.get(start).interact(scanner);
// }

// public void showOptions(MovementGraph map, Scanner scanner) {
// System.out.println("\nDari " + currentLocation + ", kamu bisa pergi ke : " +
// graph.get(currentLocation));
// System.out.println("\nKe mana kamu akan pergi? (atau ketik 'keluar') : ");
// String input = scanner.nextLine();
// if (input.equalsIgnoreCase("keluar"))
// return;
// map.moveTo(input, scanner);

// }

// public static void main(String[] args) {
// MovementGraph map = new MovementGraph();

// map.addlocation("Rumah", "Makan bang", (scanner) -> {
// System.out.println("1. bobo");
// System.out.println("2. mangan");
// System.out.println("3. Pergi");
// System.out.print("Pilih aksi : ");
// int choice = scanner.nextInt();
// scanner.nextLine();
// switch (choice) {
// case 1 -> System.out.println("tidurlah");
// case 2 -> System.out.println("kenyanglah");
// case 3 -> map.showOptions(map, scanner);
// default -> System.out.println("diamb");
// }
// });

// map.addlocation("Toko", "Warung biasa", (scanner) -> {
// System.out.println("1. Beli makanan");
// System.out.println("2. Beli minuman");
// System.out.println("3. Pergi");
// System.out.print("Pilih aksi : ");
// int choice = scanner.nextInt();
// scanner.nextLine();
// switch (choice) {
// case 1 -> System.out.println("makanlah");
// case 2 -> System.out.println("minumlah");
// case 3 -> map.showOptions(map, scanner);
// default -> System.out.println("diamb");
// }
// });

// map.addlocation("Pasar", "hiruk pikuk dunia", (scanner) -> {
// System.out.println("1. beli sayur");
// System.out.println("2. beli daging");
// System.out.println("3. Pergi");
// System.out.print("Pilih aksi : ");
// int choice = scanner.nextInt();
// scanner.nextLine();
// switch (choice) {
// case 1 -> System.out.println("murah");
// case 2 -> System.out.println("mahal");
// case 3 -> map.showOptions(map, scanner);
// default -> System.out.println("diamb");
// }
// });

// Scanner scanner = new Scanner(System.in);
// map.connecLocations("Rumah", "Toko");
// map.connecLocations("Pasar", "Toko");
// map.connecLocations("Rumah", "Pasar");
// map.setStartLocation("Rumah", scanner);
// System.out.println("\nSampai jumpa");
// scanner.close();
// }
// }
