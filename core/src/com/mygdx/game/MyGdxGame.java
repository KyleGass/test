package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

//float w = Gdx.graphics.getWidth();
//float h = Gdx.graphics.getHeight();
//
//camera = new OrthographicCamera();
//camera.setToOrtho(false, w, h);
//camera.update();
//tiledMap = new TmxMapLoader().load("exampletmx.tmx");
//tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
//Gdx.input.setInputProcessor(this);

public class MyGdxGame implements ApplicationListener {
	 private final static int TILESIZE = 32;
	private final float unitScale = 1F;

	private OrthographicCamera cam;
	private SpriteBatch batch;
	private float rotationSpeed;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private Viewport viewport;

	@Override
	public void create() {
		rotationSpeed = 0.5f;
		System.out.println("hey");
		map = new TmxMapLoader().load("exampletmx.tmx");

		renderer = new OrthogonalTiledMapRenderer(map, unitScale);

		float displayWidth = Gdx.graphics.getWidth();
		float displayHeight = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		viewport = new FitViewport(displayWidth, displayHeight, cam);


		MapProperties prop = map.getProperties();

//		int mapWidth = prop.get("width", Integer.class);
//		int tilePixelWidth = prop.get("tilewidth", Integer.class);
//		int mapPixelWidth = mapWidth * tilePixelWidth;

		int mapHeight = prop.get("height", Integer.class);
		int tilePixelHeight = prop.get("tileheight", Integer.class);
		int mapPixelHeight = mapHeight * tilePixelHeight;

		cam.position.x = displayWidth/2;
		cam.position.y = mapPixelHeight - displayHeight/2;

		batch = new SpriteBatch();
		cam.update();
	}

	@Override
	public void render() {
		handleInput();

		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		batch.end();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		cam.update();
		renderer.setView(cam);
		renderer.render();

	}

	private void handleInput() {
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
			cam.rotate(-rotationSpeed, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.rotate(rotationSpeed, 0, 0, 1);
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

	@Override
	public void resize(int width, int height) {
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