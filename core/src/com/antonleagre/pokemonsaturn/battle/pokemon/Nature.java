package com.antonleagre.pokemonsaturn.battle.pokemon;

import java.util.Random;

/**
 * Each Pokemon has an assigned nature on generation that boosts a stat by 10% and decreases a stat by 10%
 * todo further documentation
 */
public enum Nature{

    HARDY,
    LONELY(StatModifier.ATTACK, StatModifier.Defense),
    BRAVE(StatModifier.ATTACK, StatModifier.SPEED),
    ADAMANT(StatModifier.ATTACK, StatModifier.SPECIAL_ATTACK),
    NAUGHTY(StatModifier.ATTACK, StatModifier.SPECIAL_DEfense),
    BOLD(StatModifier.Defense, StatModifier.ATTACK),
    DOCILE,
    RELAXED(StatModifier.Defense, StatModifier.SPEED),
    IMPISH(StatModifier.Defense, StatModifier.SPECIAL_ATTACK),
    LAX(StatModifier.Defense, StatModifier.SPECIAL_DEfense),
    TIMID(StatModifier.SPEED, StatModifier.ATTACK),
    HASTY(StatModifier.SPEED, StatModifier.SPECIAL_DEfense),
    SERIOUS,
    JOLLY(StatModifier.SPEED, StatModifier.SPECIAL_ATTACK),
    NAIVE(StatModifier.SPEED, StatModifier.SPECIAL_DEfense),
    MODEST(StatModifier.SPECIAL_ATTACK, StatModifier.ATTACK),
    MILD(StatModifier.SPECIAL_ATTACK, StatModifier.Defense),
    QUIET(StatModifier.SPECIAL_ATTACK, StatModifier.SPEED),
    BASHFUL,
    RASH(StatModifier.SPECIAL_ATTACK, StatModifier.SPECIAL_DEfense),
    CALM(StatModifier.SPECIAL_DEfense, StatModifier.ATTACK),
    GENTLE(StatModifier.SPECIAL_DEfense, StatModifier.Defense),
    SASSY(StatModifier.SPECIAL_DEfense, StatModifier.SPEED),
    CAREFUL(StatModifier.SPECIAL_DEfense, StatModifier.SPECIAL_ATTACK),
    QUIRKY;

    public enum StatModifier{
        ATTACK, Defense, SPECIAL_ATTACK, SPECIAL_DEfense, SPEED, NONE
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
        if (boostedStat == StatModifier.Defense){
            return 1.1f;
        }else if (decreasedStat == StatModifier.Defense){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }
    public float getSpecialDefenseModifier(){
        if (boostedStat == StatModifier.SPECIAL_DEfense){
            return 1.1f;
        }else if (decreasedStat == StatModifier.SPECIAL_DEfense){
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