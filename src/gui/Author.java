package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Author{

	private JPanel pannello = new JPanel();
	private String nomeUtente;
	
	Author(JPanel jPanel, String nome) throws IOException{
		//serve per cancellare gli elementi di MenuGui e aggiornare il panel in modo che sia vuoto
		this.pannello = jPanel;
		this.nomeUtente = nome;
		pannello.removeAll();
		pannello.setLayout(new BorderLayout());
		
		//da qui si modella la nuova schermata
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
		
		PannelloGioco areaGiochi = new PannelloGioco(true, nome);
		areaGiochi.setVisible(true);
		container.add(areaGiochi, BorderLayout.CENTER);
		
		MyBtn createButton = new MyBtn("Crea gioco");
		createButton.setFont(Style.btn_font_sm);
		
		createButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				CreaGioco newGioco = new CreaGioco(areaGiochi, nomeUtente);
				pannello.repaint();
			}
			
		});
		
		container.add(createButton, BorderLayout.NORTH);
		
		pannello.add(panSx, BorderLayout.WEST);
		pannello.add(container, BorderLayout.CENTER);
		pannello.add(title, BorderLayout.NORTH);
		pannello.setVisible(true);
		
	}
}