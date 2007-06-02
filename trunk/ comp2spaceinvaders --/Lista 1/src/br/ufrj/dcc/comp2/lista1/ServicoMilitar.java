package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class ServicoMilitar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(
					System.in));
			String nome = new String();
			int idade;
			char[] sexo = new char[1];
			System.out.println("Entre com seu nome:");
			nome = teclado.readLine();
			System.out.println(nome + ", entre com sua idade:");
			idade = Integer.parseInt(teclado.readLine());
			if (idade == 18) {
				System.out.println("Entre com seu sexo:");
				teclado.read(sexo);
				if (sexo[0] == 'm' || sexo[0] == 'M') {
					System.out.println("Serviço Militar!!!");
				} else {
					System.out.println("Livre do Serviço Militar.");
				}
			} else {
				System.out.println("Livre do Serviço Militar.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
