package com.syukri.uaspbo.menu;

import com.syukri.uaspbo.Battle;
import com.syukri.uaspbo.PlayersMonsters;

public class GuideNPC {
    public static void conversation(int dayCounter, String currentLocation){
        PlayersMonsters myDeck = new PlayersMonsters();
        if(myDeck.Load() == false){
            // isi sini jar scene premis

        }

        if(dayCounter == 1){
            System.out.println("Digga :  ");
            System.out.println("Selamat datang wahai Traveler. Saat ini kita memiliki tugas besar untuk menagkap");
            System.out.println("12 pokemon yang ada untuk mengalahkan raja pokemon yang akan datang dalam 14 hari");
            System.out.println("lagi");
            Battle.waitAndClear();
            System.out.println("Traveler : ");
            System.out.println("Sepertinya ini tugas yang sangat berat.... Tapi, baiklah akan saya coba untuk mengangkap");
            System.out.println("12 pokemon kurang dari 14 hari.");
            Battle.waitAndClear();
        }
    }

    public static boolean checkNPC(int dayCounter, String currentLoaction){
        if(dayCounter == 1 && currentLoaction.equals("Rumah")){
            return true;
        }else{
            return false;
        }
    }
}
