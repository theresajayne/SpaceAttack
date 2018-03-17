package com.github.theresajayne.spaceattack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.theresajayne.spaceattack.renderedobjects.ShipRenderer;

public class SpaceAttack extends ApplicationAdapter {
	ShipRenderer shape;

	@Override
	public void create () {
		shape = new ShipRenderer();
		shape.create();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1); //Black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.render();
	}
	
	@Override
	public void dispose () {
	}
}
