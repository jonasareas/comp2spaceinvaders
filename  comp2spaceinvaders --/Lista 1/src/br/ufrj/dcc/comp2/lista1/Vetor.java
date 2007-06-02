package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Vetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int[] vetor = new int[5];
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Entre com o número " + (i + 1));
				vetor[i] = Integer.parseInt(teclado.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if (vetor[i] > vetor[i + 1]) {
					int auxiliar = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = auxiliar;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(vetor[i] + " ");
		}

	}

}
