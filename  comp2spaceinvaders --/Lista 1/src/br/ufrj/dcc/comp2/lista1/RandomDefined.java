package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class RandomDefined {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int limite = 0;
		int[] posicao = new int[3];
		try {
			System.out.println("Entre com o número limite para sorteio:");
			limite = Integer.parseInt(teclado.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 3; i++) {
			posicao[i] = 1 + (int) (Math.random() * limite);
		}
		for (int i = 0; i < 2; i++) {
			if (posicao[i] > posicao[i + 1]) {
				int posicaoTemporaria = posicao[i];
				posicao[i] = posicao[i + 1];
				posicao[i + 1] = posicaoTemporaria;
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(posicao[i] + " ");
		}
		System.out.println("\nO maior número sorteado foi: " + posicao[2]);

	}

}
