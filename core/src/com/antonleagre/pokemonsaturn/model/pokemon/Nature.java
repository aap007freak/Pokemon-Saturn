package com.antonleagre.pokemonsaturn.model.pokemon;

import java.util.Random;

import static com.antonleagre.pokemonsaturn.model.pokemon.Nature.Stat.*;

/**
 * Each Pokemon has an assigned nature on generation that boosts one stat by 10% and decreases a stat by 10%
 * The nature of a Pokemon doesn't change when evolving.
 */
public enum Nature{

    HARDY,
    LONELY(ATTACK, DEFENSE),
    BRAVE(ATTACK, SPEED),
    ADAMANT(ATTACK, SPECIAL_ATTACK),
    NAUGHTY(ATTACK, SPECIAL_DEFENSE),
    BOLD(DEFENSE, ATTACK),
    DOCILE,
    RELAXED(DEFENSE, SPEED),
    IMPISH(DEFENSE, SPECIAL_ATTACK),
    LAX(DEFENSE, SPECIAL_DEFENSE),
    TIMID(SPEED, ATTACK),
    HASTY(SPEED, SPECIAL_DEFENSE),
    SERIOUS,
    JOLLY(SPEED, SPECIAL_ATTACK),
    NAIVE(SPEED, SPECIAL_DEFENSE),
    MODEST(SPECIAL_ATTACK, ATTACK),
    MILD(SPECIAL_ATTACK, DEFENSE),
    QUIET(SPECIAL_ATTACK, SPEED),
    BASHFUL,
    RASH(SPECIAL_ATTACK, SPECIAL_DEFENSE),
    CALM(SPECIAL_DEFENSE, ATTACK),
    GENTLE(SPECIAL_DEFENSE, DEFENSE),
    SASSY(SPECIAL_DEFENSE, SPEED),
    CAREFUL(SPECIAL_DEFENSE, SPECIAL_ATTACK),
    QUIRKY;

    public float getAttackModifier() {
        return get(ATTACK);
    }
    public float getDefenseModifier() {
        return get(DEFENSE);
    }
    public float getSpecialAttackModifier(){
        return get(SPECIAL_ATTACK);
    }
    public float getSpecialDefenseModifier(){
        return get(SPECIAL_DEFENSE);
    }
    public float getSpeedModifier(){
        return get(SPEED);
    }

    private float get(Stat attack) {
        if (boostedStat == attack){
            return 1.1f;
        }else if(decreasedStat == attack){
            return 0.9f;
        }else{
            return 1.0f;
        }
    }

    enum Stat{
        ATTACK,
        DEFENSE,
        SPECIAL_ATTACK,
        SPECIAL_DEFENSE,
        SPEED,
        NONE
    }


    private Stat boostedStat;
    private Stat decreasedStat;

    Nature(Stat boostedStat, Stat decreasedStat) {
        this.boostedStat = boostedStat;
        this.decreasedStat = decreasedStat;
    }
    Nature(){
        //some natures dont have effects at all
        this.boostedStat = NONE;
        this.decreasedStat = NONE;
    }

    @Override
    public String toString() {
        return name().substring(0,1) + name().substring(1).toLowerCase();
    }

    public static Nature generateNature(){
        return Nature.values()[new Random().nextInt(24)];
    }
}