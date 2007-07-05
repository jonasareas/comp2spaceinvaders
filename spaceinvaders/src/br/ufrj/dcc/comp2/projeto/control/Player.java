package br.ufrj.dcc.comp2.projeto.control;

/** 
 * Classe respons�vel pelo controle do jogador.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Player {
	
	/** Novo objeto vida, que controla quantas vezes o jogador poder� ser
	 * atingido por um alien.*/
	private int vida;
	
	/** Campo booleano que controla a situa��o de gameover. */
	private boolean gameover;
	
	/** Campo booleano para determinar fim de jogo. */
	private boolean zerou;
	
	/** Campo controlador da fase atual do jogo. */
	private int fasejogador;
	
	/** Campo para registrar o nome do jogador. */
	private String nome;

	/**
	 * M�todo respons�vel por pegar o nome do jogador.
	 * @return nome String com o nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo respons�vel por criar o nome do jogador.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Player() {
		vida = 3;
		gameover = false;
	}
	
	/**
	 * M�todo que atualiza o acr�scimo de vida do jogador.
	*/
	public void ganhaVida() {
		vida++;
	}

	/**
	 * M�todo que atualiza o decr�scimo de vida do jogador.
	*/
	public void perdeVida() {
		vida--;
	}
	
	/**
	 * M�todo respons�vel pelo ganho de vida.
	 * @return vida Uma refer�ncia � uma nova vida. 
	 */
	public int getVida() {
		return vida;
	}
	
/*	public boolean situacaogameover() {
		return thisgameover;
	}*/
	
	/**
	 * M�todo que cria as fases no decorrer do jogo, atualizando os valores
	 * de velocidade do alien e probabilidade de aparecerem na tela.
	 * @param fase Um inteiro com o n�mero da fase atual.
	 */
	public void setFase(int fase) {
		this.fasejogador = fase;
	}
	
	/**
	 * M�todo respons�vel por pegar a fase atual do jogo. 
	 * @return fasejogador Inteiro com a fase atual do jogo.
	 */
	public int getFase() {
		return fasejogador;
	}
	
	/**
	 * M�todo para verificar a situa��o de GameOver
	 * @param b Booleano contendo a situa��o de GameOver
	 */
	public void setGameover(boolean b) {
		this.gameover = b;
	}
	
	/**
	 * M�todo para pegar a situa��o de GameOver
	 */
	public boolean getGameover() {
		return this.gameover;
	}
	
	/**
	 * M�todo para reiniciar o jogo ap�s a situa��o de GameOver
	 * @param b Booleano contendo a situa��o do jogo.
	 */
	public void setZerou(boolean b) {
		this.zerou = b;
	}
	
	/**
	 * M�todo para pegar a situa��o do jogo p�s-GameOver.
	 */
	public boolean getZerou() {
		return this.zerou;
	}
	
	
}
