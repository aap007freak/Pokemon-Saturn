package com.antonleagre.pokemonsaturn.model.battle;

import com.antonleagre.pokemonsaturn.model.Pokemon;

public class BattlePokemon {

    private final Pokemon pokemon;

    //these can be different from basestats when using power-up moves and the like
    private float battleAttack;
    private int battleAttackModifier;
    private float battleDefense;
    private int battleDefenseModifier;
    private float battleSpattack;
    private int battleSpattackModifer;
    private float battleSPdefense;
    private int battleSpdefenseModifier;
    private float battleSpeed;
    private int battleSpeedModifier;

    //in battle stats
    private float battleEvasion;
    private int battleEvasionModifier;
    private float battleAccuracy;
    private int battleAccuracyModifier;

    private float battleCritRatio;
    private int batleCritRatioModifier;

    public static final float[] accuracyEvasionStageMultipliers = {33/100f,36/100f, 43/100f, 50/100f, 60/100f, 75/100f, 1f, 133/100f, 166/100f, 200/100f, 250/100f, 266/100f, 300/100f};
    public static final float[] attackDefenseSpecialSpeedMultipliers = {2/8f, 2/7f, 2/6f, 2/5f, 2/4f, 2/3f, 1f, 3/2f, 4/2f, 5/2f, 6/2f, 7/2f, 8/2f};
    public static final float[] critRatioMultipliers = {1/16f, 1/8f, 1/4f, 1/3f, 1/2f};

        public BattlePokemon(Pokemon pokemon) {
        this.pokemon = pokemon;

        this.battleAttack = pokemon.getAttack();
        this.battleDefense = pokemon.getDefense();
        this.battleSpattack = pokemon.getSpAttack();
        this.battleSPdefense = pokemon.getSpDefense();
        this.battleSpeed = pokemon.getSpeed();

        this.battleAccuracy = 1;
        this.battleEvasion = 1;

        this.battleAttackModifier = this.battleDefenseModifier = this.battleSpattackModifer = this.battleSpdefenseModifier
                = this.battleSpeedModifier = this.battleAccuracyModifier = this.battleEvasionModifier = 0;

        this.batleCritRatioModifier = 0;
        this.battleCritRatio = critRatioMultipliers[this.batleCritRatioModifier];
    }

    public float getHP(){
            return pokemon.getHp();
    }

    public float getAttack() {
        return battleAttack;
    }

    public float getDefense() {
        return battleDefense;
    }

    public float getSpattack() {
        return battleSpattack;
    }

    public float getSPdefense() {
        return battleSPdefense;
    }

    public float getSpeed() {
        return battleSpeed;
    }

    public float getEvasion() {
        return battleEvasion;
    }

    public float getAccuracy() {
        return battleAccuracy;
    }

    public float getCritRatio() {
        return battleCritRatio;
    }

    public int getBattleAttackModifier() {
        return battleAttackModifier;
    }

    public int getBattleDefenseModifier() {
        return battleDefenseModifier;
    }

    public int getBattleSpattackModifer() {
        return battleSpattackModifer;
    }

    public int getBattleSpdefenseModifier() {
        return battleSpdefenseModifier;
    }

    public int getBattleSpeedModifier() {
        return battleSpeedModifier;
    }

    public int getBattleEvasionModifier() {
        return battleEvasionModifier;
    }

    public int getBattleAccuracyModifier() {
        return battleAccuracyModifier;
    }

    public int getCritRatioModifier() {
        return batleCritRatioModifier;
    }

    public void setBattleAttackModifier(int battleAttackModifier) throws IllegalArgumentException{
        if (-6 <= battleAttackModifier && battleAttackModifier <= 6){
            this.battleAttackModifier = battleAttackModifier;
            this.battleAttack = attackDefenseSpecialSpeedMultipliers[6+battleAttackModifier] * this.battleAttack;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleDefenseModifier(int battleDefenseModifier) throws IllegalArgumentException {
        if (-6 <= battleDefenseModifier && battleDefenseModifier <= 6){
            this.battleDefenseModifier = battleDefenseModifier;
            this.battleDefense = attackDefenseSpecialSpeedMultipliers[6+battleDefenseModifier] * this.battleDefense;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleSpattackModifer(int battleSpattackModifer) throws IllegalArgumentException {
        if (-6 <= battleSpattackModifer && battleSpattackModifer <= 6){
            this.battleSpattackModifer = battleSpattackModifer;
            this.battleSpattack = attackDefenseSpecialSpeedMultipliers[6+battleSpattackModifer] * this.battleSpattack;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleSpdefenseModifier(int battleSpdefenseModifier) throws IllegalArgumentException {
        if (-6 <= battleSpdefenseModifier && battleSpdefenseModifier <= 6){
            this.battleSpdefenseModifier = battleSpdefenseModifier;
            this.battleSPdefense = attackDefenseSpecialSpeedMultipliers[6+battleSpdefenseModifier] * this.battleSPdefense;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleSpeedModifier(int battleSpeedModifier) throws IllegalArgumentException {
        if (-6 <= battleSpeedModifier && battleSpeedModifier <= 6){
            this.battleSpeedModifier = battleSpeedModifier;
            this.battleSpeed = attackDefenseSpecialSpeedMultipliers[6+battleSpeedModifier] * this.battleSpeed;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleAccuracyModifier(int battleAccuracyModifier) throws IllegalArgumentException{
        if (-6 <= battleAccuracyModifier && battleAccuracyModifier <= 6){
            this.battleAccuracyModifier = battleAccuracyModifier;
            this.battleAccuracy = accuracyEvasionStageMultipliers[6+battleAccuracyModifier] * this.battleAccuracy;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    public void setBattleEvasionModifier(int battleEvasionModifier) throws IllegalArgumentException {
        if (-6 <= battleEvasionModifier && battleEvasionModifier <= 6){
            this.battleEvasionModifier = battleEvasionModifier;
            this.battleEvasion = accuracyEvasionStageMultipliers[6+battleEvasionModifier] * this.battleEvasion;
        }else{
            throw new IllegalArgumentException("Battle Modifiers must be between -6 and 6");
        }
    }

    /**
     * from 0 inclusive to a maximum of +4 inclusive
     * @param batleCritRatioModifier
     */
    public void setBattleCritRatioModifier(int batleCritRatioModifier) throws IllegalArgumentException {
        if (0 <= batleCritRatioModifier){
            if(batleCritRatioModifier > 4){
                this.battleCritRatio = critRatioMultipliers[3];

            }else{
                this.battleCritRatio = critRatioMultipliers[batleCritRatioModifier - 1];

            }
            this.batleCritRatioModifier = batleCritRatioModifier;
        }else{
            throw new IllegalArgumentException("Crit Ratio Modifier must be greater than 0");
        }
    }

    // TODO: 6/02/2021 These functions should check if the stages are in an acceptable range,
    //  but not throw errors if it is above the accepted value. I.e. 5 + 3 = 6
    public void raiseAttackModifier(int stages){
        setBattleAttackModifier(battleAttackModifier + stages);
    }

    public void raiseDefenseModifier(int stages){
        setBattleDefenseModifier(battleDefenseModifier + stages);
    }

    public void raiseSpecialAttackModifier(int stages){
        setBattleSpattackModifer(battleSpattackModifer + stages);
    }

    public void raiseSpecialDefenseModifier(int stages){
        setBattleSpdefenseModifier(battleSpdefenseModifier + stages);
    }

    public void raiseSpeedModifier(int stages){

    }

    public void raiseAccuracyModifier(int stages){
        setBattleAccuracyModifier(battleAccuracyModifier + stages);
    }

    public void raiseEvasionModifier(int stages){
        setBattleEvasionModifier(battleEvasionModifier + stages);
    }

    public void raiseCritRatioModifier(int stages){
        setBattleCritRatioModifier(batleCritRatioModifier + stages);
    }

    public void lowerCritRatioModifier(int stages){
        setBattleCritRatioModifier(batleCritRatioModifier - stages);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getName() {
        return pokemon.getName();
    }


}
