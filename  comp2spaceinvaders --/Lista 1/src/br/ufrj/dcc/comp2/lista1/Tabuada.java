package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Tabuada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int[][] tabuada = new int[10][10];
		int numero;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tabuada[i][j] = i * j;
			}
		}
		try {
			System.out.print("Entre com um número entre 0 e 9: ");
			numero = Integer.parseInt(teclado.readLine());
			while (numero >= 0) {
				for (int i = 0; i < 10; i++) {
					System.out.println(numero + " x " + i + " = "
							+ tabuada[numero][i]);
				}
				System.out.print("Entre com um número entre 0 e 9: ");
				numero = Integer.parseInt(teclado.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
