package com.antonleagre.pokemonsaturn.model.pokemon;

import java.util.Optional;

public enum Type {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY;

    public static Optional<Type> getWeaknesses(Type type){
        return null;
    }
}
