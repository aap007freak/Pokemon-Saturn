package com.antonleagre.pokemonsaturn.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.moves.Moves;
import com.antonleagre.pokemonsaturn.battle.Pokemon;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BattleScreen implements Screen {

    private Main main;
    private Battle battle;

    private Stage stage;
    private Texture texture;
    private Texture textureboxes;
    private TextureRegion textbox;

    public BattleScreen(Main main){
        this.main = main;
        stage = new Stage(new ScreenViewport());
        battle = new Battle();

         texture = new Texture(Gdx.files.internal("battle.png"));
        Image image = new Image(texture);
        image.setPosition(Gdx.graphics.getWidth() / 3 - image.getWidth() / 2, Gdx.graphics.getHeight() * 2 / 3 - image.getHeight());
        texture = new Texture(Gdx.files.internal("textboxes.png"));
        textbox = TextureRegion.split(texture, 254, 47)[0][0];
        Image textboximage = new Image(textbox);
        textboximage.scaleBy(1.5f);
        stage.addActor(textboximage);
        stage.addActor(image);
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
