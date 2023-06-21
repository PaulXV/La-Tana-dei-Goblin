package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Author{

	//private JFrame frame;
	private JPanel pannello = new JPanel();
	private String nomeUtente;
	
	Author(JPanel jPanel, String nome){
		//serve per cancellare gli elementi di MenuGui e aggiornare il panel in modo che sia vuoto
		this.pannello = jPanel;
		this.nomeUtente = nome;
		pannello.removeAll();
		pannello.setLayout(new BorderLayout());
		
		//da qui si modella la nuova schermata: DA PENSARE!
		JLabel title = new JLabel("Eccoci " + nomeUtente.toLowerCase() + "!");
		title.setFont(Style.title_font_h2);
		title.setForeground(Style.text_color);
		title.setHorizontalAlignment(0);
		
		//per tornare alla home - da aggiungere
		JPanel panSx = new JPanel();
		MyBtn btn = new MyBtn(" HOME ");
		btn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		panSx.setBackground(Style.background);
		panSx.add(btn);
		
		JPanel container = new JPanel();
		container.setBackground(Style.background);
		container.setLayout(new BorderLayout());
		
		PannelloGioco areaGiochi = new PannelloGioco();
		
		MyBtn createButton = new MyBtn("Crea gioco");
		createButton.setFont(Style.btn_font_sm);
		
		createButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				CreaGioco newGioco = new CreaGioco(areaGiochi);
				areaGiochi.repaint();
				areaGiochi.setVisible(true);
				container.repaint();
				pannello.repaint();
			}
			
		});
		
		container.add(createButton, BorderLayout.NORTH);
		container.add(areaGiochi, BorderLayout.CENTER);
		
		pannello.add(panSx, BorderLayout.WEST);
		pannello.add(container, BorderLayout.CENTER);
		pannello.add(title, BorderLayout.NORTH);
		pannello.setVisible(true);
		
	}
}