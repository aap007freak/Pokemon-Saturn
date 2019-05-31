package com.antonleagre.pokemonsaturn.model.pokemon;

/**
 * Effort Values are values that Pokemon get after each Battle in which they gain EXP (so no Battle Tower or lvl 100 pkmn).
 * There's a limit of 255 EV's per stat, 510 EV's total.
 * After a battle, 1, 2 or 3 EV's are given out to a particular stat, depending on the species
 *
 * There are also items that influence EV, those will be implemented later
 *
 * todo implement EV Yield
 */
public class EffortValues {

    private int hpEV;
    private int attackEV;
    private int defenseEV;
    private int specialAttackEV;
    private int specialDefenseEV;
    private int speedEV;

    public enum EVYieldByPokemonDefeated {
        MARILL(2,0,0,0,0,0),
        BULBASAUR(0,0,0,1,0,0),
        PIKACHU(0,0,0,0,0,2);

        private int hpEVYield;
        private int attackEVYield;
        private int defenseEVYield;
        private int specialAttackEVYield;
        private int specialDefenseEVYield;
        private int speedEVYield;

        EVYieldByPokemonDefeated(int hpEVYield, int attackEVYield, int defenseEVYield, int specialAttackEVYield, int specialDefenseEVYield, int speedEVYield) {
            this.hpEVYield = hpEVYield;
            this.attackEVYield = attackEVYield;
            this.defenseEVYield = defenseEVYield;
            this.specialAttackEVYield = specialAttackEVYield;
            this.specialDefenseEVYield = specialDefenseEVYield;
            this.speedEVYield = speedEVYield;
        }
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

    public EffortValues(){

    }


    @Override
    public String toString() {
        return "HP: " + hpEV + "; Attack: " + attackEV + "; Defense: " + defenseEV + "\n" +
                "Special Attack: " + specialAttackEV + "; Special Defense: " + specialDefenseEV + "; Speed: " + speedEV;
    }

    public static EffortValues generateEffortValues(){
        return new EffortValues();
    }
}