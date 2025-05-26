package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.moves.*;;

public class FireSukaryon extends Monster {

    public FireSukaryon(String name, int level) {
        super(name, level, "assets/Sukaryon.png", 40);
        this.setElement("fire");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves FirePunch = new Attack("Fire Punch", 6, 6, "fire");
        Moves FireKick = new Attack("Fire Kick", 8, 4, "fire");
        Moves FireWall = new Heal("Fire Wall", 4, 8);

        this.addMoves(FirePunch);
        this.addMoves(FireKick);
        this.addMoves(FireWall);
    }

    public FireSukaryon(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public FireSukaryon(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
