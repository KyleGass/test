package com.mygdx.game.controller;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.interfaces.Constants;

//float w = Gdx.graphics.getWidth();
//float h = Gdx.graphics.getHeight();
//
//camera = new OrthographicCamera();
//camera.setToOrtho(false, w, h);
//camera.update();
//tiledMap = new TmxMapLoader().load("exampletmx.tmx");
//tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
//Gdx.input.setInputProcessor(this);

//TEST

public class MyGdxGame implements ApplicationListener {

	private OrthographicCamera cam;
	private SpriteBatch batch;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private InputHandler inputHandler;
	private Viewport viewport;

	@Override
	public void create() {

		map = new TmxMapLoader().load("Menue.tmx");
		inputHandler = new InputHandler();

		renderer = new OrthogonalTiledMapRenderer(map, Constants.UNITSCALE);

		float displayWidth = Gdx.graphics.getWidth();
		float displayHeight = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		viewport = new FitViewport(displayWidth, displayHeight, cam);

		MapProperties prop = map.getProperties();


		int mapHeight = prop.get("height", Integer.class);
		int tilePixelHeight = prop.get("tileheight", Integer.class);
		int mapPixelHeight = mapHeight * tilePixelHeight;

		cam.position.x = displayWidth / 2;
		cam.position.y = mapPixelHeight - displayHeight / 2;

		batch = new SpriteBatch();
//		cam = new OrthographicCamera(Constants.VIRTUAL_WIDTH, Constants.VIRTUAL_HEIGHT);
		cam.update();
	}

	@Override
	public void render() {
		
//		cam.update();

		inputHandler.handleInput(cam);

		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		batch.end();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();
		renderer.setView(cam);
		renderer.render();

	}

	@Override
	public void resize(int width, int height) {
		
//		float aspectRatio = (float) width/(float)height;
//		float scale = 1f;
//		Vector2 crop = new Vector2(0f, 0f);
//		
//		if (aspectRatio > Constants.ASPECT_RATIO) {
//			scale = (float)height/(float)Constants.VIRTUAL_HEIGHT;
//			crop.x = (width - Constants.VIRTUAL_WIDTH*scale)/2f;
//		}else if (aspectRatio < Constants.ASPECT_RATIO) {
//			scale = (float)width/(float)Constants.VIRTUAL_WIDTH;
//			crop.y = (height - Constants.VIRTUAL_HEIGHT*scale)/2f;
//		}else {
//			scale = (float)width/(float)Constants.VIRTUAL_WIDTH;
//		}
//		
//		float w = (float)Constants.VIRTUAL_WIDTH*scale;
//		float h = (float)Constants.VIRTUAL_HEIGHT*scale;
//		viewport = new Rectangle(crop.x,crop.y,w,h);
		viewport.update(width, height);
		cam.update();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		map.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
	}

}