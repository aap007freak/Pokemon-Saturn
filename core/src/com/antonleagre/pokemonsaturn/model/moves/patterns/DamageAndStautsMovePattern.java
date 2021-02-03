package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

public class DamageAndStautsMovePattern implements MovePattern {


    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        return false;
    }

    @Override
    public boolean end() {
        return false;
    }
}
