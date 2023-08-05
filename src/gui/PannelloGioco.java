package gui;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import model.*;

public class PannelloGioco extends JPanel implements Style{

	private ArrayList<MyLabel> giochiCreati = new ArrayList<MyLabel>();
	private int numColonne = 3;
	private int numRighe;
	private GamesDatas g = new GamesDatas();
	
	public PannelloGioco() throws IOException {
		Border border = BorderFactory.createTitledBorder("Giochi creati");
		Border brd = BorderFactory.createTitledBorder(border, "Giochi creati", 0, 0, btn_font_sm);
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(brd, border2));
		this.setBackground(Style.hover);
		this.setForeground(Style.text_color);
		
		inserisciGiochiEsistenti(g.getAllGames());
		
		this.setVisible(true);
	}
	
	private void inserisciGiochiEsistenti(String[] allGames) throws IOException {
		
		if(allGames != null)
			for(String s : allGames) {
				MyLabel newGame = new MyLabel(s.split(")")[0]);
				addGame(newGame, 1);
			}
		
	}

	public void addGame(MyLabel game, int check) throws IOException {
		
		if(check != 1)
			g.newGame(game);
			
		giochiCreati.add(game);	
		numRighe = giochiCreati.size() / numColonne + 1;
		this.setLayout(new GridLayout(numRighe, numColonne));
		//System.out.println(game.toString());
		setGameOnTable();
	}
	
	public void setGameOnTable() {
		this.removeAll();
		
		for(MyLabel l : giochiCreati)
			this.add(l);
		
		this.invalidate();
		this.revalidate();
		this.repaint();
	}
}