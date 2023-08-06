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
	private boolean isAuthor;
	private GamesDatas g = new GamesDatas();
	
	public PannelloGioco(boolean isAuthor, String autore) throws IOException {
		this.isAuthor = isAuthor;
		Border border = BorderFactory.createTitledBorder("Giochi creati");
		Border brd = BorderFactory.createTitledBorder(border, "Giochi creati", 0, 0, btn_font_sm);
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(brd, border2));
		this.setBackground(Style.hover);
		this.setForeground(Style.text_color);
		
		inserisciGiochiEsistenti(g.getAllGames(), autore);
		
		this.setVisible(true);
	}
	
	private void inserisciGiochiEsistenti(String allGames, String autore) throws IOException {
		
		if(allGames!=null && allGames!="") {
			//System.out.println(allGames);
			String[] giochiDaCreare = allGames.split(" div");
			if(autore != "") {
				for(String s : giochiDaCreare) {
					
					String[] gioco = s.split("/");
					if(gioco[0].equals(autore)) {
						MyLabel newGame = new MyLabel(gioco[1], isAuthor, gioco[0]);
						newGame.setOtherv2(gioco[2], gioco[3], gioco[4], gioco[5], gioco[6] );
						
						addGame(newGame, 1);
					}
				}
			}else {
				for(String s : giochiDaCreare) {
					String[] gioco = s.split("/");
					MyLabel newGame = new MyLabel(gioco[1], isAuthor, gioco[0]);
					newGame.setOtherv2(gioco[2], gioco[3], gioco[4], gioco[5], gioco[6] );
					
					addGame(newGame, 1);
				}
			}
		}
		
	}

	public void addGame(MyLabel game, int check) throws IOException {
		
		if(check != 1)
			g.appendGame(game);
			
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