package com.antonleagre.pokemonsaturn.models.objects;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.models.collision.CollisionRectangle;
import com.antonleagre.pokemonsaturn.screens.PlayScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

import static com.antonleagre.pokemonsaturn.models.objects.Person.facing.DOWN;
import static com.antonleagre.pokemonsaturn.models.objects.Person.states.STANDING;
import static com.antonleagre.pokemonsaturn.models.objects.Person.states.WALKING;

public class Person {
    private final float ANIMATIONSPEED = 1/10f; //ten frames a second
    private final float ANIMATIONTOTALDURATION = ANIMATIONSPEED * 3;


    //the position in tile coordinates
    private  Vector2 position;

    private final CollisionRectangle rectangle;

    private final HashMap<String, Array<TextureRegion>> allAnimationFrames;

    private final Animation walkingTileUpwards;
    private final Animation walkingTileDownwards;
    private final Animation walkingTileLeft;
    private final Animation walkingTileRight;

    private final Array<TextureRegion> standing;

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

    public Person(Vector2 position, Texture texture) {
        this.position = position;
        this.rectangle = new CollisionRectangle(position.x * Main.TILE_SIZE, position.y * Main.TILE_SIZE, Main.TILE_SIZE, Main.TILE_SIZE);

        facing = DOWN;
        state = STANDING;

        startPosition = new Vector2(position);
        walkingDrawPosition = new Vector2();

        allAnimationFrames = Util.parseCharacterTextureRegions(texture);
        standing = allAnimationFrames.get("standing");
        walkingTileDownwards = new Animation(ANIMATIONSPEED,allAnimationFrames.get("down"), Animation.PlayMode.NORMAL);
        walkingTileUpwards = new Animation(ANIMATIONSPEED,allAnimationFrames.get("up"), Animation.PlayMode.NORMAL);
        walkingTileLeft = new Animation(ANIMATIONSPEED,allAnimationFrames.get("left"), Animation.PlayMode.NORMAL);
        walkingTileRight = new Animation(ANIMATIONSPEED,allAnimationFrames.get("right"), Animation.PlayMode.NORMAL);

    }

    public void update(float dt) {
        if(state == WALKING){
            stateTimer += dt;
            walkingDrawPosition.x = Interpolation.linear.apply(startPosition.x, position.x, stateTimer * 3);
            walkingDrawPosition.y = Interpolation.linear.apply(startPosition.y, position.y, stateTimer * 3);
            if(stateTimer > ANIMATIONTOTALDURATION){  // animation is finished
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


        if(PlayScreen.debug) rectangle.render(srr, sb);

    }



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
