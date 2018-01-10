package com.antonleagre.pokemonsaturn.models.collision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public class CollisionLine implements Collidable {

    private enum orientations{
        HORIZONTAL,
        VERTICAL
    }

    private float startX, startY, endX, endY;

    private com.badlogic.gdx.math.Rectangle previousRectangle;

    private orientations orientation;

    public CollisionLine(float startX, float startY, float endX, float endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        if(startX == endX){
            orientation = orientations.VERTICAL;
        }else{
            orientation = orientations.HORIZONTAL;
        }
    }

    @Override
    public boolean collides(Rectangle newCollisionRectangle, Rectangle Rectangle) {
        // TODO: 12/30/2017 work this funtion out, how do we check if a player collides with a line?
        if((startX <= newCollisionRectangle.getX() && newCollisionRectangle.getX() <= endX) && (startY <= newCollisionRectangle.getY() && newCollisionRectangle.getY() <= endY)){
            System.out.println("Aw, we collided");
            //if(orientation == orientations.VERTICAL && newCollisionRectangle.getY() != Rectangle.getY()) return true; if(orientation == orientations.HORIZONTAL && newCollisionRectangle.getY() != Rectangle.getX())
        }
        return false;
    }

    @Override
    public void render(ShapeRenderer srr, SpriteBatch sb) {
        srr.setColor(Color.BLUE);
        srr.line(startX ,startY ,endX, endY);
    }
}
