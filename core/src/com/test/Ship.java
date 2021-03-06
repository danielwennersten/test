package com.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Ship {
    private Texture shipImage;
    private Texture shipBlownUpImage;
    private Rectangle shipHitBox;
    private float x, y, shipWidth, shipHeight;

    public Ship(String shipImageLocation, String blownUpImageLocation,
                float x, float y, float shipWidth, float shipHeight) {
        this.shipImage = new Texture(shipImageLocation);
        this.shipBlownUpImage = new Texture(blownUpImageLocation);
        this.x = x;
        this.y = y;
        this.shipWidth = shipWidth;
        this.shipHeight = shipHeight;
        this.shipHitBox = new Rectangle(x, y, shipWidth, shipHeight);
    }

    public void moveShip(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x < 576) {
            this.x = x + 5;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
            this.x = x - 5;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) && y < 416)  {
            this.y = y + 5;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y > 0) {
            this.y = y - 5;
        }
        shipHitBox.setPosition(x,y);
    }

    public void checkCollision(Rectangle shipHitBox, Rectangle rect1){
        if(shipHitBox.overlaps(rect1)){
            shipImage = shipBlownUpImage;
        }
    }

    public Texture getShipImage() {
        return shipImage;
    }

    public void setShipImage(Texture shipImage) {
        this.shipImage = shipImage;
    }

    public Texture getShipBlownUpImage() {
        return shipBlownUpImage;
    }

    public void setShipBlownUpImage(Texture shipBlownUpImage) {
        this.shipBlownUpImage = shipBlownUpImage;
    }

    public Rectangle getShipHitBox() {
        return shipHitBox;
    }

    public void setShipHitBox(Rectangle shipHitBox) {
        this.shipHitBox = shipHitBox;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getShipWidth() {
        return shipWidth;
    }

    public void setShipWidth(float shipWidth) {
        this.shipWidth = shipWidth;
    }

    public float getShipHeight() {
        return shipHeight;
    }

    public void setShipHeight(float shipHeight) {
        this.shipHeight = shipHeight;
    }
}
