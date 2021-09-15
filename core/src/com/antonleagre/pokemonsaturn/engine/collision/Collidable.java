package com.antonleagre.pokemonsaturn.engine.collision;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public interface Collidable {
    boolean collides(Rectangle newCollisionRectangle, Rectangle oldCollisionRectangle);
    //each collidable object in the game has to be able to be rendered (as a debug option)
    void render(ShapeRenderer srr);

}
