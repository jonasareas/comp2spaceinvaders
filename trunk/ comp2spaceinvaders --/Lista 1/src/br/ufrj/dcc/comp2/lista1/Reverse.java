package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		String dado;

		try {
			System.out.print("Entre com a frase: ");
			dado = teclado.readLine();

			for (int i = (dado.length() - 1); i >= 0; i--) {
				System.out.print(dado.charAt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
