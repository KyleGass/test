package com.mygdx.game.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.controller.MyGdxGame;
import com.mygdx.game.interfaces.Constants;

public class DesktopLauncher {


	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title =Constants.TITLE;
//		config.width=Constants.VIRTUAL_WIDTH;
//		config.height=Constants.VIRTUAL_HEIGHT;

		
		DisplayMode d = config.getDesktopDisplayMode();
		config.width = d.width;
		config.height = d.height;
		System.out.println(d.height);
		System.out.println(d.width);
		

//		try {
//			Display.setFullscreen(true);
//		} catch (LWJGLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		new LwjglApplication(new MyGdxGame(), config);
	}
}
