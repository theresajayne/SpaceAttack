package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ShipRenderer  implements GameObject{

    private float posX = 540;
    private float posY =480;
    private float angle = 0;
    private float accel = 0;

    private static final int MAXSPEED = 10;

    private Sprite ship;

    private OrthographicCamera cam;

    public ShipRenderer(OrthographicCamera cam)
    {
        this.cam = cam;
    }

    @Override
    public void create()
    {
        ship = new Sprite(new Texture(Gdx.files.internal("ship.png")));

    }

    @Override
    public void render(float dt)
    {
        System.out.println("angle="+angle);
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            if(accel<MAXSPEED)accel+=1*dt;
            calculateVectorToMove(this.angle);
        }
        else
        {
            if(accel>0) accel-=1*dt;
            calculateVectorToMove(this.angle);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            angle+=5;
            validateAngle();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            angle-=5;
            validateAngle();

        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            System.exit(0);
        }

        ship.setOrigin(ship.getWidth()/2,ship.getHeight()/2);
        System.out.println("Ship "+ship.getX()+","+ship.getY());
        ship.setPosition(posX,posY);
        System.out.println("Ship*"+ship.getX()+","+ship.getY());
        ship.setSize(10,10);
        ship.setRotation(angle);
        cam.position.set(posX,posY,0);
        cam.update();
    }

    private void validateAngle() {
        if(angle <0)
        {
            angle = 359;
        }
        if(angle>359)
        {
            angle = 0;
        }
    }

    private void calculateVectorToMove(float angle) {
        posX += (float)(accel*Math.cos(Math.toRadians(angle+90)));
        posY += (float)(accel*Math.sin(Math.toRadians(angle+90)));
    }

    @Override
    public float getPosX() {
        return posX;
    }

    @Override
    public float getPosY() {
        return posY;
    }

    @Override
    public float getAngle() {
        return angle;
    }

    @Override
    public Sprite getSprite() {
        return ship;
    }

}
