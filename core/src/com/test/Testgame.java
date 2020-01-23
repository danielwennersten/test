package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Testgame extends ApplicationAdapter {
	SpriteBatch batch;
	Ship myShip;
	Texture asteroid;
	Rectangle asteroidHitBox;
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		myShip = new Ship("ship.png","asteroid.png",x,y,64f,64f);
		asteroid = new Texture("asteroid.png");
		asteroidHitBox = new Rectangle(200,300,32,32);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myShip.moveShip();
		myShip.checkCollision(myShip.getShipHitBox(),asteroidHitBox);
		batch.begin();
		batch.draw(myShip.getShipImage(),myShip.getX(), myShip.getY());
		batch.draw(asteroid,200,300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		myShip.getShipImage().dispose();
	}
}
