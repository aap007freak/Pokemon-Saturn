package com.antonleagre.pokemonsaturn.battle;

public class DamageCalculator {
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



    /**
     * Calculates damage for damaging moves
     * @param attackingPokemon
     * @param defendingPokemon
     * @param attackingMove
     * @return
     */
    public static float calculate(Pokemon attackingPokemon, Pokemon defendingPokemon, Moves attackingMove){
       switch (attackingMove.getCategory()){

           case PHYSICAL: return  (((((2 * attackingPokemon.getLevel()) / 5) + 2) * attackingMove.getPower() * (attackingPokemon.getAttack() / defendingPokemon.getDefense()) / 50) + 2) * modifier();
           case SPECIAL:
       }
        return 0f;

    }

    private static float modifier(){
        return 1;
    }
}
