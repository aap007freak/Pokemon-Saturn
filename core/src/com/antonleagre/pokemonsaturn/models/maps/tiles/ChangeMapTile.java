package com.antonleagre.pokemonsaturn.models.maps.tiles;

import com.antonleagre.pokemonsaturn.controllers.MapSegmentController;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ChangeMapTile extends SpecialTile{

    private MapSegmentController controller;

    private String mapToChangeTo;
    private Vector2 positionToChangeTo;

    public ChangeMapTile(Rectangle rectangle, MapSegmentController controller, String mapToChangeTo, Vector2 positionToChangeTo) {
        super(rectangle);
        this.controller = controller;
        this.mapToChangeTo = mapToChangeTo;
        this.positionToChangeTo = positionToChangeTo;
        System.out.println(positionToChangeTo);
    }

    @Override
    public void trigger() {
        controller.changeMap(mapToChangeTo, positionToChangeTo);
    }
}
