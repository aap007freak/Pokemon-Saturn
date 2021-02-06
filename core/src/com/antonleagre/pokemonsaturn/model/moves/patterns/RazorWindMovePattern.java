package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;

import java.util.Random;

/**
 * MovePattern for <a href=https://bulbapedia.bulbagarden.net/wiki/Razor_Wind_(move)>Razor wind</a>
 */
public class RazorWindMovePattern extends MultipleTurnMovePattern {

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        return super.trigger(pm, battle);
    }

    @Override
    protected boolean useTurn(PMPair pm, Battle battle) {
        // TODO: 6/02/2021 Say "<Pokémon> whipped up a whirlwind!" on first turn
        return true;
    }

    @Override
    protected boolean firstAfter(PMPair pm, Battle battle) {
        new IncreasedCritChanceMovePattern().trigger(pm, battle); // on the second turn, the move acts like a Increased crit chance move
        return false;
    }

    protected boolean willHit(float accuracy) {
        return new Random().nextFloat() <= accuracy;
    }

    protected boolean willCrit(float critRatio) {
        return new Random().nextFloat() <= critRatio;

    }

}
