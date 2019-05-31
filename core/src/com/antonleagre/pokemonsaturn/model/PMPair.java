package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.moves.Move;

public class PMPair {

    private Pokemon user;
    private Move move;
    private Pokemon target;

    public PMPair(Pokemon user) {
        this.user = user;
    }

    public Pokemon getUser() {
        return user;
    }

    public Move getMove() {
        return move;
    }

    public Pokemon getTarget() {
        return target;
    }
}
