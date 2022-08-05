package com.libgdx.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Jogo extends ApplicationAdapter {

	enum Tela{
		TITULO, JOGO, FIM   //Três telas de jogo
	}

	Tela telaAtual = Tela.TITULO;  //tela inicial de jogo

	SpriteBatch batch;  //área de escrita
	ShapeRenderer shape;  //desenho de formas
	BitmapFont font;  //fonte de texto

	Float circuloX = 300f;
	Float circuloY = 150f;
	Float circuloRaio = 50f;

	Float xVel = 4f;
	Float yVel = 3f;

	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		font = new BitmapFont();

		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean keyDown(int keyCode){  //condição para mudanças de tela (inicial - final)
				if(telaAtual == Tela.TITULO && keyCode == Input.Keys.SPACE){
					telaAtual = Tela.JOGO;
				}
				else if(telaAtual == Tela.FIM && keyCode == Input.Keys.ENTER){
					telaAtual = Tela.TITULO;
				}
				return true;
			}
			@Override
			public boolean touchDown(int x, int y, int pointer, int button){
				if(telaAtual == Tela.JOGO){  //condição para mudança de tela (jogo)
					int renderY = Gdx.graphics.getHeight() - y;
					if(Vector2.dst(circuloX, circuloY, x, renderY) < circuloRaio){
						telaAtual = Tela.FIM;  //jogador acerta círculo >> fim de jogo (tela final)
					}
				}
				return true;
			}
		});
	}

	@Override
	public void render () {
		if(telaAtual == Tela.TITULO){  //tela inicial
			Gdx.gl.glClearColor(0.25f,0.1f, 0.8f,1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "Tela inicial!", Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.75f);
			font.draw(batch, "Clique no circulo para vencer", Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.5f);
			font.draw(batch, "Aperte ESPAÇO para jogar!", Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.25f);
			batch.end();
		}
		else if(telaAtual == Tela.JOGO){  //tela de jogo
			circuloX += xVel;
			circuloY += yVel;

			if(circuloX < 0 || circuloX > Gdx.graphics.getWidth()){
				xVel *= -1;
			}
			if(circuloY < 0 || circuloY > Gdx.graphics.getHeight()){
				yVel *= -1;
			}

			Gdx.gl.glClearColor(0,0,0.25f,1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			shape.begin(ShapeRenderer.ShapeType.Filled);
			shape.setColor(0,1,0,1);
			shape.circle(circuloX, circuloY, 75);
			shape.end();
		}
		else if(telaAtual == Tela.FIM){  //tela final
			Gdx.gl.glClearColor(.25f, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "Vc ganhou!", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
			font.draw(batch, "Aperte ENTER para voltar à tela inicial.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .25f);
			batch.end();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shape.dispose();
	}
}
