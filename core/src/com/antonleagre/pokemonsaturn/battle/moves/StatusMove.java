package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.Pokemon;

/**
 * Status moves do NOT inflict damage, but they can: Change the weather, inflict status conditions, raise or lower the stats of a pokemon...
 */
public class StatusMove extends Move{

    public StatusMove(Pokemon.Type type, String name, int maxPP) {
        super(Category.STATUS, type, name, maxPP);
    }

    @Override
    public void beginBattle() {

    }

    @Override
    public void trigger(Battle battle) {

    }

    @Override
    public void endBattle() {

    }
}
