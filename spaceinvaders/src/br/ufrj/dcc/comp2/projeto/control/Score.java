package br.ufrj.dcc.comp2.projeto.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;

//import spaceinvaders.src.br.ufrj.dcc.comp2.projeto.control.Score;

public class Score implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Campo que instancia um novo collection TreeMap. */
	private TreeMap<Integer, String> score;
	/** Campo para definir onde o arquivo de recordes será gravado. */
	private static String file = "./dados/score.dat";
	
	private int pontuacao;
	private int pontuacaoAcumulada;
	public Score() {
		score = new TreeMap<Integer, String>();
		pontuacao = 0;
		pontuacaoAcumulada = 0;
	}

	public void aumentaPonto() {
		pontuacao += 15;
		pontuacaoAcumulada += 15;
	}
	
	public void diminuiPonto() {
		if (pontuacao > 0) {
			pontuacao -= 10;
			pontuacaoAcumulada -= 10;
		}
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

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
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			rec = (Score) in.readObject();
		} catch (Exception e) {
			System.out.println("Arquivo de recordes nao encontrado. Novo arquivo criado.");
			rec = new Score();
		}
		return rec;
	}

	/**
	 * Método para salvar do arquivo de recordes.
	 * @return A referência para o arquivo salvo.
	 * @throws IOException
	 */
	public void salvarRecorde() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
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
	 * Método para obter os pontos de um jogador.
	 * @return Pontuação do jogador.
	 */
	public TreeMap<Integer, String> getPontos() {
		return this.score;
	}
}
