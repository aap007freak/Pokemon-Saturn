package com.antonleagre.pokemonsaturn.engine.entities;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.engine.collision.CollisionRectangle;
import com.antonleagre.pokemonsaturn.engine.screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

import static com.antonleagre.pokemonsaturn.engine.entities.Person.facing.DOWN;
import static com.antonleagre.pokemonsaturn.engine.entities.Person.states.STANDING;
import static com.antonleagre.pokemonsaturn.engine.entities.Person.states.WALKING;

public class Person {
    private final float animationSpeed = 1/10f; //ten frames a second
    private final float animationTotalDuration = animationSpeed * 3;

    //the position in tile coordinates
    private Vector2 position;

    private CollisionRectangle rectangle;

    private HashMap<String, Array<TextureRegion>> allAnimationFrames;

    private Animation<TextureRegion> walkingTileUpwards;
    private Animation<TextureRegion> walkingTileDownwards;
    private Animation<TextureRegion> walkingTileLeft;
    private Animation<TextureRegion> walkingTileRight;

    private Array<TextureRegion> standing;

    private float stateTimer = 0;
    private Vector2 startPosition; //for position interpolating
    private Vector2 walkingDrawPosition; //idem


    public enum facing {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public enum states {
        STANDING,
        WALKING,
    }

    private facing facing;
    private states state;

    public Person(Vector2 position, String textureAtlasName, TextureAtlas atlas) {
        this.position = position;
        this.rectangle = new CollisionRectangle(position.x * Main.TILE_SIZE, position.y * Main.TILE_SIZE, Main.TILE_SIZE, Main.TILE_SIZE);

        facing = DOWN;
        state = STANDING;

        startPosition = new Vector2(position);
        walkingDrawPosition = new Vector2();

        allAnimationFrames = Util.parseCharacterTextureRegions(atlas, textureAtlasName);
        standing = allAnimationFrames.get("standing");
        walkingTileDownwards = new Animation(animationSpeed,allAnimationFrames.get("down"), Animation.PlayMode.NORMAL);
        walkingTileUpwards = new Animation(animationSpeed,allAnimationFrames.get("up"), Animation.PlayMode.NORMAL);
        walkingTileLeft = new Animation(animationSpeed,allAnimationFrames.get("left"), Animation.PlayMode.NORMAL);
        walkingTileRight = new Animation(animationSpeed,allAnimationFrames.get("right"), Animation.PlayMode.NORMAL);

    }

    public void update(float dt) {
        if(state == WALKING){
            stateTimer += dt;
            walkingDrawPosition.x = Interpolation.linear.apply(startPosition.x, position.x, stateTimer * 3);
            walkingDrawPosition.y = Interpolation.linear.apply(startPosition.y, position.y, stateTimer * 3);
            if(stateTimer > animationTotalDuration){  // animation is finished
                state = STANDING;
                stateTimer = 0;

            }
        }
    }


    public void render(ShapeRenderer srr, SpriteBatch sb){
         if (state == STANDING){
            switch (facing){
                case UP:
                    sb.draw(standing.get(0), position.cpy().scl(Main.TILE_SIZE).x - Main.TILE_SIZE / 2, position.cpy().scl(Main.TILE_SIZE).y);
                    break;
                case DOWN:
                    sb.draw(standing.get(1), position.cpy().scl(Main.TILE_SIZE).x - Main.TILE_SIZE / 2, position.cpy().scl(Main.TILE_SIZE).y);
                    break;
                case LEFT:
                    sb.draw(standing.get(2), position.cpy().scl(Main.TILE_SIZE).x - Main.TILE_SIZE / 2, position.cpy().scl(Main.TILE_SIZE).y);
                    break;
                case RIGHT:
                    sb.draw(standing.get(3), position.cpy().scl(Main.TILE_SIZE).x - Main.TILE_SIZE / 2, position.cpy().scl(Main.TILE_SIZE).y);
                    break;
            }
        }
        else if(state == WALKING){
            switch (facing){
                case UP:

                    sb.draw(walkingTileUpwards.getKeyFrame(stateTimer), walkingDrawPosition.x * Main.TILE_SIZE - Main.TILE_SIZE / 2, walkingDrawPosition.y * Main.TILE_SIZE);
                    break;
                case DOWN:
                    sb.draw(walkingTileDownwards.getKeyFrame(stateTimer), walkingDrawPosition.x * Main.TILE_SIZE - Main.TILE_SIZE / 2, walkingDrawPosition.y * Main.TILE_SIZE);
                    break;
                case LEFT:
                    sb.draw(walkingTileLeft.getKeyFrame(stateTimer), walkingDrawPosition.x * Main.TILE_SIZE - Main.TILE_SIZE / 2, walkingDrawPosition.y * Main.TILE_SIZE);
                    break;
                case RIGHT:
                    sb.draw(walkingTileRight.getKeyFrame(stateTimer), walkingDrawPosition.x * Main.TILE_SIZE - Main.TILE_SIZE / 2, walkingDrawPosition.y * Main.TILE_SIZE);
                    break;
            }
        }

        postRender(srr, sb);

    }

    /**
     * Post rendering tasks
     * @param srr
     * @param sb
     */
    private void postRender(ShapeRenderer srr, SpriteBatch sb){
        if(PlayScreen.debug) rectangle.render(srr);
    }


    public void dispose(){}

    /**
     * Called by the MovementController or another controller
     * @param dx
     * @param dy
     */
    public void move(float dx, float dy){
        startPosition = position.cpy();
        position.x += dx;
        position.y += dy;
        rectangle.setPosition(position.x * Main.TILE_SIZE, position.y * Main.TILE_SIZE);
        state = WALKING;
    }


    public void set(Vector2 newPosition){
        position = newPosition;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public CollisionRectangle getCollisonRectangle() {
        return rectangle;
    }

    public Vector2 getWalkingDrawPosition() {
        return walkingDrawPosition;
    }

    public void setFacing(Person.facing facing) {
        this.facing = facing;
    }

    public Person.facing getFacing() {
        return facing;
    }

    public Vector2 getPosition() {
        return position;
    }

    public states getState() {
        return state;
    }
}
