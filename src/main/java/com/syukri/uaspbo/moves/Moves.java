/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo.moves;

import com.syukri.uaspbo.pokemons.Monster;
import java.io.Serializable;

/**
 *
 * @author HP
 */
public abstract class Moves implements Serializable{
    private String name;
    private String desc = "default Moves Description";
    private int baseValue;
    private int diceSide;
    private String element = "none";

    public Moves(String name, int diceSide, int baseValue) {
        this.name = name;
        this.diceSide = diceSide;
        this.baseValue = baseValue;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
    
    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }
    
    public int getDiceSide() {
        return diceSide;
    }

    public void setDiceSide(int diceSide) {
        this.diceSide = diceSide;
    }

    public abstract void execute(Monster self, Monster target);
    public String view(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : \n\t").append(desc);
        sb.append("\n\tElement \t: ").append(element);
        sb.append("\n\tDamage dasar \t: ").append(baseValue);
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moves{");
        sb.append("name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", baseValue=").append(baseValue);
        sb.append(", diceSide=").append(diceSide);
        sb.append(", element=").append(element);
        sb.append('}');
        return sb.toString();
    }

}
