/*
 * Click banyakDadubfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click banyakDadubfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;
import java.util.*;

/**
 *
 * @author HP
 */

public class DiceRoller {
    public static int rollDice(int banyakDadu, int sisiDadu) {
        Random rand = new Random();
        int total = 0;
        for (int i = 0; i < banyakDadu; i++) {
            total += rand.nextInt(sisiDadu) + 1;
        }
        return total;
    }
    
    public static List<Integer> rollKeepHighest(int banyakDadu, int sisiDadu, int banyakDaduYangDiambil) {
        Random rand = new Random();
        if (banyakDaduYangDiambil > banyakDadu) {
            int temp = banyakDadu;
            banyakDadu = banyakDaduYangDiambil;
            banyakDaduYangDiambil = temp;
            // pastikan banyakDadu >= banyakDaduYangDiambil
        }
        
        List<Integer> rolls = new ArrayList<>();

        // Roll dadu sebanyak banyakDadu
        for (int i = 0; i < banyakDadu; i++) {
            rolls.add(rand.nextInt(sisiDadu) + 1); // 1 to sisiDadu
        }

        // Sort descending
        rolls.sort(Collections.reverseOrder());

        // Ambil banyakDaduYangDiambil terbesar
        return rolls.subList(0, banyakDaduYangDiambil);
    }

    public static int rollTotalKeepHighest(int banyakDadu, int sisiDadu, int banyakDaduYangDiambil) {
        List<Integer> highest = rollKeepHighest(banyakDadu, sisiDadu, banyakDaduYangDiambil);
        return highest.stream().mapToInt(Integer::intValue).sum();
    }
    
    public static List<Integer> rollKeepLowest(int banyakDadu, int sisiDadu, int banyakDaduYangDiambil) {
        Random rand = new Random();
        if (banyakDaduYangDiambil > banyakDadu) {
            int temp = banyakDadu;
            banyakDadu = banyakDaduYangDiambil;
            banyakDaduYangDiambil = temp;
            // pastikan banyakDadu >= banyakDaduYangDiambil
        }
        
        List<Integer> rolls = new ArrayList<>();

        // Roll dadu sebanyak banyakDadu
        for (int i = 0; i < banyakDadu; i++) {
            rolls.add(rand.nextInt(sisiDadu) + 1); // 1 to sisiDadu
        }

        // Sort ascending
        rolls.sort(Comparator.naturalOrder());

        // Ambil banyakDaduYangDiambil terbesar
        return rolls.subList(0, banyakDaduYangDiambil);
    }

    public static int rollTotalKeepLowest(int banyakDadu, int sisiDadu, int banyakDaduYangDiambil) {
        List<Integer> highest = rollKeepLowest(banyakDadu, sisiDadu, banyakDaduYangDiambil);
        return highest.stream().mapToInt(Integer::intValue).sum();
    }
}