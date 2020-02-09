package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Testgame extends ApplicationAdapter {
	SpriteBatch batch;
	Ship myShip;
	Asteroid firstAsteroid;
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		myShip = new Ship("ship.png", "asteroid.png",x, y, 64f, 64f);
		firstAsteroid = new Asteroid("asteroid.png", "asteroid.png", x, 480f, 32f, 32f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myShip.moveShip();
		myShip.checkCollision(myShip.getShipHitBox(),firstAsteroid.getAsteroidHitBox());
		firstAsteroid.moveasteroid();
		batch.begin();
		batch.draw(myShip.getShipImage(), myShip.getX(), myShip.getY());
		batch.draw(firstAsteroid.getAsteroidImage(), firstAsteroid.getAsteroidX(), firstAsteroid.getAsteroidY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		myShip.getShipImage().dispose();
		firstAsteroid.getAsteroidImage().dispose();
	}
}
