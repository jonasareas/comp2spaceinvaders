package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Nomes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		String[] nomesSeparados;
		String todosOsNomes;

		try {
			System.out.println("Entre com os nomes (separados por vírgula):");
			todosOsNomes = teclado.readLine();
			nomesSeparados = todosOsNomes.split(",");

			for (int i = (nomesSeparados.length - 1); i >= 0; i--) {
				System.out.println(nomesSeparados[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
