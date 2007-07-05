package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Credits extends JPanel implements Runnable {
	JFrame frame = new JFrame("Créditos");

	public void run() {

	}

	public void constroiTela() {
		Image universo = new ImageIcon("./imagens/Creditos.jpg").getImage();
		Painel painel = new Painel(universo);
		//JButton botao_Fechar = new JButton("Fechar");
		frame.setBackground(Color.BLACK);
		frame.add(painel);
		//frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		//botao_Fechar.addActionListener(new botao_Fechar_Listener());

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
