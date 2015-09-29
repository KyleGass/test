package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.controller.MyGdxGame;
import com.mygdx.game.interfaces.Constants;

public class DesktopLauncher {


	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title =Constants.TITLE;
		config.width=Constants.WINDOW_WIDTH;
		config.height=Constants.WINDOW_HEIGHT;
//		System.out.println(config.backgroundFPS);
		new LwjglApplication(new MyGdxGame(), config);
	}
}
