package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Crescente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero1 = 0, numero2 = 0, numero3 = 0;
		try {
			System.out.println("Digite um número inteiro: ");
			numero1 = Integer.parseInt(teclado.readLine());
			int numeroAuxiliar = numero1;
			System.out.println("Digite outro número inteiro: ");
			numero2 = Integer.parseInt(teclado.readLine());
			if (numero2 < numero1) {
				numeroAuxiliar = numero2;
				numero2 = numero1;
				numero1 = numeroAuxiliar;
			}
			System.out.println("Digite mais um número inteiro: ");
			numero3 = Integer.parseInt(teclado.readLine());
			if (numero3 < numero1) {
				numeroAuxiliar = numero3;
				numero3 = numero2;
				numero2 = numero1;
				numero1 = numeroAuxiliar;
			} else {
				if (numero3 < numero2) {
					numeroAuxiliar = numero3;
					numero3 = numero2;
					numero2 = numeroAuxiliar;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(numero1);
		System.out.println(numero2);
		System.out.println(numero3);

	}

}
