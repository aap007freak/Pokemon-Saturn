package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;

public class IncreasedCritChanceMovePattern extends DamageMovePattern{


    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        pm.getUser().raiseCritRatioModifier(1);
        boolean result =  super.trigger(pm, battle);
        pm.getUser().lowerCritRatioModifier(1);
        return result;
    }
}
