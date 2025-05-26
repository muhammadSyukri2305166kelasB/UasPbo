package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.moves.*;;

public class PlantKurikar extends Monster {

    public PlantKurikar(String name, int level) {
        super(name, level, "assets/Kurikar.png", 40);
        this.setElement("plant");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves GrassBlade = new Attack("Grass Blade", 6, 6, "plant");
        Moves GrassThorns = new Attack("Grass Thorns", 8, 4, "plant");

        this.addMoves(GrassBlade);
        this.addMoves(GrassThorns);
    }

    public PlantKurikar(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public PlantKurikar(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
