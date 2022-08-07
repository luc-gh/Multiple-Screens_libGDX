<h1>Multiple-Screens_libGDX</h1>
<p>Este repositório contém códigos que demonstram a dinâmica de criação de múltiplas telas de jogo com um método simples e também 
com a abordagem do framework libGDX, que possui uma estrutura mais complexa, porém também mais organizada e bem definida.</p>

<div>
  <h4>Códigos presentes nos commits e descrição de suas funções:</h4>
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
