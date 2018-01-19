package com.antonleagre.pokemonsaturn.batlle;

public class Move {

    public enum Category{
        PHYSICAL,
        SPECIAL
    }

    private String displayName;
    private Category category;
    private int power;
    private float accuracy;

    public Move(String displayName, Category category, int power, float accuracy) {
        this.displayName = displayName;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
    }

    public Category getCategory() {
        return category;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public int getPower() {
        return power;
    }

    public String getDisplayName() {
        return displayName;
    }
}

