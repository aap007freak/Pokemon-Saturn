package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Pokemon;

public enum BaseMove {

    POUND("Pound", Category.PHYSICAL, 35, 1f, Pokemon.Type.NORMAL, new DamageMovePattern(40f)),
    DOUBLE_SLAP("Double Slap", Category.PHYSICAL, 15, 0.85f, Pokemon.Type.NORMAL),
    KARATE_CHOP("Karate Chop",Category.PHYSICAL, 25, 1f,Pokemon.Type.FIGHTING),
    TESTING_MOVE("TEST", Category.PHYSICAL, 25, 1f, Pokemon.Type.FIGHTING);

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
    private MovePattern funtionality;

    //this is obsolete
     BaseMove(String displayName, Category category, int maxPP, float accuracy, Pokemon.Type type) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.funtionality = null;
    }
    BaseMove(String displayName, Category category, int maxPP, float accuracy, Pokemon.Type type, MovePattern specialMove) {
        this.displayName = displayName;
        this.category = category;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.type = type;
        this.funtionality = specialMove;
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

    public MovePattern getFuntionality() {
        return funtionality;
    }
}
