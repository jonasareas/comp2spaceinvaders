package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Ar�as Fragozo de Souza
 * 
 */

public class RandomVetorPar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[20];
		int auxiliar;

		for (int i = 0; i < 20; i++) {
			auxiliar = 1 + (int) (Math.random() * 40);
			if (auxiliar % 2 == 0) {
				numeros[i] = auxiliar;
			} else {
				i--;
			}
		}

		System.out.println("Os n�meros pares gerados s�o:");
		for (int i = 0; i < 20; i++) {
			System.out.print(numeros[i] + " ");
		}

	}

}
