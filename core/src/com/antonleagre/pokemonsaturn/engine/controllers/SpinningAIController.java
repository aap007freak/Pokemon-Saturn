package com.antonleagre.pokemonsaturn.engine.controllers;

import com.antonleagre.pokemonsaturn.engine.entities.NPC;

/**
 *
 */
public class SpinningAIController extends AIController{

    private enum Sides{
        TOP, BOTTOM, LEFT, RIGHT
    }

    private final Sides[] allowedSides;
    private int currentSide; //index of current sides

    /**
     *
     * @param npc
     * @param predict
     * @param sides
     */
    public SpinningAIController(NPC npc, boolean predict, Sides... sides) {
        super(npc);
        this.allowedSides = sides;
    }

    /**
     *
     * @param npc
     * @param predict
     */
    public SpinningAIController(NPC npc, boolean predict) {
        super(npc);
        this.allowedSides = Sides.values();
    }
}
