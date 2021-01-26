package com.antonleagre.pokemonsaturn.engine.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class UIController {

    private final Skin skin = null;
    private final Stage stage;
    private final Table table;

    private Dialoguebox box;

    public UIController(FileHandle skinFileHandle){
        this.stage = new Stage();
        //this.skin = new Skin(skinFileHandle);

        this.table = new Table();
        this.table.setFillParent(true);
        this.stage.addActor(table);

        //this.box = new Dialoguebox(skin);

        this.table.setDebug(true);
    }

    public void update(float dt){
        stage.act();
    }

    public void renderUI(){
        stage.draw();
    }

    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }

    public void dispose(){
        stage.dispose();
        skin.dispose();
    }


}
