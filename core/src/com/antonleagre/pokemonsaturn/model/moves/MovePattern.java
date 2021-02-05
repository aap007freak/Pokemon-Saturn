package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.battle.Battle;

public interface MovePattern {

    boolean trigger(PMPair pm, Battle battle);

    void end();


}
