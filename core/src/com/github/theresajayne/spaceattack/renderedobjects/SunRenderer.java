package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SunRenderer implements GameObject
{
    private int posX;
    private int posY;
    private int radius;
    private ShapeRenderer sun;


    public SunRenderer(int posX, int posY, int radius)
    {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void create() {
        sun = new ShapeRenderer();
    }

    @Override
    public void render() {
        sun.begin(ShapeRenderer.ShapeType.Filled);
        sun.circle(posX,posY,radius);
        sun.setColor(Color.YELLOW);
        sun.end();

    }
}
