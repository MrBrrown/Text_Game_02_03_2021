package com.company;

public class Weapon {
    private String name;
    private int damageType;
    private int damage;

    Weapon(String n,int dt, int d){
        damage = d;
        name = n;
        damageType = dt;
    }

    public int getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    void WeaponInformation (){
        System.out.println(name + ", Урон: "+ damage);
    }
}
