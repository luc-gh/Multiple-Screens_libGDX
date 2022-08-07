package com.libgdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

//Classe que estende ScreenAdapter (maneira de implementar Screen sem definir todas as funções possíveis)
public class TitleScreen extends ScreenAdapter {

    Jogo classeJogo;  //variável para a instância da classe jogo

    public TitleScreen(Jogo classeJogo){  //construtor de TitleScreen, que pede uma instância de Jogo como parâmetro
        this.classeJogo = classeJogo;
        /* Com o método THIS, definimos que a variável local DESTA classe (linha 12) recebe o valor do parâmetro
        *  'Jogo classeJogo' pedido pelo construtor desta classe. O método não seria necessário se a variável local
        *  desta classe não tivesse o mesmo nome da variável de atributo da função construtora.
        */
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.SPACE){
                    classeJogo.setScreen(new GameScreen(classeJogo));  //passamos classeJogo como argumento para o construtor de GameScreen
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        classeJogo.batch.begin();
        classeJogo.font.draw(classeJogo.batch, "Tela inicial!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        classeJogo.font.draw(classeJogo.batch, "Clique no círculo para ganhar.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
        classeJogo.font.draw(classeJogo.batch, "Aperte ESPAÇO para começar.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        classeJogo.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

}
