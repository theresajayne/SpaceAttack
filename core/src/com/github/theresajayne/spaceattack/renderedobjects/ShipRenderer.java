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
        calculateAngle();
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            calculateVectorToMove(this.angle);
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

    private void calculateVectorToMove(float angle) {
        posX += (float)(SPEED*Math.cos(angle));
        posY += (float)(SPEED*Math.sin(angle));
    }

    private void calculateAngle() {
        int mouseX = Gdx.input.getX();
        int mouseY =  -Gdx.input.getY() + Gdx.graphics.getHeight();
        this.angle =  180 - (float)(Math.atan2(posX - mouseX,posY - mouseY) * 180f / Math.PI);
        System.out.println("angle="+angle);
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
