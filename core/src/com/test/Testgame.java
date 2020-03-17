package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Testgame extends ApplicationAdapter {
	SpriteBatch batch;
	Ship myShip;
	Asteroid[] AsteroidArray = new Asteroid[20];
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		myShip = new Ship("ship.png", "asteroid.png",x, y, 64f, 64f);
		float asteroid_x;
		for(int i=0;i<20;i++){
			asteroid_x = 32*i;
			AsteroidArray[i] = new Asteroid("asteroid.png", "asteroid.png", asteroid_x, 480f, 32f, 32f);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myShip.moveShip();
		batch.begin();
		for(int i=0;i<20;i++){
			myShip.checkCollision(myShip.getShipHitBox(),AsteroidArray[i].getAsteroidHitBox());
			batch.draw(AsteroidArray[i].getAsteroidImage(), AsteroidArray[i].getAsteroidX(), AsteroidArray[i].getAsteroidY());
			AsteroidArray[i].moveasteroid();
		}
		batch.draw(myShip.getShipImage(), myShip.getX(), myShip.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		myShip.getShipImage().dispose();
		for(int i=0; i<20; i++){
			AsteroidArray[i].getAsteroidImage().dispose();
		}
	}
}
