package com.company;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private int type;

    Enemy(String n,int h, int d, int t){
        name = n;
        damage = d;
        health = h;
        type = t;
    }

    public int getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    void TakeDamage(int damage){
        health -=damage;
    }

    public String getName() {
        return name;
    }
}
