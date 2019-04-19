package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Pokemon;

/**
 * todo Make this an abstract class maybe
 */
public abstract class Move implements MoveType {

    public enum Category{
        PHYSICAL,
        SPECIAL,
        STATUS
    }

    private Category category;
    private Pokemon.Type type;

    private String name;
    private String description;

    private int maxPP;
    private int pp;

    public Move(Category category, Pokemon.Type type, String name, int maxPP) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.maxPP = maxPP;

        this.pp = maxPP;
    }
}
