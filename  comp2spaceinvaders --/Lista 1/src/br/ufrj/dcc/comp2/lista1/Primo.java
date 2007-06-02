package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Primo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero, raiz, eh;
		System.out.println("Entre com um número:");
		try {
			numero = Integer.parseInt(teclado.readLine());
			raiz = (int) Math.sqrt(numero);
			eh = 1;
			if (numero == 1 || numero == 0) {
				eh = 0;
			} else {
				for (int i = 2; i <= raiz; i++) {
					if ((numero % i) == 0) {
						eh = 0;
						break;
					}
				}
			}
			if (eh == 0) {
				System.out.println("Não é primo.");
			} else {
				System.out.println("É primo.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
