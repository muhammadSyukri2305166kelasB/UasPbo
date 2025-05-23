package com.syukri.uaspbo.pokemons;

import java.util.ArrayList;
import com.syukri.uaspbo.Attack;
import com.syukri.uaspbo.Moves;

public class FireSmolava extends Monster {

    public FireSmolava(String name, int level) {
        super(name, level, "assets/Smolava.png", 40);
        this.setElement("fire");
        int baseHp = 4;
        this.setMaxHp(this.getMaxHp() + baseHp);
        this.setHp(this.getMaxHp());

        Moves FireBall = new Attack("Fire Ball", 6, 6, "fire");
        Moves FirePath = new Attack("Fire Path", 8, 4, "fire");

        this.addMoves(FireBall);
        this.addMoves(FirePath);
    }

    public FireSmolava(String name, int level, int maxHp, int attack, int defense, int speed,
            ArrayList<Moves> moves, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, ViewSource, spawnRarity);
    }

    public FireSmolava(String name, int level, int maxHp, int attack, int defense, int speed, ArrayList<Moves> moves,
            String element, String ViewSource, int spawnRarity) {
        super(name, level, maxHp, attack, defense, speed, moves, element, ViewSource, spawnRarity);
    }

}
