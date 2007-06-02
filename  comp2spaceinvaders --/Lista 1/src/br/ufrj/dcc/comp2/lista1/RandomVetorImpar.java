package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class RandomVetorImpar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[10];
		int auxiliar, naoPode = 0;
		do {
			auxiliar = 1 + (int) (Math.random() * 20);
		} while (auxiliar % 2 == 0);
		numeros[0] = auxiliar;
		for (int i = 1; i < 10; i++) {
			auxiliar = 1 + (int) (Math.random() * 20);
			for (int j = 0; j < i; j++) {
				if (auxiliar == numeros[j] || auxiliar % 2 == 0) {
					naoPode = 1;
					i--;
				}
			}
			if (naoPode == 0) {
				numeros[i] = auxiliar;
			}
			naoPode = 0;
		}

		System.out.println("Os números ímpares distindos gerados são:");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}

	}

}
