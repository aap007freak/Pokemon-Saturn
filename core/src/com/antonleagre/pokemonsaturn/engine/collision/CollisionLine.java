package com.antonleagre.pokemonsaturn.engine.collision;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public class CollisionLine implements Collidable {

    public enum orientations{
        HORIZONTAL,
        VERTICAL
    }

    private float startX, startY, endX, endY;

    private Rectangle previousRectangle;

    private orientations orientation;

    public CollisionLine(float startX, float startY, float endX, float endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public boolean collides(Rectangle newProposedPosition, Rectangle currentPosition) {
        // TODO: 12/30/2017 work this funtion out, how do we check if a player collides with a line?
        if (orientation == orientations.HORIZONTAL && startY <= newProposedPosition.getY() &&  newProposedPosition.getX() <= endY){
            if( startY <= currentPosition.getY() &&  currentPosition.getY() <= endY){
                return true;
            }else{
                return false;
            }
        }if(orientation == orientations.VERTICAL && startY <= newProposedPosition.getY() &&  newProposedPosition.getY() <= endX){
            if( startY <= currentPosition.getX() &&  currentPosition.getX() <= endX){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        /**
         * if((startX <= newCollisionRectangle.getX() && newCollisionRectangle.getX() <= endX) && (startY <= newCollisionRectangle.getY() && newCollisionRectangle.getY() <= endY)){
         *             System.out.println("Aw, we collided");
         *             //if(orientation == orientations.VERTICAL && newCollisionRectangle.getY() != Rectangle.getY()) return true; if(orientation == orientations.HORIZONTAL && newCollisionRectangle.getY() != Rectangle.getX())
         *         }
          */

    }

    @Override
    public void render(ShapeRenderer srr, SpriteBatch sb) {
        srr.setColor(Color.BLUE);
        srr.line(startX ,startY ,endX, endY);
    }

    public void setOrientation(orientations orientation) {
        this.orientation = orientation;
    }

    public float getStartX() {
        return startX;
    }

    public float getEndX() {
        return endX;
    }

    public float getStartY() {
        return startY;
    }

    public float getEndY() {
        return endY;
    }
}
