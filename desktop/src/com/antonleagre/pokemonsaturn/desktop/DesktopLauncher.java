package com.antonleagre.pokemonsaturn.desktop;

import com.antonleagre.pokemonsaturn.Main;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Main.DESKTOP_TITLE;
		config.width = Main.V_WIDTH * Main.DESKTOP_SCALE;
		config.height = Main.V_HEIGHT * Main.DESKTOP_SCALE;
		new LwjglApplication(new Main(), config);
	}
}
