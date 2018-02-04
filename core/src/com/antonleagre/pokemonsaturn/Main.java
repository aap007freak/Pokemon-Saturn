package com.antonleagre.pokemonsaturn;

import com.antonleagre.pokemonsaturn.screens.BattleScreen;
import com.antonleagre.pokemonsaturn.screens.MenuScreen;
import com.antonleagre.pokemonsaturn.screens.PlayScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {
	public static final int V_WIDTH = 640;
	public static final int V_HEIGHT = 640;
	public static final String DESKTOP_TITLE = "Pokemon Saturn";
	public static final int TILE_SIZE = 16;

	public SpriteBatch batch;

	public MenuScreen menuScreen;
	public PlayScreen playScreen;
	public BattleScreen battleScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menuScreen = new MenuScreen(this);
		playScreen = new PlayScreen(this);
		battleScreen = new BattleScreen(this);

		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		menuScreen.dispose();
		playScreen.dispose();
		battleScreen.dispose();
		batch.dispose();
	}
}
