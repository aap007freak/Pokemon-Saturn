package com.antonleagre.pokemonsaturn.engine.entities;

import com.antonleagre.pokemonsaturn.engine.controllers.MovementController;
import com.antonleagre.pokemonsaturn.engine.entities.Person;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

/**
 *
 */
public class Player extends Person {

    private MovementController movementController;

    public Player(Vector2 position, String textureAtlasName, TextureAtlas atlas) {
        super(position, textureAtlasName, atlas);
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
