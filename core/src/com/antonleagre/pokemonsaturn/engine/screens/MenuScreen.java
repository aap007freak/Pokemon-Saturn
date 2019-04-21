package com.antonleagre.pokemonsaturn.engine.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MenuScreen implements Screen {

    private Main main;
    private BitmapFont font;

    public MenuScreen(Main main){
        this.main = main;
        font = new BitmapFont();
    }

    @Override
    public void show() {
        System.out.println("NOW SHOWING MENUSCREEN");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isTouched()){
            main.setScreen(main.playScreen);
        }

        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        main.batch.begin();
        font.draw(main.batch, "Click to start the game", Main.V_WIDTH / 2, Main.V_HEIGHT / 2);
        main.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
        font.dispose();
    }
}
