package com.antonleagre.pokemonsaturn.models.collision;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CollisionRectangle extends Rectangle implements Collidable {

    public CollisionRectangle(float x, float y, int width, int height){
        super(x, y, width, height);
    }

    public CollisionRectangle(com.badlogic.gdx.math.Rectangle rectangle){
        super(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public boolean collides(Rectangle rect, Rectangle obsoleteRect){
        if(x < rect.getX() + rect.getWidth()){
            return (Intersector.overlaps(this, rect));
        }
        return false;
    }


    @Override
    public void render(ShapeRenderer srr, SpriteBatch sb) {
        srr.setColor(Color.RED);
        srr.rect(x,y,width, height);
    }

    @Override
    public Vector2 getPosition(Vector2 position) {
        return super.getPosition(position);
    }
}
