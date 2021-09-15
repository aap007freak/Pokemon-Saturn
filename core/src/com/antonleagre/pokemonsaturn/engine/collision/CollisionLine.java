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

    //all in screen coordinates
    private float startX, startY, endX, endY;

    private orientations orientation;


    public CollisionLine(float startX, float startY, float endX, float endY){
        if(startX > endX){
            this.startX = endX;
            this.endX = startX;
        }else{
            this.startX = startX;
            this.endX = endX;
        }
        if(startY > endY){
            this.startY = endY;
            this.endY = startY;
        }else{
            this.startY = startY;
            this.endY = endY;
        }
        if(this.startX != this.endX){
            this.orientation = CollisionLine.orientations.HORIZONTAL;
        }else{
            this.orientation = CollisionLine.orientations.VERTICAL;
        }
    }
    @Override
    public boolean collides(Rectangle proposedPosition, Rectangle currentPosition) {
        if(orientation == orientations.VERTICAL){
            if(startY <= currentPosition.y && currentPosition.y < endY){
                if(currentPosition.x == startX){ //the player to the right

                    return proposedPosition.x == startX - 16;
                }else if(currentPosition.x == startX - 16){
                    return proposedPosition.x == startX;
                }
            }
        }
        if(orientation == orientations.HORIZONTAL){
            if(startX <=currentPosition.x && currentPosition.x < endX ){
                if(currentPosition.y == startY){
                    //the player is above the line, he can't
                    return proposedPosition.y == startY - 16;
                }else if(currentPosition.y == startY - 16){
                    return proposedPosition.y == startY;
                }
            }
        }
        return false;
    }

    @Override
    public void render(ShapeRenderer srr) {
        srr.setColor(Color.BLUE);
        srr.line(startX ,startY ,endX, endY);
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

    @Override
    public String toString() {
        return "Line Start: (" + startX + ", " + startY + ") . Line End: (" + endX + ", " + endY + ")";
    }
}
