package com.github.theresajayne.spaceattack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.theresajayne.spaceattack.renderedobjects.GameObject;
import com.github.theresajayne.spaceattack.renderedobjects.ShipRenderer;
import com.github.theresajayne.spaceattack.renderedobjects.SunRenderer;

import java.util.ArrayList;
import java.util.List;

public class SpaceAttack extends ApplicationAdapter {
	private static final int WORLD_WIDTH = 1000;
	private static final int WORLD_HEIGHT = 1000;
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Sprite mapSprite;
	private float rotationSpeed = 0.5f;

	@Override
	public void create () {
		mapSprite = new Sprite(new Texture(Gdx.files.internal("starfield.jpg")));
		mapSprite.setPosition(0,0);
		mapSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		cam = new OrthographicCamera(500,500 *(h/w));
		cam.position.set(cam.viewportWidth /2f,cam.viewportHeight/2f,0);
		cam.update();

		batch = new SpriteBatch();

		gameObjects.add(new ShipRenderer(cam));
		gameObjects.add(new SunRenderer(640,480,10));
		for(GameObject item:gameObjects)
		{
			item.create();
		}
	}

	@Override
	public void render () {

		cam.update();
		Gdx.gl.glClearColor(0, 0, 0, 1); //Black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		mapSprite.draw(batch);
		for(GameObject item:gameObjects)
		{
			item.render();
			item.getSprite().draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
	}
}
