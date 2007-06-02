package br.ufrj.dcc.comp2.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jonas Arêas Fragozo de Souza
 * 
 */

public class ComparacaoVetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int numero, contaNumeros = 0, indicePrincipal = 0, podeSair = 0;
		int[] vetorAuxiliar = new int[5];
		int[] vetorPrincipal = new int[100];
		System.out.println("Entre com um número:");
		try {
			numero = Integer.parseInt(teclado.readLine());
			while (numero == -1 && contaNumeros < 5 && podeSair == 0) {
				System.out
						.println("A quantidade minima de 5 numeros ainda nao foi alcancada!");
				System.out.println("Entre com outro número:");
				numero = Integer.parseInt(teclado.readLine());
			}
			while (numero != -1) {
				vetorAuxiliar[contaNumeros] = numero;
				contaNumeros++;
				if (contaNumeros == 5) {
					for (int i = 0; i < 4; i++) {
						if (vetorAuxiliar[i] > vetorAuxiliar[i + 1]) {
							int numeroAuxiliar = vetorAuxiliar[i];
							vetorAuxiliar[i] = vetorAuxiliar[i + 1];
							vetorAuxiliar[i + 1] = numeroAuxiliar;
						}
					}
					System.out.println("O maior desta sequência foi: "
							+ vetorAuxiliar[4]);
					vetorPrincipal[indicePrincipal] = vetorAuxiliar[4];
					indicePrincipal++;
					for (int i = 0; i < 5; i++) {
						vetorAuxiliar[i] = 0;
					}
					contaNumeros = 0;
					podeSair = 1;
				}
				System.out.println("Entre com outro número:");
				numero = Integer.parseInt(teclado.readLine());
				while (numero == -1 && contaNumeros < 5 && podeSair == 0) {
					System.out
							.println("A quantidade minima de 5 numeros ainda nao foi alcancada!");
					System.out.println("Entre com outro número:");
					numero = Integer.parseInt(teclado.readLine());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Os maiores são:");
		for (int i = 0; i < (indicePrincipal); i++) {
			System.out.print(vetorPrincipal[i] + " ");
		}

	}

}
