package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.interfaces.Constants;

public class InputHandler extends InputAdapter {
	
//	@Override
//	public boolean keyTyped(char character) {
//		
//		
//		return super.keyTyped(character);
//		
//	}
	
	public void handleInput(OrthographicCamera cam) {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.zoom -= 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.translate(0, 3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			cam.rotate(-Constants.ROTATIONSPEED, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.rotate(Constants.ROTATIONSPEED, 0, 0, 1);
		}

//		cam.zoom = MathUtils.clamp(cam.zoom, unitScale, 100 / cam.viewportWidth);

		// float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
		// float effectiveViewportHeight = cam.viewportHeight * cam.zoom;
		//
		// cam.position.x = MathUtils.clamp(cam.position.x,
		// effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
		// cam.position.y = MathUtils.clamp(cam.position.y,
		// effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
	}

}
