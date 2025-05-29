/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.syukri.uaspbo;

import java.util.Scanner;
import com.syukri.uaspbo.menu.Explore;

/**
 *
 * @author HP
 */

public class UasPbo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerData myDeck = new PlayerData();
        myDeck.Load();
        Explore.init(scanner, myDeck);
        scanner.close();
    }
}
