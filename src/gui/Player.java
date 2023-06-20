package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.*;

public class Player {

	private JPanel pannello = new JPanel();
	private String nomeUtente;
	//private JFrame frame;
	
	public Player(JPanel jPanel, String nome) {
		//serve per cancellare gli elementi di MenuGui e aggiornare il panel in modo che sia vuoto
		this.pannello = jPanel;
		this.nomeUtente = nome;
		pannello.removeAll();
		pannello.setLayout(new BorderLayout());
		
		//da qui si modella la nuova schermata: DA PENSARE!
		JLabel title = new JLabel("Benvenuto " + nomeUtente + "!");
		title.setFont(Style.title_font_h2);
		title.setForeground(Style.text_color);
		title.setHorizontalAlignment(0);
		
		
		
		pannello.add(title, BorderLayout.NORTH);
		pannello.setVisible(true);
	}

}