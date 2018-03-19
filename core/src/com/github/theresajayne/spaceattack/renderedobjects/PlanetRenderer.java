package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlanetRenderer implements GameObject {

    private float temp;
    private int radius;
    private int distance;
    private Sprite planet;
    private GameObject parent;
    private int angle =0;
    private String name;

    public PlanetRenderer(GameObject parent,int distance, int radius,String name)
    {
        this.name = name;
        this.parent = parent;
        this.radius = radius;
        this.distance = distance;
    }

    @Override
    public void create() {
        planet = new Sprite(new Texture(Gdx.files.internal("planet.png")));
        planet.setPosition(parent.getSprite().getX()-distance,parent.getSprite().getY());
        planet.setSize(radius,radius);
        planet.setOrigin(planet.getWidth()/2,planet.getHeight()/2);
        planet.setOriginCenter();
    }

    @Override
    public void render(float dt) {
        temp +=dt;
       if(temp>359) temp = 0;
       if(temp<0) temp = 359;
       //Rotate the planet
        planet.rotate(10.5f/radius);
        //Now calculate the orbit
        float newX = (float)(distance * Math.sin(temp));
        float newY = (float)(distance * Math.cos(temp));
        //now position the planet based on the orbit and the parent's location
        float parentPosX = parent.getSprite().getX()+(parent.getSprite().getOriginX()/2);
        float parentPosY = parent.getSprite().getY()+(parent.getSprite().getOriginY()/2);
        planet.setPosition(parentPosX+newX,parentPosY+newY);
        System.out.println("Planet:"+name+" Parent"+parent.getSprite().getX()+"|"+parent.getSprite().getY());
        System.out.println("Planet"+name+" Planet"+planet.getX()+"|"+planet.getY());
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
