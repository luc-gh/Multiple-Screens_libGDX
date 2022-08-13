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
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/desktop/src/com/libgdx/screen/DesktopLauncher.java">DesktopLauncher.java</a></td>
        <td align="left">Executável da aplicação em desktops</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/dbb190617cc38433c2262d409e4c9e78a38544a6/core/src/com/libgdx/screen/Jogo.java">Jogo.java</a></td>
        <td align="left">Código principal do jogo, que utiliza um <b>enum</b> para representar o estado atual do jogo, alternando entre telas de forma simples</td>
      </tr>
      <tr>
        <td rowspan="4">Commit 2 - A abordagem libGDX</td>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/Jogo.java">Jogo.java</a></td>
        <td align="left">Versão do código principal utilizando as estruturas da classe <code>Game</code> e dos métodos <code>Screen</code>, para criar variáveis de renderização compartilhadas entre classes que representarão as telas de jogo, separadamente</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/TitleScreen.java">TitleScreen.java</a></td>
        <td align="left">Classe que constrói a tela inicial de jogo</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/GameScreen.java">GameScreen.java</a></td>
        <td align="left">Classe que contém a lógica de jogo e é responsável por renderiza-la</td>
      </tr>
      <tr>
        <td><a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/EndScreen.java">EndScreen.java</a></td>
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
      Em uma <b>abordagem simples</b>, como a descrita no código da classe <code>Jogo.java</code> do primeiro commit, é utilizado um conjunto de variáveis 
      que rastreiam qual tela estamos mostrando e, em seguida, verificar essas variáveis nas funções render() e nas funções de evento e para decidir o que 
      exibir ou qual ação executar. No caso, foi utilizado um <code>enum</code> para determinar e definir o estado atual de jogo conforme os eventos 
      que ocorrem.
    </li>
    <li>
      O jogo cria uma condição que determina o estado atual e cria, conforme este, uma tela de título, uma tela de jogo principal onde o usuário clica em 
      um círculo verde saltitante e uma tela de fim de jogo (game over).
    </li>
    <li>
      Esse código pode ser modificado para usar funções ou classes separadas para os níveis, ou pode usar valores <code>boolean</code> ou 
      <code>String</code> para representar a tela do jogo. Mas isso pode não ser eficiente e pode tornar-se complexo com um jogo de maior extensão.
    </li>
  </ul>
  <p>
    Para jogos de maior complexidade e/ou extensão, é mais adequado utilizar uma abordagem melhor definida e organizada, e libGDX fornece a classe Game 
    e as interfaces Screen para tal.
  </p>
</div>
<div>
  <blockquote>
    A lógica consiste em criar uma classe principal que extende a classe <code>Game</code> e várias outras classes que implementam/extendam a interface
    Screen. 
  </blockquote>
</div>
<div>
  <p>
    Nessa abordagem, mais característica do framework, a classe principal 
    <a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/Jogo.java"><code>Jogo.java</code></a> 
    extende a classe Game para fornecer funções úteis para alternar entre telas e desse modo compartilhar recuros, porém, no código não haverá nenhuma 
    lógica ou código de renderização específico de tela, pois estes serão gerados em outras classes que constroem a <b>interface</b> do jogo.
  </p>
  <p>
    A função usada de maior importância é: 
    <code>setScreen(new TitleScreen(this));</p></code>
    Ela constrói uma instância de uma nova classe, no caso, a classe <code>TitleScreen</code>, passando o objeto que representa a classe principal como
    argumento para o construtor daquela classe, e assim compartilhando algumas das variáveis de renderização e criando um objeto 
    <code><i>TitleScreen</i></code>, responsável por gerar <b>uma das telas</b> <i>deste jogo</i>.
  </p>
  <p>
    A classe de interface <code><b>Screen</code></b> contém suas próprias funções cíclicas que são chamadas pela libGDX e permitem isolar a 
    lógica específica da tela em uma classe separada.<br>
    Com base nisso, a classe 
    <a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/core/src/com/libgdx/screen/TitleScreen.java"><code>TitleScreen.java</code></a> 
    estende ScreenAdapter (que é uma maneira de implementar Screen sem definir todas as funções possíveis) e armazena a instância de <code>Jogo.java</code>
    passada em seu construtor.
  </p>
  <p>
    A função <code>show()</code> é chamada automaticamente quando esta tela (Screen) se torna a tela atual do jogo e configura um processador de entrada. 
    Observe que só há preocupação com a entrada específica para esta tela. 
  </p>
  <p>
    A função <code>render()</code> é chamada repetidamente (geralmente 60 fps, de acordo com os valores definidos no arquivo
    <a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/master/desktop/src/com/libgdx/screen/DesktopLauncher.java">
    <kbd>DesktopLauncher.java</kbd></a> ),
    desde que essa tela seja a tela atual. Nesta função, desenhamos a tela de título. 
    Não há muito o que ver aqui, mas observe
    que estamos usando o método font criado na classe <code>Jogo.java</code> por meio da instância <code>classeJogo</code>. Isso permite criar
    objetos apenas uma vez, em vez de recriar várias variáveis iguais em todas as classes de tela. 
    Esta é a razão pela qual passamos a instância de <code>Jogo.java</code> para o construtor.
  </p>
  <p>
    Por fim, a função <code>hide()</code> é chamada sempre que esta tela (Screen) deixa de ser a tela atual do jogo. Esta função remove o 
    processador de entrada que foi
    configurado na função <code>show()</code>, para que não sejam recebidos mais eventos depois que essa tela for ocultada.<br>
    Isso remete novemente ao processador de entrada criado na função show(). Esse processador de entrada verifica se o usuário digitou a tecla de espaço 
    e, em caso afirmativo, configura a tela atual para uma instância da classe GameScreen. <br>
    <blockquote><i>Esta é a outra razão pela qual é passada a instância <code>Jogo.java</code> para o construtor.</i></blockquote>
    A estrutura classeJogo oculta automaticamente essa tela (chamando a função <code>hide()</code> no processo) e "chama" o arquivo GameScreen, levando a 
    classe principal (nesse caso, representada na variável <code>classeJogo</code>) como argumento do construtor da nova classe.
  </p>
</div>
<div>
  <p>
    A classe 
    <a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/GameScreen.java"><code>GameScreen.java</code></a>
    possui toda a lógica de jogo, pois constrói a tela de jogo principal. Nela, a função <code>show()</code> é responsável por interpretar eventos de toque (entrada 
    de dados), enquanto a função <code>render()</code> fica com a tarefa de desenhar o círculo na tela. 
  </p>
  <blockquote>
    Note que a quando o evento solicitado na função <code>show()</code> ocorrer, 
    a função render() será interrompida, para que o evento tenha o efeito esperado de acordo com a lógica estabelecida.
  </blockquote>
</div>
<div>
  <p>
    Com o evento, a lógica se repete para compartilhar a instância da classe principal como argumento da próxima tela, e esta é a de fim de jogo: 
    <a href="https://github.com/luc-gh/Multiple-Screens_libGDX/blob/main/core/src/com/libgdx/screen/EndScreen.java"><code>EndScreen.java</code></a>.
  </p>
  <p>
    Essa classe é muito semelhante a classe TitleScreen, pois ela é responsável apenas com a entrada e renderização específica para esta tela, 
    e chamamos a função setScreen() na instância principal <code>classeJogo</code> para voltar à tela de título quando o usuário pressionar Enter.
  </p>
</div>
