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
	Texture img;
	Texture asteroid;
	Rectangle ShipHitBox;
	Rectangle AsteroidHitBox;
	Intersector HitBoxIntersection;
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ship.png");
		asteroid = new Texture("asteroid.png");
		ShipHitBox = new Rectangle(x,y,64,64);
		AsteroidHitBox = new Rectangle(300,220, 32, 32);
		System.out.println(x);
		HitBoxIntersection = new Intersector();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x = x + 5;
			System.out.println(x);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			x = x - 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP))  {
			y = y + 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			y = y - 5;
		}
		boolean isIntersecting = Intersector.overlaps(ShipHitBox,AsteroidHitBox);
        if (isIntersecting){
            System.out.println("We've been hit, Captain!!!");
        }
		batch.begin();
		batch.draw(img, x, y);
		batch.draw(asteroid, 300, 220);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
