package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Battle;

/**
 * Every move has to have these things.
 */
public interface MovePattern {

    void beginBattle();

    /**
     * The functionality of the move If it is triggere (e.g. damage the opponent, inflict a status condition...)
     * @param battle
     */
    void trigger(Battle battle);
    void endBattle();

}
