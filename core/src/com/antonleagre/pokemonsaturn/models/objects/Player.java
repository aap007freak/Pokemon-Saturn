package com.antonleagre.pokemonsaturn.models.objects;

import com.antonleagre.pokemonsaturn.controllers.MovementController;
import com.badlogic.gdx.graphics.Texture;
<<<<<<< HEAD:core/src/com/antonleagre/pokemonsaturn/models/Player.java
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
=======
import com.badlogic.gdx.graphics.g2d.TextureRegion;
>>>>>>> temp:core/src/com/antonleagre/pokemonsaturn/models/objects/Player.java
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

    @Override
    public void render(ShapeRenderer srr, SpriteBatch sb) {
        super.render(srr, sb);

    }

    public MovementController getMovementController() {
        return movementController;
    }
}
