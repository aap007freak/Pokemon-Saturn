package com.antonleagre.pokemonsaturn.battle.moves;

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

}
