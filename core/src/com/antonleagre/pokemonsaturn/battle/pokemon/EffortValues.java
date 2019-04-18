package com.antonleagre.pokemonsaturn.battle.pokemon;

/**
 * Effort Values are values that Pokemon get after each Battle in which they gain EXP (so no Battle Tower or lvl 100 pkmn).
 * There's a limit of 255 EV's per stat, 510 EV's total.
 * After a battle, 1, 2 or 3 EV's are given out to a particular stat, depending on the species
 *
 * There are also items that influence EV, those will be implemented later
 *
 */
public class EffortValues {

    private int hpEV;
    private int attackEV;
    private int defenseEV;
    private int specialAttackEV;
    private int specialDefenseEV;
    private int speedEV;

    private EVYieldByPokemon eVYield;

    public enum EVYieldByPokemon{
        MARILL(2,0,0,0,0,0),
        BULBASAUR(0,0,0,1,0,0);

        private int hpEVYield;
        private int attackEVYield;
        private int defenseEVYield;
        private int specialAttackEVYield;
        private int specialDefenseEVYield;
        private int speedEVYield;

        EVYieldByPokemon(int hpEVYield, int attackEVYield, int defenseEVYield, int specialAttackEVYield, int specialDefenseEVYield, int speedEVYield) {
            this.hpEVYield = hpEVYield;
            this.attackEVYield = attackEVYield;
            this.defenseEVYield = defenseEVYield;
            this.specialAttackEVYield = specialAttackEVYield;
            this.specialDefenseEVYield = specialDefenseEVYield;
            this.speedEVYield = speedEVYield;
        }
    }

    public EffortValues(int startingHpEV, int startingAttackEV, int startingDefenseEV, int startingSpecialAttackEV, int startingSpecialDefenseEV, int startingSpeedEV, EVYieldByPokemon pokemon) {
        this.hpEV = startingHpEV;
        this.attackEV = startingAttackEV;
        this.defenseEV = startingDefenseEV;
        this.specialAttackEV = startingSpecialAttackEV;
        this.specialDefenseEV = startingSpecialDefenseEV;
        this.speedEV = startingSpeedEV;
        this.eVYield = pokemon;
    }

    public int getHpEV() {
        return hpEV;
    }

    public int getAttackEV() {
        return attackEV;
    }

    public int getDefenseEV() {
        return defenseEV;
    }

    public int getSpecialAttackEV() {
        return specialAttackEV;
    }

    public int getSpecialDefenseEV() {
        return specialDefenseEV;
    }

    public int getSpeedEV() {
        return speedEV;
    }

    @Override
    public String toString() {
        return "HP: " + hpEV + "; Attack: " + attackEV + "; Defense: " + defenseEV + "\n" +
                "Special Attack: " + specialAttackEV + "; Special Defense: " + specialDefenseEV + "; Speed: " + speedEV + "\n" +
                "EV's will be added according to template: " + eVYield.name();
    }

    public static EffortValues generateEffortValues(EVYieldByPokemon pokemon){
        return new EffortValues(0,0,0,0,0,0, pokemon);
    }
}
