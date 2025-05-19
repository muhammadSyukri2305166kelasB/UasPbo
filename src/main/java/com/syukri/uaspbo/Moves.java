/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
public abstract class Moves {
    private String name;
    private String desc = "defaultDescription";
    private int diceSide;
    private String element = "none";

    public Moves(String name, int diceSide) {
        this.name = name;
        this.diceSide = diceSide;
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
    
    public abstract void execute(Monster self, Monster target);

    public int getDiceSide() {
        return diceSide;
    }

    public void setDiceSide(int diceSide) {
        this.diceSide = diceSide;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moves{");
        sb.append("name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", diceSide=").append(diceSide);
        sb.append(", element=").append(element);
        sb.append('}');
        return sb.toString();
    }

}
