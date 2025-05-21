package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Heal;
import com.syukri.uaspbo.Monster;
import com.syukri.uaspbo.Moves;

public class PlantChurippi extends Monster {

    public PlantChurippi(String name, int level) {
        super(name, level, "assets/Churippi.png", 40);
        this.setElement("plant");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves ToxicFlower = new Attack("Toxic Flower", 6, 6, "plant");
        Moves StickyRoot = new Attack("Sticky Root", 8, 4, "plant");
        Moves ComfySoil = new Heal("Comfy Soil", 4, 8);

        this.addMoves(ToxicFlower);
        this.addMoves(StickyRoot);
        this.addMoves(ComfySoil);
    }

    public PlantChurippi(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public PlantChurippi(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
