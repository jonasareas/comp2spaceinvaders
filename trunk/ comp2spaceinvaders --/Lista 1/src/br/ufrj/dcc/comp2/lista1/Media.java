package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Media {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		double somatorio = 0;
		int numero;
		for (int i = 0; i < 5; i++) {
			System.out.println("Entre com um número:");
			try {
				numero = Integer.parseInt(teclado.readLine());
				somatorio += numero;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("A média dos números é " + somatorio / 5);

	}

}
