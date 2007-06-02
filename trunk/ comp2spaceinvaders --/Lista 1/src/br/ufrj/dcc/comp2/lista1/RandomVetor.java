package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class RandomVetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[15];
		int auxiliar;

		for (int i = 0; i < 15; i++) {
			numeros[i] = 1 + (int) (Math.random() * 50);
		}

		for (int i = 14; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numeros[j] > numeros[j + 1]) {
					auxiliar = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = auxiliar;
				}
			}
		}
		System.out.println("Os números ordenados são:");
		for (int i = 0; i < 15; i++) {
			System.out.print(numeros[i] + " ");
		}

	}

}
