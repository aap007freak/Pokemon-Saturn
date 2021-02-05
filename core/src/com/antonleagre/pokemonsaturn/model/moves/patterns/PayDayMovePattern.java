package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;

public class PayDayMovePattern extends DamageMovePattern{

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        boolean result =  super.trigger(pm, battle);
        // TODO: 5/02/2021 Affects prize money, see https://bulbapedia.bulbagarden.net/wiki/Pay_Day_(move)
        return result;
    }
}
