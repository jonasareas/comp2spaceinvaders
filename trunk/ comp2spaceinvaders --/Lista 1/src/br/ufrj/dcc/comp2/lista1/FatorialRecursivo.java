package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class FatorialRecursivo {

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
			fatorial = fatorial(numero);
			System.out.println(numero + "! = " + fatorial);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int fatorial(int numero) {
		// TODO Auto-generated method stub
		if (numero == 0) {
			return 1;
		} else {
			return numero * fatorial(numero - 1);
		}

	}

}
