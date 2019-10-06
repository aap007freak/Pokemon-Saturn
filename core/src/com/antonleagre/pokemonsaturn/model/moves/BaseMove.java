package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.moves.patterns.DamageMovePattern;
import com.antonleagre.pokemonsaturn.model.pokemon.Type;

public enum BaseMove {

    POUND("Pound", Category.PHYSICAL, 35, 1f, Type.NORMAL, new DamageMovePattern(40f)),
    DOUBLE_SLAP("Double Slap", Category.PHYSICAL, 15, 0.85f, Type.NORMAL, new DamageMovePattern(0f)),
    KARATE_CHOP("Karate Chop",Category.PHYSICAL, 25, 1f,Type.FIGHTING, new DamageMovePattern(0f)),
    TESTING_MOVE("TEST", Category.PHYSICAL, 25, 1f, Type.FIGHTING, new DamageMovePattern(0f)),
    QUICKATTACKPRIORITY("TEST", Category.PHYSICAL, 25, 1f, Type.FIGHTING, new DamageMovePattern(0f), +2);


    public enum Category{
        PHYSICAL,
        SPECIAL,
        STATUS
    }

    private String displayName;
    private Category category;
    private int maxPP;
    private float accuracy;
    private Type type;
    private MovePattern functionality;
    private int priority;

    BaseMove(String displayName, Category category, int maxPP, float accuracy, Type type, MovePattern func) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.functionality = func;
        this.priority = 0;
    }

    BaseMove(String displayName, Category category, int maxPP, float accuracy, Type type, MovePattern func, int priority) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.functionality = func;
        this.priority = priority;
    }


    public String getDisplayName() {
        return displayName;
    }

    public Category getCategory() {
        return category;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public Type getType() {
        return type;
    }

    public MovePattern getFunctionality() {
        return functionality;
    }

    public int getPriority() {
        return priority;
    }
}
