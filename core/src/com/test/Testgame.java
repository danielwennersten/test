package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Testgame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x,y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ship.png");
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
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
