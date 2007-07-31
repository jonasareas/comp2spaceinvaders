package br.ufrj.dcc.comp2.projeto.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;

//import spaceinvaders.src.br.ufrj.dcc.comp2.projeto.control.Score;

/** 
 * Classe controladora da pontuação do jogador.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Score implements Serializable {

	/** O serial da Classe. */
	private static final long serialVersionUID = 1L;

	/** Campo de referência a um novo collection TreeMap. */
	private TreeMap<Integer, String> score;

	/** Campo para definir onde o arquivo de recordes será gravado. */
	private static String file = "./dados/score.dat";

	/** Campo para armazenar a pontuação do jogador na partida */
	private int pontuacao;

	/** Campo para armazenar a pontuação acumulada(para ganhar uma nova vida)*/
	private int pontuacaoAcumulada;

	public Score() {
		score = new TreeMap<Integer, String>();
		pontuacao = 0;
		pontuacaoAcumulada = 0;
	}

	/**
	 * Método responsável pela pontuação do jogo.
    */
	public void aumentaPonto() {
		pontuacao += 15;
		pontuacaoAcumulada += 15;
	}

	/**
	 * Método responsável pela decréscimo da pontuação do jogo. 
	*/
	public void diminuiPonto() {
		if (pontuacao > 0) {
			if (pontuacao < 10) {
				pontuacao = 0;
			} else {
				pontuacao -= 10;	
			}
		}
	}

	/**
	 * Método responsável por pegar a pontuação do jogo.
	 * @return pontuação Quantidade de pontos
	 */
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * Método responsável por pegar a pontuação acumulada do jogo.
	 * @return pontuação Quantidade de pontos acumulada
	 */
	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	/**
	 * Método que zera a pontuação acumulada do jogo.
	 */  
	public void zeraPontuacaoAcumulada() {
		pontuacaoAcumulada = 0;
	}

	/**
	 * Método para abertura do arquivo de recordes.
	 * @return A referência para o arquivo aberto.
	 * @throws IOException
	 */
	public static Score abreRecorde() {
		/** Campo de refêrencia para gravação do score. */
		Score rec;
		try {
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fileStream);
			Object recuperado = input.readObject();
			rec = (Score) recuperado;
			input.close();
		} catch (Exception e) {
			System.out.println("Arquivo de recordes nao encontrado. Novo arquivo criado.");
			rec = new Score();
		}
		return rec;
	}

	/**
	 * Método para salvar do arquivo de recordes.
	 * @throws IOException
	 */
	public void salvarRecorde() {
		try {
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream output = new ObjectOutputStream(fileStream);
			output.writeObject(this);
			output.close();
		} catch (Exception e) {
			System.out.println("Falha ao salvar o arquivo de score.");
			System.exit(1);
		}
	}

	/**
	 * Método booleano para saber se é possível adicionar um novo recorde.
	 * @param pontos Pontuação do jogador.
	 * @param player String com o nome do jogador.
	 * @return true se o jogador puder ser adicionado ao arquivo de recordes.
	 */
	public boolean AdicionarRecorde(Integer pontos, String player) {
		if (score.size() < 10) {
			score.put(pontos, player);
			return true;
		} else if (score.firstKey() < pontos) {
			score.remove(score.firstKey());
			score.put(pontos, player);
			return true;
		}
		return false;
	}

	/**
	 * Método para obter os pontos dos jogadores no ranking.
	 * @return Pontuação do jogador.
	 */
	public TreeMap<Integer, String> getPontos() {
		return this.score;
	}
}
