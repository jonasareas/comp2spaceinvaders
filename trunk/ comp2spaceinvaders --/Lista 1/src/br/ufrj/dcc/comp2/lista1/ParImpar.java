package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class ParImpar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int[] numero = new int[5];
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Entre com o " + (i + 1) + "º número:");
				numero[i] = Integer.parseInt(teclado.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			if (numero[i] % 2 == 0) {
				System.out.println(numero[i] + " Par");
			} else {
				System.out.println(numero[i] + " Ímpar");
			}
		}

	}

}
