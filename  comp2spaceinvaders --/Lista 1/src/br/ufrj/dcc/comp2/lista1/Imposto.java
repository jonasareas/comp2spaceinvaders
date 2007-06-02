package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Imposto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		double imposto = 0;
		System.out.println("Entre com o salário:");
		try {
			imposto = Double.parseDouble(teclado.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imposto *= 0.9;
		System.out.println("O salário com o imposto descontado é: R$ "
				+ imposto);

	}

}
