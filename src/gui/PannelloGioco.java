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
	private String autore;
	private boolean isAuthor;
	private JLabel premi;
	private GamesDatas g = new GamesDatas();
	private ListaGiochi l = new ListaGiochi();
	
	public PannelloGioco(boolean isAuthor, String autore, String dataNascitaAutore, ListaGiochi l, JLabel premi) throws IOException {
		this.isAuthor = isAuthor;
		this.premi = premi;
		this.autore = autore;
		Border border = BorderFactory.createTitledBorder("Giochi creati");
		Border brd = BorderFactory.createTitledBorder(border, "Giochi creati", 0, 0, btn_font_sm);
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(brd, border2));
		this.setBackground(Style.hover);
		this.setForeground(Style.text_color);
		this.l = l;
		
		inserisciGiochiEsistenti(g.getAllGames(), autore, dataNascitaAutore);
		
		this.setVisible(true);
	}
	
	private void inserisciGiochiEsistenti(String allGames, String autore, String dataNascitaAutore) throws IOException {
		
		if(allGames!=null && allGames!="") {
			String[] giochiDaCreare = allGames.split(" div");
			if(autore != "") {
				for(String s : giochiDaCreare) {
					
					String[] gioco = s.split("/");
					if(gioco[0].equals(autore)) {
						MyLabel newGame = new MyLabel(gioco[1], isAuthor, gioco[0]);
						newGame.setOther(gioco[2], gioco[3], gioco[4], gioco[5], gioco[6], gioco[7], gioco[8], gioco[9]);
						newGame.setPannelloGioco(this);
						addGame(newGame, 1);
					}
				}
			}else {
				for(String s : giochiDaCreare) {
					String[] gioco = s.split("/");
					
					if(gioco[8].equals("true")) {
						int annoNascitaAutore = Integer.parseInt(dataNascitaAutore);
						int annoAttuale = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
						if(annoAttuale - annoNascitaAutore < 18) {
							continue;
						}else {insertGame(gioco);}
						
					}else {insertGame(gioco);}
					
				}
			}
		}
		
	}
	
	private void insertGame(String[] gioco) throws IOException {
		MyLabel newGame = new MyLabel(gioco[1], isAuthor, gioco[0]);
		newGame.setOther(gioco[2], gioco[3], gioco[4], gioco[5], gioco[6], gioco[7], gioco[8], gioco[9]);
		newGame.setListaGiochi(l);
		newGame.setPannelloGioco(this);
		addGame(newGame, 1);
	}

	public void addGame(MyLabel game, int check) throws IOException {
		
		if(check != 1)
			g.appendGame(game);
			
		giochiCreati.add(game);	
		numRighe = giochiCreati.size() / numColonne + 1;
		this.setLayout(new GridLayout(numRighe, numColonne));
		setGameOnTable();
	}
	
	private void setGameOnTable() throws IOException {
		this.removeAll();
		
		if(premi != null) premi.setText("Premi vinti: " + g.getNumPremiVinti(autore));
		
		for(MyLabel l : giochiCreati)
			this.add(l);
		
		this.invalidate();
		this.revalidate();
		this.repaint();
	}

	public void removeGame(MyLabel game) throws IOException {
		if(giochiCreati.contains(game)) {
			giochiCreati.remove(game);
			String[] delete = game.toString().split("/");
			String allGames = g.getAllGames();
			String[] temp = allGames.split(" div");
			String[] dividedGames = new String[temp.length];
			int cnt = 0;
			
			for(int i=0;i<temp.length;i++)
				dividedGames[i] = temp[i] + " div";
			
			for(String s : dividedGames) {
				
				if(delete[0].equals(s.split("/")[0])){
						if(delete[1].equals(s.split("/")[1]) && delete[2].equals(s.split("/")[2]) && delete[3].equals(s.split("/")[3])) {
							continue;
						}else {
							if(cnt == 0) {
								g.appendGame(s+"\n", true); cnt=1;
							}else
								g.appendGame(s+"\n", false);
						}
						
				}else {
					if(cnt == 0) {
						g.appendGame(s+"\n", true); cnt=1;
					}else
						g.appendGame(s+"\n", false);
				}
			}
				
			setGameOnTable();
		}
		
	}
	
}