package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class MaiorMenor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int[] numero = new int[10];
		int maior = 0, menor = 0;
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Entre com o " + (i + 1) + "º número:");
				numero[i] = Integer.parseInt(teclado.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 0) {
				menor = numero[i];
				maior = numero[i];
			} else {
				if (numero[i] < menor) {
					menor = numero[i];
				}
				if (numero[i] > maior) {
					maior = numero[i];
				}
			}
		}
		if (menor == maior) {
			System.out.println("Todos os números são iguais!");
		} else {
			System.out.println("Menor = " + menor + "\nMaior = " + maior);
		}
	}

}
