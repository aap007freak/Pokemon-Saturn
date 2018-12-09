package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Moves;

public class Pokemon {

    public enum Type {
        NORMAL,
        FIGHTING,
        FLYING,
        POISON,
        GROUND,
        ROCK,
        BUG,
        GHOST,
        STEEL,
        FIRE,
        WATER,
        GRASS,
        ELECTRIC,
        PSYCHIC,
        ICE,
        DRAGON,
        DARK,
        FAIRY
    }

    private String DisplayName;

    private Type type;
    private float hp;
    private float level;
    private float attack;
    private float defense;
    private float spattack;
    private float spdefense;
    private float speed;

    private Moves move1;
    private Moves move2;
    private Moves move3;
    private Moves move4;

    public Pokemon(String displayName, Type type, float hp, float attack, float defense, float spattack, float spdefense, float speed) {
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
