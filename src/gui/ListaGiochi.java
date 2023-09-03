package gui;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class ListaGiochi extends JPanel implements Style{

	private ArrayList<MyLabel> giochiCreati = new ArrayList<MyLabel>();
	private int numColonne = 3;
	private int numRighe;
	
	public ListaGiochi() {
		Border border = BorderFactory.createTitledBorder("I tuoi giochi: ");
		Border brd = BorderFactory.createTitledBorder(border, "I tuoi giochi: ", 0, 0, btn_font_sm);
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(brd, border2));
		this.setBackground(Style.hover);
		this.setForeground(Style.text_color);
		this.setVisible(true);
	}
	
	public void addGame(MyLabel game) throws IOException {
		giochiCreati.add(game);	
		numRighe = giochiCreati.size() / numColonne + 1;
		this.setLayout(new GridLayout(numRighe, numColonne));
		setGameOnTable();
	}
	
	public void removeGame(MyLabel game) {
		if(giochiCreati.contains(game)) {
			giochiCreati.remove(game);
			numRighe = giochiCreati.size() / numColonne + 1;
			this.setLayout(new GridLayout(numRighe, numColonne));
			setGameOnTable();
		}
	}
	
	public boolean hasGame(MyLabel gioco)	{return giochiCreati.contains(gioco);}
	
	private void setGameOnTable() {
		this.removeAll();
		
		for(MyLabel l : giochiCreati)
			this.add(l);
		
		this.invalidate();
		this.revalidate();
		this.repaint();
	}
	
}