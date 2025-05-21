package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Monster;
import com.syukri.uaspbo.Moves;

public class PlantOriza extends Monster {

    public PlantOriza(String name, int level) {
        super(name, level, "assets/Oriza.png", 20);
        this.setElement("plant");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves StickyGrass = new Attack("Sticky Grass", 6, 6, "plant");
        Moves SeedSpray = new Attack("Seed Spray", 8, 4, "plant");
        Moves GrassSpray = new Attack("Grass Spray", 10, 4, "plant");

        this.addMoves(StickyGrass);
        this.addMoves(SeedSpray);
        this.addMoves(GrassSpray);
    }

    public PlantOriza(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public PlantOriza(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
