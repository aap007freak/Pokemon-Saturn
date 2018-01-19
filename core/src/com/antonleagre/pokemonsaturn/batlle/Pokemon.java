package com.antonleagre.pokemonsaturn.batlle;

public class Pokemon {

    private String DisplayName;

    private float hp;
    private float level;
    private float attack;
    private float defense;
    private float spattack;
    private float spdefense;
    private float speed;

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public Pokemon(String displayName, float hp, float attack, float defense, float spattack, float spdefense, float speed) {
        DisplayName = displayName;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
    }

    public float getLevel() {
        return level;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public float getHp() {
        return hp;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getSpattack() {
        return spattack;
    }

    public float getSpdefense() {
        return spdefense;
    }

    public float getSpeed() {
        return speed;
    }
}
