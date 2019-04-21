package com.antonleagre.pokemonsaturn.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class AITrainer extends Person {


public AITrainer(Vector2 position, String texToGrab){
        super(position, new Texture("badlogic.jpg")); // TODO: 1/10/2018 use a textureatlas for all the trainers and make this work so you can just use a string to describle a trainer, it's texture, etc...
        }


}
