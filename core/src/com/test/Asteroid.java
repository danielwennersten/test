package com.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Asteroid {
    private Texture asteroidImage;
    private Texture asteroidBlownUpImage;
    private Rectangle asteroidHitBox;
    private float asteroidX, asteroidY, asteroidWidth, asteroidHeight;

    public Asteroid(String asteroidImageLocation, String asteroidBlownUpImageLocation,
                    float asteroidX, float asteroidY, float asteroidWidth, float asteroidHeight) {
        this.asteroidImage = new Texture(asteroidImageLocation);
        this.asteroidBlownUpImage = new Texture(asteroidBlownUpImageLocation);
        this.asteroidX = asteroidX;
        this.asteroidY = asteroidY;
        this.asteroidWidth = asteroidWidth;
        this.asteroidHeight = asteroidHeight;
        this.asteroidHitBox = new Rectangle(asteroidX, asteroidY, asteroidWidth, asteroidHeight);
    }

    public void moveasteroid(){
        this.asteroidY = asteroidY - 2;
        asteroidHitBox.setPosition(asteroidX, asteroidY);
    }

    public void checkCollision(Rectangle asteroidHitBox, Rectangle rect1){
        if(asteroidHitBox.overlaps(rect1)){
            asteroidImage = asteroidBlownUpImage;
        }
    }

    public Texture getAsteroidImage() {
        return asteroidImage;
    }

    public void setAsteroidImage(Texture asteroidImage) {
        this.asteroidImage = asteroidImage;
    }

    public Texture getAsteroidBlownUpImage() {
        return asteroidBlownUpImage;
    }

    public void setAsteroidBlownUpImage(Texture asteroidBlownUpImage) {
        this.asteroidBlownUpImage = asteroidBlownUpImage;
    }

    public Rectangle getAsteroidHitBox() {
        return asteroidHitBox;
    }

    public void setAsteroidHitBox(Rectangle asteroidHitBox) {
        this.asteroidHitBox = asteroidHitBox;
    }

    public float getAsteroidX() {
        return asteroidX;
    }

    public float getAsteroidY() {
        return asteroidY;
    }

    public float getasteroidWidth() {
        return asteroidWidth;
    }

    public void setasteroidWidth(float asteroidWidth) {
        this.asteroidWidth = asteroidWidth;
    }

    public float getasteroidHeight() {
        return asteroidHeight;
    }

    public void setasteroidHeight(float asteroidHeight) {
        this.asteroidHeight = asteroidHeight;
    }
}
