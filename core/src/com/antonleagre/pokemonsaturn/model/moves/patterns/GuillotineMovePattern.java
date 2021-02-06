package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;

import java.util.Random;

/**
 * MovePattern for the Move {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove Guillotine}
 * Accuracy calculations from Bulbapedia.
 */
public class GuillotineMovePattern extends OHKOMovePattern{

    @Override
    boolean willHit(PMPair pm, Battle battle) {
        float chance = (pm.getUser().getPokemon().getLevel() - pm.getTarget().getPokemon().getLevel() + 30) / 100f;
        return new Random().nextFloat() <= chance;
    }
}
