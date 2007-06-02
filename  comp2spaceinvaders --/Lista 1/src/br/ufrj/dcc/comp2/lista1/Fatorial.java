package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Fatorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero = 0, fatorial = 0;
		System.out.println("Entre com o número:");
		try {
			numero = Integer.parseInt(teclado.readLine());
			if (numero == 0) {
				fatorial = 1;
			} else {
				fatorial = numero;
				for (int i = numero - 1; i > 1; i--) {
					fatorial *= i;
				}
			}
			System.out.println(numero + "! = " + fatorial);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
