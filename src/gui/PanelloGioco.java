package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelloGioco extends JPanel implements Style{

	private ArrayList<MyBtn2> giochiCreati = new ArrayList<MyBtn2>();
	
	public PanelloGioco() {
		this.setLayout(new BorderLayout());
		
		MyBtn btn = new MyBtn("Crea gioco");
		btn.setFont(Style.btn_font_sm);
		
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				CreaGioco newGioco = null;
				try {
					newGioco = new CreaGioco();
				} catch (IOException e1) {e1.printStackTrace();}
				
				JPanel giochiCreati = new JPanel();
				giochiCreati.setBackground(Style.background);
				giochiCreati.setLayout(new GridLayout(0,2));
				Border border = BorderFactory.createTitledBorder("Giochi creati");
				Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
				giochiCreati.setBorder(BorderFactory.createCompoundBorder(border, border2));
				
				if(newGioco.getGioco() != null)
					giochiCreati.add(newGioco.getGioco());
			}
			
		});
		
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		
		this.add(btn, BorderLayout.CENTER);
		this.setVisible(true);
	}
}