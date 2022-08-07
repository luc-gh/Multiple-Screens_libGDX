package com.libgdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class EndScreen extends ScreenAdapter {
    //é sempre necessário extender ScreenAdapter para que os métodos desta classe sejam compartilhados entre as classes 'Screen'
    Jogo classeJogo;

    public EndScreen(Jogo classeJogo){  //construtor de EndScreen
        this.classeJogo = classeJogo;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.ENTER){
                    classeJogo.setScreen(new TitleScreen(classeJogo));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(.25f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        classeJogo.batch.begin();
        classeJogo.font.draw(classeJogo.batch, "Vc venceu!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        classeJogo.font.draw(classeJogo.batch, "Aperte ENTER para voltar a tela inicial.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        classeJogo.batch.end();
    }
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
