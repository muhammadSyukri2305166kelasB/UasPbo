package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.Moves;
import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Heal;

public class WaterBanyu extends Monster {

    public WaterBanyu(String name, int level) {
        super(name, level, "assets/Banyu.png", 40);
        this.setElement("water");
        int baseHp = 5;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves waterGun = new Attack("Water Gun", 8, 4, "water");
        Moves calmingWater = new Heal("Calming Water", 4, 8);

        this.addMoves(waterGun);
        this.addMoves(calmingWater);
    }

    public WaterBanyu(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public WaterBanyu(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
