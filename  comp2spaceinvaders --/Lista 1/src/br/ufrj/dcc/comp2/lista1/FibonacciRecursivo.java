package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class FibonacciRecursivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero;
		System.out.println("Entre com o número:");
		try {
			numero = Integer.parseInt(teclado.readLine());
			for (int i = 1; i <= numero; i++) {
				System.out.print(fibonacci(i) + " ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int fibonacci(int numero) {
		// TODO Auto-generated method stub
		if (numero == 0) {
			return 0;
		}
		if (numero == 1) {
			return 1;
		} else {
			return (fibonacci(numero - 1) + fibonacci(numero - 2));
		}
	}
}
