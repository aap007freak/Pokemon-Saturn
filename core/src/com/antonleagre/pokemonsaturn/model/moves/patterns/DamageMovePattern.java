package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

public class DamageMovePattern implements MovePattern {

    private final float power;

    public DamageMovePattern(float power){
        this.power = power;
    }

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        return false;
    }

    @Override
    public boolean end() {
        return false;
    }


}
