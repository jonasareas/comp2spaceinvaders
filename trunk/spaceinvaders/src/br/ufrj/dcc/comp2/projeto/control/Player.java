package br.ufrj.dcc.comp2.projeto.control;

/** 
 * Classe responsável pelo controle do jogador.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Player {
	
	/** Novo objeto vida, que controla quantas vezes o jogador poderá ser
	 * atingido por um alien.*/
	private int vida;
	
	/** Campo booleano que controla a situação de gameover. */
	private boolean gameover;
	
	/** Campo booleano para determinar fim de jogo. */
	private boolean zerou;
	
	/** Campo controlador da fase atual do jogo. */
	private int fasejogador;
	
	/** Campo para registrar o nome do jogador. */
	private String nome;

	/**
	 * Método responsável por pegar o nome do jogador.
	 * @return nome String com o nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método responsável por criar o nome do jogador.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Player() {
		vida = 3;
		gameover = false;
	}
	
	/**
	 * Método que atualiza o acréscimo de vida do jogador.
	*/
	public void ganhaVida() {
		vida++;
	}

	/**
	 * Método que atualiza o decréscimo de vida do jogador.
	*/
	public void perdeVida() {
		vida--;
	}
	
	/**
	 * Método responsável pelo ganho de vida.
	 * @return vida Uma referência à uma nova vida. 
	 */
	public int getVida() {
		return vida;
	}
	
/*	public boolean situacaogameover() {
		return thisgameover;
	}*/
	
	/**
	 * Método que cria as fases no decorrer do jogo, atualizando os valores
	 * de velocidade do alien e probabilidade de aparecerem na tela.
	 * @param fase Um inteiro com o número da fase atual.
	 */
	public void setFase(int fase) {
		this.fasejogador = fase;
	}
	
	/**
	 * Método responsável por pegar a fase atual do jogo. 
	 * @return fasejogador Inteiro com a fase atual do jogo.
	 */
	public int getFase() {
		return fasejogador;
	}
	
	/**
	 * Método para verificar a situação de GameOver
	 * @param b Booleano contendo a situação de GameOver
	 */
	public void setGameover(boolean b) {
		this.gameover = b;
	}
	
	/**
	 * Método para pegar a situação de GameOver
	 */
	public boolean getGameover() {
		return this.gameover;
	}
	
	/**
	 * Método para reiniciar o jogo após a situação de GameOver
	 * @param b Booleano contendo a situação do jogo.
	 */
	public void setZerou(boolean b) {
		this.zerou = b;
	}
	
	/**
	 * Método para pegar a situação do jogo pós-GameOver.
	 */
	public boolean getZerou() {
		return this.zerou;
	}
	
	
}
