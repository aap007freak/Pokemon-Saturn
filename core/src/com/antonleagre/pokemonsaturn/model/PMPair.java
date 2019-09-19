package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.moves.Move;

public class PMPair {

    private Pokemon user;
    private Move move;
    private Pokemon target;

    public PMPair(Pokemon user, Move move, Pokemon target) {
        this.user = user;
        this.move = move;
        this.target = target;
    }

    public void use(){
        move.use(this);
    }

    public Move getMove() {
        return move;
    }

    public Pokemon getTarget() {
        return target;
    }

    public Pokemon getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.getName() + getMove().getBase().getDisplayName();
    }
}
