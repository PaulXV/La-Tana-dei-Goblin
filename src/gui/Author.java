package gui;

import javax.swing.JPanel;

public class Author {

	private JPanel pannello = new JPanel();
	
	Author(JPanel jPanel){
		//serve per cancellare gli elementi di MenuGui e aggiornare il panel in modo che sia vuoto
		this.pannello = jPanel;
		pannello.removeAll();
		pannello.repaint();
		
		//da qui si modella la nuova schermata: DA PENSARE!
	}
}