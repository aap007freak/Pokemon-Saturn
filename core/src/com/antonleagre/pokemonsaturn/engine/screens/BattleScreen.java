package com.antonleagre.pokemonsaturn.engine.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BattleScreen implements Screen {

    private Main main;
   // private Battle battle;

    private Stage stage;
    private Texture texture;
    private Texture textureboxes;
    private TextureRegion textbox;

    public BattleScreen(Main main){
        this.main = main;
        stage = new Stage(new ScreenViewport());
//        battle = new Battle();

    }

    @Override
    public void show() {

    }

    private void update(float dt){
        stage.act(dt);

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        texture.dispose();
        textureboxes.dispose();
    }
}
