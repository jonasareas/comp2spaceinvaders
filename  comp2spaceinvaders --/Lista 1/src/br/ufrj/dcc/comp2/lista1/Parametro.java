package br.ufrj.dcc.comp2.lista1;

/**
 * @author Jonas Ar�as Fragozo de Souza
 * 
 */

public class Parametro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args == null) {
			System.exit(0);
		} else {
			if ((args[0].length() > (args[1].length()))
					&& (args[0].length() > (args[2].length()))) {
				System.out.println(args[0].toUpperCase()
						+ " � o maior par�metro recebido com "
						+ args[0].length() + " caracteres.");
			}
			if ((args[1].length() > (args[0].length()))
					&& (args[1].length() > (args[2].length()))) {
				System.out.println(args[1].toUpperCase()
						+ " � o maior par�metro recebido com "
						+ args[1].length() + " caracteres.");
			}
			if ((args[2].length() > (args[0].length()))
					&& (args[2].length() > (args[1].length()))) {
				System.out.println(args[2].toUpperCase()
						+ " � o maior par�metro recebido com "
						+ args[2].length() + " caracteres.");
			}
		}
	}
}
