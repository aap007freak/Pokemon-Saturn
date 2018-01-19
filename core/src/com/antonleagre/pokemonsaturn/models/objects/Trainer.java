package com.antonleagre.pokemonsaturn.models.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Trainer extends Person {

    public Trainer(Vector2 position, Texture texture) {
        super(position, texture);
        System.out.println("created a trainer");
    }
}
