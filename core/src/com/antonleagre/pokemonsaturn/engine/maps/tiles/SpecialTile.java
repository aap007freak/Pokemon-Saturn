package com.antonleagre.pokemonsaturn.engine.maps.tiles;

import com.antonleagre.pokemonsaturn.engine.collision.CollisionRectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public abstract class SpecialTile extends CollisionRectangle {

    public SpecialTile(com.badlogic.gdx.math.Rectangle rectangle) {
        super(rectangle);
    }

    //we want this to be checked for collisions so we now when the player steps into it,
    //but we dont actually want to collide with it, so we always return false;
    @Override
    public boolean collides(Rectangle rect, Rectangle obsoleteRect) {
        if(x < rect.getX() + rect.getWidth()){ //we do these two checks separately because the second one is more resource intensive; so if the first one fails we dont need to check the collision
            if(Intersector.overlaps(this, rect)){
                trigger();
                return false;
            }

        }else{
            return false;
        }
        return false;
    }
    public abstract void trigger();


    @Override
    public void render(ShapeRenderer renderer) {
        super.render(renderer);
    }


}
