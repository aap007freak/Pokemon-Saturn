package com.antonleagre.pokemonsaturn.model.pokemon;

import com.antonleagre.pokemonsaturn.model.Pokemon;
import com.google.gson.Gson;

public enum BaseStats {

    PIKACHU(Pokemon.Type.ELECTRIC, 35f, 55f, 40f , 50f, 50f, 90f),
    BULBASAUR(Pokemon.Type.GRASS, Pokemon.Type.POISON, 45f, 49f, 49f, 65f, 65f, 45f),
    CHARMANDER(Pokemon.Type.FIRE, 39f, 52f, 43f, 60f, 50f, 65f),
    SQUIRTLE(Pokemon.Type.WATER, 44f, 48f, 65f, 50f, 64f, 43f),
    MARILL(Pokemon.Type.WATER, Pokemon.Type.FAIRY, 70f, 20f, 50f, 20f, 50f, 40f),
    GARCHOMP(Pokemon.Type.DRAGON, Pokemon.Type.GROUND, 108f, 130f, 95f, 80f, 85f, 102f);

    private final Pokemon.Type type1;
    private final Pokemon.Type type2;
    private final float hp;
    private final float attack;
    private final float defense;
    private final float spattack;
    private final float spDefense;
    private final float speed;

    BaseStats(Pokemon.Type type1, Pokemon.Type type2, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    BaseStats(Pokemon.Type type, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
        this.type1 = type;
        this.type2 = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    public Pokemon.Type getType1() {
        return type1;
    }

    public Pokemon.Type getType2() {
        return type2;
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

    public float getSpDefense() {
        return spDefense;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name().substring(0,1) + name().substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(GARCHOMP));
    }
}

