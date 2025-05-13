// BEKAS NYOBA
// JANGAN DI HAPUS ATAU DI PAKAI
















package com.syukri.uaspbo.menu;

import java.util.Scanner;

public class MainMenu {
    public static void MainMenu1() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 1;
        while (pilihan > 0 && pilihan < 3) {
            View.MainMenu();
            System.out.println("[1] Start");
            System.out.println("[2] Credits");
            System.out.println("[3] Exit");
            System.out.print("\nMasukkan pilihan Anda: ");

            if (scanner.hasNextInt())
                pilihan = scanner.nextInt();
            else
                scanner.nextLine();
            for (int i = 0; i < 50; i++)
                System.out.println();

            switch (pilihan) {
                case 1:
                    Home();
                    break;

                default:
                    break;
            }
        }
        scanner.close();
    }

    public static void Home() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 1;
        View.Home();
        System.out.println("[1] Ke Barat");
        System.out.println("[2] Ke Utara");
        System.out.println("[3] Ke Timur");
        System.out.println("[4] Ke Selatan");
        System.out.println("[5] Aksi");
        System.out.print("\nMasukkan pilihan Anda: ");

        if (scanner.hasNextInt())
            pilihan = scanner.nextInt();
        else
            scanner.nextLine();
        for (int i = 0; i < 50; i++)
            System.out.println();

        switch (pilihan) {
            case 1:
                Dessert();
                break;
            case 3:
                River();
                break;

            default:
                break;
        }
        scanner.close();
    }

    public static void Dessert() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 1;
        View.Dessert();
        System.out.println("[1] Ke Barat");
        System.out.println("[2] Ke Utara");
        System.out.println("[3] Ke Timur");
        System.out.println("[4] Ke Selatan");
        System.out.println("[5] Aksi");
        System.out.print("\nMasukkan pilihan Anda: ");

        if (scanner.hasNextInt())
            pilihan = scanner.nextInt();
        else
            scanner.nextLine();
        for (int i = 0; i < 50; i++)
            System.out.println();

        switch (pilihan) {
            case 3:
                Home();
                break;

            default:
                break;
        }
        scanner.close();
    }

    public static void River() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 1;
        View.River();
        System.out.println("[1] Ke Barat");
        System.out.println("[2] Ke Utara");
        System.out.println("[3] Ke Timur");
        System.out.println("[4] Ke Selatan");
        System.out.println("[5] Aksi");
        System.out.print("\nMasukkan pilihan Anda: ");

        if (scanner.hasNextInt())
            pilihan = scanner.nextInt();
        else
            scanner.nextLine();
        for (int i = 0; i < 50; i++)
            System.out.println();

        switch (pilihan) {
            case 1:
                Home();
                break;

            default:
                break;
        }
        scanner.close();
    }
}
