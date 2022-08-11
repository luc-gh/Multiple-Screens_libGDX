<h1>Multiple-Screens_libGDX</h1>
<p>Este repositório contém códigos que demonstram a dinâmica de criação de múltiplas telas de jogo com um método simples e também 
com a abordagem do framework libGDX, que possui uma estrutura mais complexa, porém também mais organizada e bem definida.</p>
<h2></h2>
<div>
  <h3>Códigos presentes nos commits e descrição de suas funções:</h3>
  <table align="center">
    <thead><tr>
      <th width="261">Commit</th>
      <th>Códigos</th>
      <th>Descrição</th>
    </tr></thead>
    <tbody align="center">
      <tr>
        <td rowspan="2">Commit 1 - A abordagem simples</td>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/desktop/src/com/libgdx/screen/DesktopLauncher.java">DesktopLauncher.java</a></td>
        <td align="left">Executável da aplicação em desktops</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/dbb190617cc38433c2262d409e4c9e78a38544a6/core/src/com/libgdx/screen/Jogo.java">Jogo.java</a></td>
        <td align="left">Código principal do jogo, que utiliza um <b>enum</b> para representar o estado atual do jogo, alternando entre telas de forma simples</td>
      </tr>
      <tr>
        <td rowspan="4">Commit 2 - A abordagem libGDX</td>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/Jogo.java">Jogo.java</a></td>
        <td align="left">Versão do código principal utilizando as estruturas da classe <code>Game</code> e dos métodos <code>Screen</code>, para criar variáveis de renderização compartilhadas entre classes que representarão as telas de jogo, separadamente</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/TitleScreen.java">TitleScreen.java</a></td>
        <td align="left">Classe que constrói a tela inicial de jogo</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/GameScreen.java">GameScreen.java</a></td>
        <td align="left">Classe que contém a lógica de jogo e é responsável por renderiza-la</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/EndScreen.java">EndScreen.java</a></td>
        <td align="left">Classe que contrói a tela de fim de jogo</td>
      </tr>
    </tbody>
  </table>
</div>
<div>
  <h3>Lógica do projeto</h3>
  <p>
  Jogos com uma estrutura de múltiplas telas, como praticamente todos, necessitam das as classes Game e Screen em libGDX, 
  que fornecem funções, métodos e objetos para mostrar e alternar entre várias telas conforme a lógica do jogo.<br>
  Mas antes de mostrar tal estrutura, a seguir é descrita uma forma mais simples de estruturar diversas telas de jogo:
  </p>
  <ul>
    <li>
      <p>Em uma <b>abordagem simples</b>, como a descrita no código da classe <code>Jogo.java</code> do primeiro commit, é utilizado um conjunto de variáveis 
      que rastreiam qual tela estamos mostrando e, em seguida, verificar essas variáveis nas funções render() e nas funções de evento e para decidir o que 
      exibir ou qual ação executar. No caso, foi utilizado um <code>enum</code> para determinar e definir o estado atual de jogo conforme os eventos 
      que ocorrem.</p>
      <p>O jogo cria uma condição que determina o estado atual e cria, conforme este, uma tela de título, uma tela de jogo principal onde o usuário clica em 
      um círculo verde saltitante e uma tela de fim de jogo (game over).</p>
      <p>Esse código pode ser modificado para usar funções ou classes separadas para os níveis, ou pode usar valores <code>boolean</code> ou 
      <code>String</code> para representar a tela do jogo. Mas isso pode não ser eficiente e pode tornar-se complexo com um jogo de maior extensão.</p>
    </li>
  </ul>
  <p>
    Para jogos de maior complexidade e/ou extensão, é mais adequado utilizar uma abordagem melhor definida e organizada, e libGDX fornece a classe Game 
    e as interfaces Screen para tal.
  </p>
  <p>
    A logica consiste em criar uma classe principal que extende a classe <code>Game</code> e várias outras classes que implementam/extendam a interface
    Screen. 
  </p>
</div>
