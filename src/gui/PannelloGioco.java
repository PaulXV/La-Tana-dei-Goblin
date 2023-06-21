package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class PannelloGioco extends JPanel implements Style{

	private ArrayList<MyLabel> giochiCreati = new ArrayList<MyLabel>();
	
	public PannelloGioco() {
		Border border = BorderFactory.createTitledBorder("Giochi creati");
		Border brd = BorderFactory.createTitledBorder(border, "Giochi creati", 0, 0, btn_font_sm);
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(brd, border2));
		this.setBackground(Style.hover);
		this.setForeground(Style.text_color);
		
		int numColonne = 3;
		int numRighe = giochiCreati.size() / numColonne + 1;
		this.setLayout(new GridLayout(numRighe, numColonne));
		this.setVisible(true);
	}
	
	public void addGame(MyLabel game) {
		giochiCreati.add(game);
		setGameOnTable();
	}
	
	public void setGameOnTable() {
		this.removeAll();
		
		for(MyLabel l : giochiCreati)
			this.add(l);
		
		this.repaint();
	}
}