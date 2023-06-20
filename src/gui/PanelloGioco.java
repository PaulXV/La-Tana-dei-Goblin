package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelloGioco extends JPanel implements Style{

	public PanelloGioco() {
		this.setLayout(new BorderLayout());
		
		MyBtn btn = new MyBtn("Crea gioco");
		btn.setFont(Style.btn_font_sm);
		
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
			//TODO: se clicca si apre una finestra tipo quella di login per creare
			public void mouseClicked(MouseEvent e) {
				
				try {
					CreaGioco newGioco = new CreaGioco();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				JPanel giochiCreati = new JPanel();
				giochiCreati.setLayout(new GridLayout(0,2));
				Border border = BorderFactory.createTitledBorder("Giochi creati");
				Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
				giochiCreati.setBorder(BorderFactory.createCompoundBorder(border, border2));
				
			}
			
		});
		
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		
		this.add(btn, BorderLayout.CENTER);
		this.setVisible(true);
	}
}