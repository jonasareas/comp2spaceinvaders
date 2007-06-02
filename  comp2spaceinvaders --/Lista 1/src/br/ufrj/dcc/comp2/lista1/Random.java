package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class Random {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero, contador = 0;
		String saida = "";
		while (contador < 10) {
			numero = 1 + (int) (Math.random() * 50);
			if (numero % 2 == 0) {
				saida += numero + " ";
				contador++;
			}
		}
		System.out.println(saida);

	}

}
