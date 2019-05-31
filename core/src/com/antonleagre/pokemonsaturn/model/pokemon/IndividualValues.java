package com.antonleagre.pokemonsaturn.model.pokemon;

import java.util.Random;

/**
 * Individual Values (IV's) are the Pokemon equivalent of genes.
 * They determine (with Natures, Basestats...) the stats of a Pokemon
 *
 * from Gen 3 onwards IV's range from 0 - 31
 */
public class IndividualValues {

    //todo: IV's determine Hidden Power move

    private int hpIV;
    private int attackIV;
    private int defenseIV;
    private int specialAttackIV;
    private int specialDefenseIV;
    private int speedIV;

    public IndividualValues(int hpIV, int attackIV, int defenseIV, int specialAttackIV, int specialDefenseIV, int speedIV) {
        this.hpIV = hpIV;
        this.attackIV = attackIV;
        this.defenseIV = defenseIV;
        this.specialAttackIV = specialAttackIV;
        this.specialDefenseIV = specialDefenseIV;
        this.speedIV = speedIV;
    }

    public int getHpIV() {
        return hpIV;
    }

    public int getAttackIV() {
        return attackIV;
    }

    public int getDefenseIV() {
        return defenseIV;
    }

    public int getSpecialAttackIV() {
        return specialAttackIV;
    }

    public int getSpecialDefenseIV() {
        return specialDefenseIV;
    }

    public int getSpeedIV() {
        return speedIV;
    }

    @Override
    public String toString() {
        return "HP: " + hpIV + "; Attack: " + attackIV + "; Defense: " + defenseIV + "\n" +
                "Special Attack: " + specialAttackIV + "; Special Defense: " + specialDefenseIV + "; Speed: " + speedIV;
    }

    public static IndividualValues generateIVs(){
       //ivs range from 0-31
        Random r = new Random();
        return new IndividualValues(
                r.nextInt(31),
                r.nextInt(31),
                r.nextInt(31),
                r.nextInt(31),
                r.nextInt(31),
                r.nextInt(31)
        );
    }

}
