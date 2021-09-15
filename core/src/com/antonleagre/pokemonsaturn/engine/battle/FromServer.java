package com.antonleagre.pokemonsaturn.engine.battle;

public interface FromServer<T> {

    T toObject(String message);

}
