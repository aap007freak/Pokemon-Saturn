package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.moves.BaseMove;
import com.antonleagre.pokemonsaturn.model.moves.Move;
import com.antonleagre.pokemonsaturn.model.pokemon.*;
import com.google.gson.Gson;

public class Pokemon {

    //the base stats of that kind of pokemon
    private final BasePokemon baseStats;

    //pokemon specific things
    private final Nature nature;
    private final IndividualValues iVs;

    private final String name;
    private String nickName;

    //stats
    private final EffortValues eVs;
    private final int level;

    private float hp;
    private final float attack;
    private final float defense;
    private final float spAttack;
    private final float spDefense;
    private final float speed;

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    /**
     * Will create a pokemon  with no moves
     * All fields are generated as they would be in the game (e.g. Nature, EV's...)
     * @param startingLevel
     * @param base
     */
    public Pokemon(int startingLevel, BasePokemon base){
        this.baseStats = base;
        this.level = startingLevel;

        //capitalize basestats name
        this.name = baseStats.toString();

        this.nature = Nature.generateNature();
        this.iVs = IndividualValues.generateIVs();
        this.eVs = EffortValues.generateEffortValues();

        this.hp = Calculator.calculateHPStat(this);
        this.attack = Calculator.calculateAttackStat(this);
        this.defense = Calculator.calculateDefenseStat(this);
        this.spAttack = Calculator.calculateSpecialAttackStat(this);
        this.spDefense = Calculator.calculateSpecialDefenseStat(this);
        this.speed = Calculator.calculateSpeedStat(this);
    }

    public BasePokemon getBaseStats() {
        return baseStats;
    }

    public Nature getNature() {
        return nature;
    }

    public IndividualValues getiVs() {
        return iVs;
    }

    public EffortValues geteVs() {
        return eVs;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        if(nickName == null){
            return name;
        }else{
            return nickName;
        }
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

    public float getSpAttack() {
        return spAttack;
    }

    public float getSpDefense() {
        return spDefense;
    }

    public float getSpeed() {
        return speed;
    }

    public void minusHp(float f){
        hp -= f;
    }
    public void plusHp(float f){
        hp += f;
    }

    public Move getMove1() {
        return move1;
    }

    public void setMove1(Move move1) {
        this.move1 = move1;
    }

    public Move getMove2() {
        return move2;
    }

    public void setMove2(Move move2) {
        this.move2 = move2;
    }

    public Move getMove3() {
        return move3;
    }

    public void setMove3(Move move3) {
        this.move3 = move3;
    }

    public Move getMove4() {
        return move4;
    }

    public void setMove4(Move move4) {
        this.move4 = move4;
    }

    @Override
    public String toString() {
        return "-----POKEMON-" + getName() + "-START-----" +
                "\n" +
                "Nature: " + nature +
                "\n" +
                "IV's: " + iVs +
                "\n" +
                "EV's: " + eVs +
                "\n" +
                "Stats: HP: " + hp +
                "\n" +
                "       Attack: " + attack +
                "\n" +
                "       Defense: " + defense +
                "\n" +
                "       Special Attack: " + spAttack +
                "\n" +
                "       Special Defense: " + spDefense +
                "\n" +
                "       Speed: " + speed +
                "\n" +
                "-----POKEMON-" + getName() + "-END-------";
    }
}
