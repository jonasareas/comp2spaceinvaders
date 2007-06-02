package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Ar�as Fragozo de Souza
 * 
 */

public class Comparacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero = -1, numeroAnterior = 0;
		System.out.println("Entre com um n�mero:");
		do {
			try {
				if (numero == -1) {
					numero = Integer.parseInt(teclado.readLine());
					System.out
							.println("Primeiro n�mero lido, logo n�o h� outros n�meros para compara��o.");
				} else {
					numero = Integer.parseInt(teclado.readLine());
					if (numero > numeroAnterior) {
						System.out.println("Maior que o anterior.");
					} else {
						if (numero < numeroAnterior) {
							System.out.println("Menor que o anterior.");
						} else {
							if (numero == numeroAnterior) {
								System.out.println("Igual ao anterior.");
							}
						}
					}
				}
				numeroAnterior = numero;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (numero != -1);

	}

}
