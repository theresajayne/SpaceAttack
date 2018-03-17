package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class ShipRenderer  {

    private float posX = 200;
    private float posY =200;
    private float posZ =0;
    private float angle = 0;

    private static final int SPEED = 10;

    private ShapeRenderer ship;

    public void create()
    {
        ship = new ShapeRenderer();

    }

    public void render()
    {
       //calculateAngle();
        System.out.println("angle="+angle);
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            calculateVectorToMove(this.angle);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            angle++;
            validateAngle();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            angle--;
            validateAngle();

        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            System.exit(0);
        }
        ship.begin(ShapeRenderer.ShapeType.Filled);
        ship.identity();
        ship.translate(posX, posY, posZ);
        ship.rotate(0,0,1,getAngle());
        ship.triangle(-25,-25,25,-25,0,25, Color.BLUE,Color.RED,Color.GREEN);
        ship.end();
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
        posX += (float)(SPEED*Math.cos(Math.toRadians(angle+90)));
        posY += (float)(SPEED*Math.sin(Math.toRadians(angle+90)));
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPosZ() {
        return posZ;
    }

    public void setPosZ(float posZ) {
        this.posZ = posZ;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
