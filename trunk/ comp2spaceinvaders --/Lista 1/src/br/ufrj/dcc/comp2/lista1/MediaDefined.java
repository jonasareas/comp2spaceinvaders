package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class MediaDefined {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int limite = 0, numero, i = 0;
		double media = 0;
		System.out.println("Entre com a quantidade de números a serem lidos:");
		try {
			limite = Integer.parseInt(teclado.readLine());
			while (i < limite) {
				System.out.println("Entre com o número " + (i + 1));
				numero = Integer.parseInt(teclado.readLine());
				media += numero;
				i++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A média destes " + limite + " números é "
				+ (media / limite));
	}

}
