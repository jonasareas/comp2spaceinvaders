package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero, penultimoNumero = 1, ultimoNumero = 1, numeroSequencia;

		System.out.print("Entre com um numero: ");
		try {
			numero = Integer.parseInt(teclado.readLine());
			System.out.print(penultimoNumero + " " + ultimoNumero);
			for (int i = 3; i <= numero; i++) {
				numeroSequencia = penultimoNumero + ultimoNumero;
				penultimoNumero = ultimoNumero;
				ultimoNumero = numeroSequencia;
				System.out.print(" " + numeroSequencia);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
