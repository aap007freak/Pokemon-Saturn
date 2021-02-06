package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

/**
 * MovePattern that encapsulates all moves that One-hit-K-O their opponent. Many of these moves have indepent accuracy
 * calculations, so the implementation of {@link #willHit(PMPair, Battle)} will be different for each Move.
 */
public abstract class OHKOMovePattern implements MovePattern {

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        if (willHit(pm, battle)) {
            battle.inflictDamage(pm.getTarget(), pm.getTarget().getHP());
        }
        return false;
    }

    @Override
    public void end() {

    }

    abstract boolean willHit(PMPair pm, Battle battle);


}
