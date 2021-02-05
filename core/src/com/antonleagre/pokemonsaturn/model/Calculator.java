package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.BattlePokemon;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.BaseMove;

public class Calculator {
    /**
     * (got this of Bulbapedia)
     *
     *                    ( ( 2 * level) / 5 + 2 ) * Power * A / D
     *   damage =      (   -----------------------------------------  + 2 ) * modifier
     *                                            50
     *
     *NOTES: level as in the level of the attacking pokemon,
     *       power as in the physical or special power of the move
     *       A as the physical or special attack power of the pokemon
     *       D as the physical or special defense of the pokemon
     *
     *       Modfier;
     *          targets * weather * critical * random * stab * type * burn * other;
     *
     *         Targets is 0.75 if the move has more than one target, and 1 otherwise.
                Weather is 1.5 if a Water-type move is being used during rain or a Fire-type move during harsh sunlight, and 0.5 if a Water-type move is used during harsh sunlight or a Fire-type move during rain, and 1 otherwise.
                Badge is applied in Generation II only. It is 1.25 if the attacking Pokémon is controlled by the player and if the player has obtained the Badge corresponding to the used move's type, and 1 otherwise.
                Critical is applied starting in Generation II. It is 2 for a critical hit in Generations II-V, 1.5 for a critical hit from Generation VI onward, and 1 otherwise.
                random is a random factor between 0.85 and 1.00 (inclusive):
                    From Generation III onward, it is a random integer percentage between 0.85 and 1.00 (inclusive)
                    In Generations I and II, it is realized as a multiplication by a random uniformly distributed integer between 217 and 255 (inclusive), followed by an integer division by 255
                STAB is the same-type attack bonus. This is equal to 1.5 if the move's type matches any of the user's types, 2 if the user of the move additionally has Adaptability, and 1 if otherwise.
                Type is the type effectiveness. This can be 0 (ineffective); 0.25, 0.5 (not very effective); 1 (normally effective); 2 or 4 (super effective) depending on both the move's and target's types.
                Burn is 0.5 (from Generation III onward) if the attacker is burned, its Ability is not Guts, and the used move is a physical move (other than Facade from Generation VI onward), and 1 otherwise.
                 other is 1 in most cases, and a different multiplier when specific interactions of moves, Abilities or items take effect:
     */
    public static float calculateDamage(BattlePokemon attacking, BattlePokemon defending, BaseMove move, float power){
        float modifier = 1.0f; //todo modifier
        if(move.getCategory() == BaseMove.Category.PHYSICAL){
            return roundDown(
                    (((2 * (float) attacking.getPokemon().getLevel() / 5) + 2 ) * power * (attacking.getAttack() / defending.getDefense()) / 50 ) + 2
            ) * modifier;
        }
        return roundDown(
                (((2 * (float) attacking.getPokemon().getLevel() / 5) + 2 ) * power * (attacking.getSpattack() / defending.getSPdefense()) / 50 ) + 2
        ) * modifier;
        //todo this hasn't been checked
        // TODO: 5/02/2021 crit ratios
    }

        /**
     * Calculates accuracy based on <a href=https://bulbapedia.bulbagarden.net/wiki/Stat> this</a> source ( @see accuracy section).
     * <p>
     * Note that this function does not apply for moves that calculate their accuracy different than the normal formula, those need to have
     * different {@link com.antonleagre.pokemonsaturn.model.moves.MovePattern MovePatterns}.
     * @return Chance of move hitting (0-1)
     */
    public static float calculateAccuracy(PMPair pair, Battle battle){
        float move_accuracy = pair.getMove().getBase().getAccuracy();

        int accuracy_stage = pair.getUser().getBattleAccuracyModifier();
        int evasion_stage = pair.getTarget().getBattleEvasionModifier();
        float adjusted_stages = BattlePokemon.accuracyEvasionStageMultipliers[accuracy_stage - evasion_stage];

        float mods = 1; // this should be changed by battle


        return move_accuracy * adjusted_stages * mods;
    }

    /**
     * Calculates the stat of a Pokemon (other than hp) according to its level.
     * The formula is from Bulbapedia
     * The stat is rounded down if the result is a decimal. The stat is also rounded down before the Nature multiplier, if any, is applied.
     * @return
     */
    private static float calculateStatOtherThanHP(float baseValue, float IV, float EV, int level, float natureModifier){
        return roundDown(
                (roundDown(((2 * baseValue + IV + roundDown(EV / 4) )* level) / 100) + 5)* natureModifier
        );
    }

    /**
     * Calculates the HP stat of a Pokemon according to its level.
     * The formula is from Bulbapedia
     * The stat is rounded down if the result is a decimal. The stat is also rounded down before the Nature multiplier, if any, is applied.
     * @return the Actual HP stat that the pokemon has (according to Level, EV...)
     */
    public static float calculateHPStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseHP();
        float IV = pokemon.getiVs().getHpIV();
        float EV = pokemon.geteVs().getHpEV();
        int level = pokemon.getLevel();

        return roundDown(
                (((2 * baseValue + IV + roundDown(EV / 4) )* level) / 100) + level + 10
        );
    }

    public static float calculateAttackStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseAttack();
        float IV = pokemon.getiVs().getAttackIV();
        float EV = pokemon.geteVs().getAttackEV();
        int level = pokemon.getLevel();

        return calculateStatOtherThanHP(baseValue, IV, EV, level, pokemon.getNature().getAttackModifier());
    }

    public static float calculateSpecialAttackStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseSpAttack();
        float IV = pokemon.getiVs().getSpecialAttackIV();
        float EV = pokemon.geteVs().getSpecialAttackEV();
        int level = pokemon.getLevel();

        return calculateStatOtherThanHP(baseValue, IV, EV, level, pokemon.getNature().getSpecialAttackModifier());
    }
    public static float calculateDefenseStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseDefense();
        float IV = pokemon.getiVs().getDefenseIV();
        float EV = pokemon.geteVs().getDefenseEV();
        int level = pokemon.getLevel();

        return calculateStatOtherThanHP(baseValue, IV, EV, level, pokemon.getNature().getDefenseModifier());
    }

    public static float calculateSpecialDefenseStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseSpDefense();
        float IV = pokemon.getiVs().getSpecialDefenseIV();
        float EV = pokemon.geteVs().getSpecialDefenseEV();
        int level = pokemon.getLevel();

        return calculateStatOtherThanHP(baseValue, IV, EV, level, pokemon.getNature().getSpecialDefenseModifier());
    }

    public static float calculateSpeedStat(Pokemon pokemon){
        float baseValue = pokemon.getBaseStats().getBaseSpeed();
        float IV = pokemon.getiVs().getSpeedIV();
        float EV = pokemon.geteVs().getSpeedEV();
        int level = pokemon.getLevel();

        return calculateStatOtherThanHP(baseValue, IV, EV, level, pokemon.getNature().getSpeedModifier());
    }

    private static int roundDown(float value){
        return (int) Math.floor(value * 100) / 100;
    }
}
