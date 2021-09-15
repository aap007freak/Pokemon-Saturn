package com.antonleagre.pokemonsaturn.engine.ui;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.engine.screens.PlayScreen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class UIController {

    private final Skin skin;
    private final Stage stage;
    private final Table table;

    private Dialoguebox box;
    private TextArea fps;

    private float previous_dt;

    public UIController(FileHandle skinFileHandle){
        this.stage = new Stage(new FitViewport(Main.V_WIDTH, Main.V_HEIGHT));
        this.stage.setDebugAll(true);
        //todo this should happen in asset loading
        this.skin = new Skin(skinFileHandle);

        table = new Table();
        this.table.setFillParent(true);
        this.stage.addActor(table);

        initUI();


    }

    private void initUI(){
        this.box = new Dialoguebox(skin);
        fps = new TextArea("This is a test label", skin);
        table.top();
        table.left();
        table.add(fps);
    }


    public void update(float dt){
        if (PlayScreen.debug){
            fps.setVisible(true);
            float frames_per_second = 1/(dt);
            fps.setText("FPS: " + frames_per_second);
        }else {
            fps.setVisible(false);
        }
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
