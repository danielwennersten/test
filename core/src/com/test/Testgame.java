package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Testgame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture asteroid;
	Rectangle ShipHitBox;
	Rectangle AsteroidHitBox;
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ship.png");
		ShipHitBox = new Rectangle(x,y,64,64);
		asteroid = new Texture("asteroid.png");
		AsteroidHitBox = new Rectangle(200,300,32,32);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x < 576) {
			x = x + 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
			x = x - 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP) && y < 416)  {
			y = y + 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y > 0) {
			y = y - 5;
		}

		ShipHitBox.setPosition(x,y);
		System.out.println(ShipHitBox.overlaps(AsteroidHitBox));

		batch.begin();
		batch.draw(img, x, y);
		batch.draw(asteroid, 200, 300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
