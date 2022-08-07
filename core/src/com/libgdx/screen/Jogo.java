package com.libgdx.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Jogo extends Game {
	SpriteBatch batch;  //área de escrita
	ShapeRenderer shape;  //desenho de formas
	BitmapFont font;  //fonte de texto

	@Override
	public void create () {
		batch = new SpriteBatch();
		font =  new BitmapFont();
		shape = new ShapeRenderer();
		/* A função a seguir cria uma instância da classe TitleScreen, passando o objeto corrente da classe Jogo
		como ARGUMENTO para o construtor de TitleScreen, e assim passa as informações desta classe para naquela. */
		setScreen(new TitleScreen(this));  //setScreen() permite alternar entre telas
	}

	//Nem sequer é necessária a função render() aqui, pois ela usada em outras classes chamadas

	@Override
	public void dispose () {
		batch.dispose();
		shape.dispose();
		font.dispose();
	}
}
