package com.antonleagre.pokemonsaturn.engine.entities;

import com.antonleagre.pokemonsaturn.engine.controllers.AIController;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class NPC extends Person {

    private AIController aiController;

    public NPC(Vector2 position, String textureAtlasName, TextureAtlas atlas) {
        super(position, textureAtlasName, atlas);
    }
}
