package br.ufrj.dcc.comp2.testeprojeto;

import javax.swing.JFrame;

public class TelaRanking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaRanking tela = new TelaRanking();
		tela.constroiTela();
	}
	
	public void constroiTela() {
		JFrame frame = new JFrame("Ranking");
		
		frame.setSize(200,200);
		frame.setVisible(true);
	}

}
