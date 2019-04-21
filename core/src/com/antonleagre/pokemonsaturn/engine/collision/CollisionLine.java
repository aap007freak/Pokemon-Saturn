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

    private Rectangle previousRectangle;

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

        if(this.getStartX() != this.getEndX()){
            this.orientation = CollisionLine.orientations.HORIZONTAL;
        }else{
            this.orientation = CollisionLine.orientations.VERTICAL;
        }
    }

    //ydown
    @Override
    public boolean collides(Rectangle proposedPosition, Rectangle currentPosition) {

        if(orientation == orientations.VERTICAL){
            System.out.println("LINE LOC1: " + startX + ", " +  startY);
            System.out.println("LINE LOC2: " + endX + ", " +  endY);
            System.out.println("PLAYER LOC: " + proposedPosition.x + ", " + proposedPosition.y);
            if(startY <= proposedPosition.y && proposedPosition.y < endY){
                System.out.println("were god captioa nja");
            }
        }
        if(orientation == orientations.HORIZONTAL){
            if(startX <=currentPosition.x && currentPosition.x < endX ){
                if(currentPosition.y == getStartY()){
                    //the player is above the line, he can't
                    return proposedPosition.y == getStartY() - 16;
                }else if(currentPosition.y == getStartY() - 16){
                    return proposedPosition.y == getStartY();
                }

                //todo vertical + performance checking
            }
        }
        /**
         * if((startX <= newCollisionRectangle.getX() && newCollisionRectangle.getX() <= endX) && (startY <= newCollisionRectangle.getY() && newCollisionRectangle.getY() <= endY)){
         *             System.out.println("Aw, we collided");
         *             //if(orientation == orientations.VERTICAL && newCollisionRectangle.getY() != Rectangle.getY()) return true; if(orientation == orientations.HORIZONTAL && newCollisionRectangle.getY() != Rectangle.getX())
         *         }
          */

        return false;

    }

    @Override
    public void render(ShapeRenderer srr, SpriteBatch sb) {
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
