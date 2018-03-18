package com.github.theresajayne.spaceattack.renderedobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface GameObject {

    void create();

    void render();

    float getPosX();

    float getPosY();

    float getAngle();

    Sprite getSprite();
}
