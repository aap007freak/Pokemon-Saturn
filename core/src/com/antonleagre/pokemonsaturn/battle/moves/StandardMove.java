package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.Pokemon;

public class StandardMove extends Move {

    private float power;

    public StandardMove(Category category, Pokemon.Type type, String name, int maxPP) {
        super(category, type, name, maxPP);
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
