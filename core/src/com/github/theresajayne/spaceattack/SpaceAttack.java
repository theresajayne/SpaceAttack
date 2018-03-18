package com.github.theresajayne.spaceattack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.theresajayne.spaceattack.renderedobjects.GameObject;
import com.github.theresajayne.spaceattack.renderedobjects.ShipRenderer;
import com.github.theresajayne.spaceattack.renderedobjects.SunRenderer;

import java.util.ArrayList;
import java.util.List;

public class SpaceAttack extends ApplicationAdapter {
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	ShipRenderer shape;

	@Override
	public void create () {
		gameObjects.add(new ShipRenderer());
		gameObjects.add(new SunRenderer(640,480,100));
		for(GameObject item:gameObjects)
		{
			item.create();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1); //Black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for(GameObject item:gameObjects)
		{
			item.render();
		}
	}
	
	@Override
	public void dispose () {
	}
}
