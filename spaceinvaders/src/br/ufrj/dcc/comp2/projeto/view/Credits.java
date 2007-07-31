package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/** 
 * Classe responsável pela tela de créditos do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
@SuppressWarnings("serial")
public class Credits extends JPanel implements Runnable {
	
	/** Instancia da classe JFrame */
	JFrame frame = new JFrame("Créditos");

	public void run() {

	}

	/**
	 * Método responsável pela construção da tela de créditos do jogo.
	 */
	public void constroiTela() {
		
		/** Novo objeto imagem que carrega a imagem de fundo da tela inicial. */
		Image universo = new ImageIcon("./imagens/Creditos.jpg").getImage();
		
		/** Novo objeto da classe Painel. */
		Painel painel = new Painel(universo);
		
		//JButton botao_Fechar = new JButton("Fechar");
		frame.setBackground(Color.BLACK);
		frame.add(painel);
		//frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		//botao_Fechar.addActionListener(new botao_Fechar_Listener());

		frame.setLocation(3, 45);
		frame.setResizable(false);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	/*class botao_Fechar_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.setVisible(false);
			frame.dispose();
		}
	}*/
}
