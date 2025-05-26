package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.moves.*;;

public class FireVoltrik extends Monster {

    public FireVoltrik(String name, int level) {
        super(name, level, "assets/Voltrik.png", 20);
        this.setElement("fire");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves FieryClamp = new Attack("Fiery Clamp", 6, 6, "fire");
        Moves FieryDash = new Attack("Fiery Dash", 8, 4, "fire");
        Moves HotFlashes = new Attack("Hot Flashes", 10, 4, "fire");

        this.addMoves(FieryClamp);
        this.addMoves(FieryDash);
        this.addMoves(HotFlashes);
    }

    public FireVoltrik(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public FireVoltrik(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
