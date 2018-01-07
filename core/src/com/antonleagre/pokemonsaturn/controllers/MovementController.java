package com.antonleagre.pokemonsaturn.controllers;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.models.Person;
import com.antonleagre.pokemonsaturn.models.collision.Collidable;
import com.antonleagre.pokemonsaturn.models.collision.CollisionRectangle;
import com.antonleagre.pokemonsaturn.screens.PlayScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import static com.antonleagre.pokemonsaturn.models.Person.states.STANDING;

public class MovementController {
    private Person person;
    private ArrayList<Collidable> obstacles;

    public MovementController(Person person){
        this.person = person;
        this.obstacles = new ArrayList<>();
    }

    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && person.getState() == STANDING){
            person.setFacing(Person.facing.UP);
            if(!willCollideWithAnything(0,1)) person.move(0, 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && person.getState() == STANDING){
            person.setFacing(Person.facing.DOWN);
            if(!willCollideWithAnything(0,-1)) person.move(0, -1);

        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && person.getState() == STANDING){
            person.setFacing(Person.facing.LEFT);
            if(!willCollideWithAnything(-1,0)) person.move(-1, 0);

        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && person.getState() == STANDING){
            person.setFacing(Person.facing.RIGHT);
            if(!willCollideWithAnything(1,0)) person.move(1, 0);

        }
        // TODO: 12/28/2017 clean this debug code up
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            if(!PlayScreen.debug){
                PlayScreen.debug = true;
            }else{
                PlayScreen.debug = false;
            }
            System.out.println(PlayScreen.debug);
        }
    }



    private boolean willCollideWithAnything(int dx, int dy) {
        Vector2 proposedPosition = new Vector2(person.getX(), person.getY()).cpy().add(dx,dy);
        CollisionRectangle proposedRect = new CollisionRectangle(proposedPosition.x * Main.TILE_SIZE, proposedPosition.y * Main.TILE_SIZE, Main.TILE_SIZE, Main.TILE_SIZE);

        for (Collidable collidable : obstacles){
            if(collidable.collides(proposedRect, person.getCollisonRectangle())){
                return true;
            }
        }
        return false;
    }

    public void setObstacles(ArrayList<Collidable> obstacles) {
        this.obstacles = obstacles;
    }
}
