package com.antonleagre.pokemonsaturn.battle.pokemon;

import java.util.Random;

/**
 * Each Pokemon has an assigned nature on generation that boosts one stat by 10% and decreases a stat by 10%
 * The nature of a Pokemon doesn't change when evolving.
 */
public enum Nature{

    HARDY,
    LONELY(StatModifier.ATTACK, StatModifier.DEFENSE),
    BRAVE(StatModifier.ATTACK, StatModifier.SPEED),
    ADAMANT(StatModifier.ATTACK, StatModifier.SPECIAL_ATTACK),
    NAUGHTY(StatModifier.ATTACK, StatModifier.SPECIAL_DEFENSE),
    BOLD(StatModifier.DEFENSE, StatModifier.ATTACK),
    DOCILE,
    RELAXED(StatModifier.DEFENSE, StatModifier.SPEED),
    IMPISH(StatModifier.DEFENSE, StatModifier.SPECIAL_ATTACK),
    LAX(StatModifier.DEFENSE, StatModifier.SPECIAL_DEFENSE),
    TIMID(StatModifier.SPEED, StatModifier.ATTACK),
    HASTY(StatModifier.SPEED, StatModifier.SPECIAL_DEFENSE),
    SERIOUS,
    JOLLY(StatModifier.SPEED, StatModifier.SPECIAL_ATTACK),
    NAIVE(StatModifier.SPEED, StatModifier.SPECIAL_DEFENSE),
    MODEST(StatModifier.SPECIAL_ATTACK, StatModifier.ATTACK),
    MILD(StatModifier.SPECIAL_ATTACK, StatModifier.DEFENSE),
    QUIET(StatModifier.SPECIAL_ATTACK, StatModifier.SPEED),
    BASHFUL,
    RASH(StatModifier.SPECIAL_ATTACK, StatModifier.SPECIAL_DEFENSE),
    CALM(StatModifier.SPECIAL_DEFENSE, StatModifier.ATTACK),
    GENTLE(StatModifier.SPECIAL_DEFENSE, StatModifier.DEFENSE),
    SASSY(StatModifier.SPECIAL_DEFENSE, StatModifier.SPEED),
    CAREFUL(StatModifier.SPECIAL_DEFENSE, StatModifier.SPECIAL_ATTACK),
    QUIRKY;

    public enum StatModifier{
        ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED, NONE
    }

    private StatModifier boostedStat;
    private StatModifier decreasedStat;

    Nature(StatModifier boostedStat, StatModifier decreasedStat) {
        this.boostedStat = boostedStat;
        this.decreasedStat = decreasedStat;
    }
    Nature(){
        //some natures dont have effects at all
        this.boostedStat = StatModifier.NONE;
        this.decreasedStat = StatModifier.NONE;
    }

    public float getAttackModifier(){
        if (boostedStat == StatModifier.ATTACK){
            return 1.1f;
        }else if(decreasedStat == StatModifier.ATTACK){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }
    public float getSpecialAttackModifier(){
        if (boostedStat == StatModifier.SPECIAL_ATTACK){
            return 1.1f;
        }else if(decreasedStat == StatModifier.SPECIAL_ATTACK){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }
    public float getDefenseModifier(){
        if (boostedStat == StatModifier.DEFENSE){
            return 1.1f;
        }else if (decreasedStat == StatModifier.DEFENSE){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }
    public float getSpecialDefenseModifier(){
        if (boostedStat == StatModifier.SPECIAL_DEFENSE){
            return 1.1f;
        }else if (decreasedStat == StatModifier.SPECIAL_DEFENSE){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }
    public float getSpeedModifier(){
        if (boostedStat == StatModifier.SPEED){
            return 1.1f;
        }else if (decreasedStat == StatModifier.SPEED){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }

    public static Nature generateNature(){
        return Nature.values()[new Random().nextInt(24)];
    }
}