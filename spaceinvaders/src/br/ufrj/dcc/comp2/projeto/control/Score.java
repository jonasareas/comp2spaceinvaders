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
 * Classe controladora da pontua��o do jogador.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Score implements Serializable {

	/** O serial da Classe. */
	private static final long serialVersionUID = 1L;

	/** Campo de refer�ncia a um novo collection TreeMap. */
	private TreeMap<Integer, String> score;

	/** Campo para definir onde o arquivo de recordes ser� gravado. */
	private static String file = "./dados/score.dat";

	/** Campo para armazenar a pontua��o do jogador na partida */
	private int pontuacao;

	/** Campo para armazenar a pontua��o acumulada(para ganhar uma nova vida)*/
	private int pontuacaoAcumulada;

	public Score() {
		score = new TreeMap<Integer, String>();
		pontuacao = 0;
		pontuacaoAcumulada = 0;
	}

	/**
	 * M�todo respons�vel pela pontua��o do jogo.
    */
	public void aumentaPonto() {
		pontuacao += 15;
		pontuacaoAcumulada += 15;
	}

	/**
	 * M�todo respons�vel pela decr�scimo da pontua��o do jogo. 
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
	 * M�todo respons�vel por pegar a pontua��o do jogo.
	 * @return pontua��o Quantidade de pontos
	 */
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * M�todo respons�vel por pegar a pontua��o acumulada do jogo.
	 * @return pontua��o Quantidade de pontos acumulada
	 */
	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	/**
	 * M�todo que zera a pontua��o acumulada do jogo.
	 */  
	public void zeraPontuacaoAcumulada() {
		pontuacaoAcumulada = 0;
	}

	/**
	 * M�todo para abertura do arquivo de recordes.
	 * @return A refer�ncia para o arquivo aberto.
	 * @throws IOException
	 */
	public static Score abreRecorde() {
		/** Campo de ref�rencia para grava��o do score. */
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
	 * M�todo para salvar do arquivo de recordes.
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
	 * M�todo booleano para saber se � poss�vel adicionar um novo recorde.
	 * @param pontos Pontua��o do jogador.
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
	 * M�todo para obter os pontos dos jogadores no ranking.
	 * @return Pontua��o do jogador.
	 */
	public TreeMap<Integer, String> getPontos() {
		return this.score;
	}
}
