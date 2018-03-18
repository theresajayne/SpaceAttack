package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlanetRenderer implements GameObject {

    private float posX;
    private float posY;
    private int radius;
    private int distance;
    private Sprite planet;
    private int angle =0;

    public PlanetRenderer(GameObject parent,int distance, int radius)
    {
        posX = parent.getPosX();
        posY = parent.getPosY();
        this.radius = radius;
        this.distance = distance;
    }

    @Override
    public void create() {
        planet = new Sprite(new Texture(Gdx.files.internal("planet.png")));
        planet.setPosition(posX-distance,posY);
        planet.setSize(radius,radius);
        planet.setOrigin(planet.getWidth()/2,planet.getHeight()/2);

    }

    @Override
    public void render() {
        angle += 1;
       if(angle>359) angle = 0;
       if(angle<0) angle = 359;

        planet.setRotation(angle);
    }

    @Override
    public float getPosX() {
        return planet.getX();
    }

    @Override
    public float getPosY() {
        return planet.getY();
    }

    @Override
    public float getAngle() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        return planet;
    }
}
