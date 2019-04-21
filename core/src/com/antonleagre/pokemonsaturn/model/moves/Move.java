package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Battle;

/**
 * A move is the skill Pokemon primarily use in battle. In battle, a Pokemon uses a move each turn.
 *
 * Every move has a BaseMoves object that determine the basic (final) properties and functionality of the move.
 * Changeable things (like PP or usability) will be defined here.
 */
public class Move {

    private BaseMove baseMove;
    private int pp;

    private boolean usable;

    public Move(BaseMove baseMove){
        this.baseMove = baseMove;
        this.pp = baseMove.getMaxPP();
    }

    public void use(Battle battle){
        baseMove.getFuntionality().trigger(battle);
        pp -= 1;
    }

}
