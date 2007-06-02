package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class MiniTabuada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero = 0;
		try {
			do {
				System.out.print("Entre com um numero entre 0 e 9: ");
				numero = Integer.parseInt(teclado.readLine());
			} while ((numero < 0) || (numero > 9));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(numero + " X " + i + " = " + (numero * i));
		}
	}

}
