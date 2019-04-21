package com.antonleagre.pokemonsaturn.engine.maps.tiles;

import com.badlogic.gdx.math.Rectangle;

public class TriggerTile extends SpecialTile{

    public TriggerTile(Rectangle rectangle) {
        super(rectangle);
    }

    @Override
    public void trigger() {
        System.out.println("IM TRIGGERED");
    }
}
