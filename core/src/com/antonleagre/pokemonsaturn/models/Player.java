package com.antonleagre.pokemonsaturn.models;

import com.antonleagre.pokemonsaturn.controllers.MovementController;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Person{

    private MovementController movementController;

    public Player(Vector2 position, Texture texture) {
        super(position, texture);
        movementController = new MovementController(this);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        movementController.update();
    }

    public MovementController getMovementController() {
        return movementController;
    }
}
