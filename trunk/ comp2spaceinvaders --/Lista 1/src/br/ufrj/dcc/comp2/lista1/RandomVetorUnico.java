package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class RandomVetorUnico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[10];
		int auxiliar, jahExiste = 0;

		numeros[0] = 1 + (int) (Math.random() * 30);
		for (int i = 1; i < 10; i++) {
			auxiliar = 1 + (int) (Math.random() * 30);
			for (int j = 0; j < i; j++) {
				if (auxiliar == numeros[j]) {
					jahExiste = 1;
					i--;
				}
			}
			if (jahExiste == 0) {
				numeros[i] = auxiliar;
			}
			jahExiste = 0;
		}

		System.out.println("Os números distindos gerados são:");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}

	}

}
