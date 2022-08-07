package com.libgdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {

    Jogo classeJogo;  //instância da classe jogo

    Float circuloX = 300f;
    Float circuloY = 150f;
    Float circuloRaio = 50f;

    Float xVel = 4f;
    Float yVel = 3f;

    public GameScreen(Jogo classeJogo){  //recebe o argumento passado pedido na chamada do construtor
        this.classeJogo = classeJogo;  //atribui-se a instância da classe à variável local (linha 12)
    }

    @Override
    public void show(){  //configura um processador de entrada que identifica eventos de toque
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int x, int y, int pointer, int button){
                int valorY = Gdx.graphics.getHeight() - y;
                if(Vector2.dst(circuloX, circuloY, x, valorY) < circuloRaio){
                    classeJogo.setScreen(new EndScreen(classeJogo));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){  //desenha o círculo pulando pela tela, usando os recursos compartilhados da instância principal da classe Jogo.
        circuloX += xVel;
        circuloY += yVel;

        if(circuloX < 0 || circuloX > Gdx.graphics.getWidth()){
            xVel *= -1;
        }
        if(circuloY < 0 || circuloY > Gdx.graphics.getHeight()){
            yVel *= -1;
        }

        Gdx.gl.glClearColor(0, 0, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        classeJogo.shape.begin(ShapeRenderer.ShapeType.Filled);
        classeJogo.shape.setColor(0, 1, 0, 1);
        classeJogo.shape.circle(circuloX, circuloY, 75);
        classeJogo.shape.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
