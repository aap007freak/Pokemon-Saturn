package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Pokemon;

public enum BaseMove {

    POUND("Pound", Category.PHYSICAL, 35, 1f, Pokemon.Type.NORMAL, new DamageMovePattern(40f)),
    DOUBLE_SLAP("Double Slap", Category.PHYSICAL, 15, 0.85f, Pokemon.Type.NORMAL, new DamageMovePattern(0f)),
    KARATE_CHOP("Karate Chop",Category.PHYSICAL, 25, 1f,Pokemon.Type.FIGHTING, new DamageMovePattern(0f)),
    TESTING_MOVE("TEST", Category.PHYSICAL, 25, 1f, Pokemon.Type.FIGHTING, new DamageMovePattern(0f)),
    QUICKATTACKPRIORITY("TEST", Category.PHYSICAL, 25, 1f, Pokemon.Type.FIGHTING, new DamageMovePattern(0f), +2);

    public enum Category{
        PHYSICAL,
        SPECIAL,
        STATUS
    }

    private String displayName;
    private Category category;
    private int maxPP;
    private float accuracy;
    private Pokemon.Type type;
    private MovePattern functionality;
    private int priority;

    BaseMove(String displayName, Category category, int maxPP, float accuracy, Pokemon.Type type, MovePattern func) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.functionality = func;
    }

    BaseMove(String displayName, Category category, int maxPP, float accuracy, Pokemon.Type type, MovePattern func, int priority) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.functionality = func;
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

    public Pokemon.Type getType() {
        return type;
    }

    public MovePattern getFunctionality() {
        return functionality;
    }

    public int getPriority() {
        return priority;
    }
}
