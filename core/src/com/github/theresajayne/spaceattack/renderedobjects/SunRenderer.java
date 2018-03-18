package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SunRenderer implements GameObject
{
    private int posX;
    private int posY;
    private int radius;
    private Sprite sun;


    public SunRenderer(int posX, int posY, int radius)
    {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void create() {
        sun = new Sprite(new Texture(Gdx.files.internal("sun.png")));
        sun.setPosition(posX,posY);
        sun.setSize(radius,radius);
    }

    @Override
    public void render() {
        //Nothing to do here
    }

    @Override
    public float getPosX() {
        return this.posX;
    }

    @Override
    public float getPosY() {
        return posY;
    }

    @Override
    public float getAngle() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        return sun;
    }
}
