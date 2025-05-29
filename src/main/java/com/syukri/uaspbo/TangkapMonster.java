/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

import com.syukri.uaspbo.pokemons.Monster;

/**
 *
 * @author HP
 */
public class TangkapMonster {
    public static boolean TangkapMonsterLiar (Monster monsterLiarYangAkanDitangkap, PlayerData myDeck) {
        int maxHp = monsterLiarYangAkanDitangkap.getMaxHp();
        int currentHp = monsterLiarYangAkanDitangkap.getHp();
        
        if (DiceRoller.rollDice(1, maxHp) > currentHp) {
            monsterLiarYangAkanDitangkap.resetAfterBattle();
            myDeck.AddMonster(monsterLiarYangAkanDitangkap);
            return true;
        } else {
            System.out.println("Monster liar kabur!");
            return false;
        }
        
    }
}
