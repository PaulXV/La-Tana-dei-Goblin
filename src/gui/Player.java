package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Player {

	private JPanel pannello = new JPanel();
	private String nomeUtente;
	private JFrame frame = new JFrame();
	
	public Player(JPanel jPanel, String nome, String birthDate, JFrame frame) throws IOException {
		this.frame = frame;
		//serve per cancellare gli elementi di MenuGui e aggiornare il panel in modo che sia vuoto
		this.pannello = jPanel;
		this.nomeUtente = nome;
		pannello.removeAll();
		pannello.setLayout(new BorderLayout());
		
		//da qui si modella la nuova schermata
		JLabel title = new JLabel("Benvenuto " + nomeUtente + "!");
		title.setFont(Style.title_font_h2);
		title.setForeground(Style.text_color);
		title.setHorizontalAlignment(0);
		
		JPanel panSx = new JPanel();
		MyBtn btn = new MyBtn(" HOME ");
		btn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				GUI gui = new GUI();
				gui.setVisible(true);
				frame.dispose();
			}
		});
		panSx.setBackground(Style.background);
		panSx.add(btn);
		
		JPanel container = new JPanel();
		container.setBackground(Style.background);
		container.setLayout(new BorderLayout());
		
		ListaGiochi lista = new ListaGiochi();
		lista.setVisible(true);
		PannelloGioco areaGiochi = new PannelloGioco(false, "", birthDate, lista, null);
		areaGiochi.setVisible(true);
		
		container.add(areaGiochi, BorderLayout.CENTER);
		container.add(lista, BorderLayout.SOUTH);
		
		pannello.add(panSx, BorderLayout.WEST);
		pannello.add(container, BorderLayout.CENTER);
		pannello.add(title, BorderLayout.NORTH);
		pannello.setVisible(true);
	}

	public void setFrame( JFrame jFrame ) {this.frame = jFrame;}
	
}