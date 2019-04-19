package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;

public interface MoveType {

    void beginBattle();
    void trigger(Battle battle);
    void endBattle();

}
