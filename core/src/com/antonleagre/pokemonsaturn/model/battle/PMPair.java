package com.antonleagre.pokemonsaturn.model.battle;

import com.antonleagre.pokemonsaturn.model.Pokemon;
import com.antonleagre.pokemonsaturn.model.moves.Move;

public class PMPair {

    private BattlePokemon user;
    private Move move;
    private BattlePokemon target;

    public PMPair(BattlePokemon user, Move move, BattlePokemon target) {
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

    public BattlePokemon getTarget() {
        return target;
    }

    public BattlePokemon getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.getName() + getMove().getBase().getDisplayName();
    }
}
