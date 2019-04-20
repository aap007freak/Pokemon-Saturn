package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;

public interface MovePattern {

    void beginBattle();
    void trigger(Battle battle);
    void endBattle();

}
