package com.antonleagre.pokemonsaturn.engine.battle;

public interface FromServer<T> {

    String prefix();

    T toObject(String message);

}
