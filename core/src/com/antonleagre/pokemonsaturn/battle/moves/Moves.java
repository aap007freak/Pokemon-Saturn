package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Pokemon;

public enum Moves {

    POUND("Pound", Category.PHYSICAL, 40, 1f, Pokemon.Type.NORMAL),
    DOUBLE_SLAP("Double Slap", Category.PHYSICAL, 15, 0.85f, Pokemon.Type.NORMAL),
    KARATE_CHOP("Karate Chop",Category.PHYSICAL, 25, 1f,Pokemon.Type.FIGHTING),
    TESTING_MOVE("TEST", Category.PHYSICAL, 25, 1f, Pokemon.Type.FIGHTING);

    public enum Category{
        PHYSICAL,
        SPECIAL
    }


    private String displayName;
    private Category category;
    private int power;
    private float accuracy;
    private Pokemon.Type type;
    private MoveType moveType;

     Moves(String displayName, Category category, int power, float accuracy, Pokemon.Type type) {
        this.displayName = displayName;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.type = type;
        this.moveType = null;
    }
    Moves(String displayName, Category category, int power, float accuracy, Pokemon.Type type, MoveType specialMove) {
        this.displayName = displayName;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.type = type;
        this.moveType = specialMove;
    }
    Moves(String name, MoveType specialMove) {
        this.moveType = specialMove;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Category getCategory() {
        return category;
    }

    public int getPower() {
        return power;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public Pokemon.Type getType() {
        return type;
    }
}
