package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlanetRenderer implements GameObject {

    private float temp;
    private float posX;
    private float posY;
    private int radius;
    private int distance;
    private Sprite planet;
    private int angle =0;

    public PlanetRenderer(Sprite parent,int distance, int radius)
    {
        posX = parent.getX()+(parent.getOriginX()/2);
        posY = parent.getY()+(parent.getOriginY()/2);
        this.radius = radius;
        this.distance = distance;
    }

    @Override
    public void create() {
        planet = new Sprite(new Texture(Gdx.files.internal("planet.png")));
        planet.setPosition(posX-distance,posY);
        planet.setSize(radius,radius);
        planet.setOrigin(planet.getWidth()/2,planet.getHeight()/2);
        planet.setOriginCenter();
    }

    @Override
    public void render(float dt) {
        temp +=dt;
       if(temp>359) temp = 0;
       if(temp<0) temp = 359;
        planet.setRotation(temp);
        //Now calculate the pos based on the parent
        float newX = (float)(distance * Math.sin(temp));
        float newY = (float)(distance * Math.cos(temp));
        planet.setPosition(posX+newX,posY+newY);
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
