package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import model.*;

public class MyLabel extends JLabel implements Style{

	private String title;
	private String data;
	private String desc;
	private String collab;
	private String numMax;
	private String numMin;
	private boolean author = false;
	private boolean isMaggiorenne = false;
	private String autore;
	private Premio premio;
	private String premio2;
	private ListaGiochi listaGiochi;
	private PannelloGioco pann;
	
	MyLabel(String title, boolean author, String autore) {
		this.author = author;
		this.autore = autore;
		this.title = title;
		this.setText(title);
		this.setHorizontalAlignment(0);
		this.setFont(Style.title_font_sm);
		this.setBorder(Style.border);
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		
		this.addMouseListener(new MouseAdapter()  {
			
			public void mouseClicked(MouseEvent e) {
				JFrame info = new JFrame(title);
				info.setBackground(Style.text_color);
				info.setLayout(new GridLayout(0,1));
				info.setSize(400, 550);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				JLabel titolo = new JLabel(title);
				titolo.setFont(Style.title_font_h2);
				titolo.setForeground(Style.background);
				titolo.setHorizontalAlignment(0);
				titolo.setBackground(Style.background);
				
				JLabel dataCreazione = new JLabel("Data di Creazione: " + data);
				dataCreazione.setFont(Style.title_font_sm);
				dataCreazione.setForeground(Style.background);
				dataCreazione.setBackground(Style.background);
				
				JLabel descrizione = new JLabel("Descrizione: " + desc);
				descrizione.setFont(Style.title_font_sm);
				descrizione.setForeground(Style.background);
				descrizione.setBackground(Style.background);
				
				JLabel numPLYs = new JLabel("Numero di giocatori (min-max): " + numMin + "-" + numMax);
				numPLYs.setFont(Style.title_font_sm);
				numPLYs.setForeground(Style.background);
				numPLYs.setBackground(Style.background);
				
				JLabel isMax = new JLabel("E' per maggiorenni: " + ((isMaggiorenne) ? "SI" : "NO") );
				isMax.setFont(Style.title_font_sm);
				isMax.setForeground(Style.background);
				isMax.setBackground(Style.background);
				
				JLabel coAuthor = new JLabel("Autore " + autore + ", collab di: " + collab);
				coAuthor.setFont(Style.title_font_sm);
				coAuthor.setForeground(Style.background);
				coAuthor.setBackground(Style.background);
				
				JLabel premi = new JLabel("Premi: " + premio2);
				premi.setFont(Style.title_font_sm);
				premi.setForeground(Style.background);
				premi.setBackground(Style.background);
				
				info.add(titolo);
				info.add(dataCreazione);
				info.add(descrizione);
				info.add(numPLYs);
				info.add(isMax);
				info.add(coAuthor);
				info.add(premi);
				
				if(!author) {
					JLabel buttonContainer = new JLabel();
					buttonContainer.setLayout(new GridLayout(1,2));
					MyBtn addToList = new MyBtn("Add Game");
					MyBtn removeFromList = new MyBtn("Remove Game");
					
					addToList.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e){
							try {
								listaGiochi.addGame(MyLabel.this);
							} catch (IOException e1) {e1.printStackTrace();}
						}
					});
					
					removeFromList.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							listaGiochi.removeGame(MyLabel.this);
							
							try {pann.addGame(MyLabel.this, 1);}
							catch (IOException e1) {e1.printStackTrace();}
						}
					});
					
					buttonContainer.add(addToList);
					buttonContainer.add(removeFromList);
					info.add(buttonContainer);
					
				}else {
					MyBtn delete = new MyBtn("Delete");
					
					delete.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							try {pann.removeGame(MyLabel.this);}
							catch (IOException e1) {e1.printStackTrace();}
							info.dispose();
						}
					});
					
					info.add(delete);
				}
				
				info.setVisible(true);
			}
			
		});
		
	}
	
	public String toString() {
		return autore + "/"+ title + "/" + data + "/" + desc + "/" + collab + "/"
				+ numMax + "/" + numMin + "/" + premio + "/" + isMaggiorenne + " div";
	}

	public void setOther(String data, String desc, String collab, String numPly, Premio premio, boolean isMaggiorenne) {
		this.data = data;
		this.desc = desc;
		this.collab = collab;
		this.numMax = numPly.split("-")[1];
		this.numMin = numPly.split("-")[0];
		this.premio = premio;
		this.isMaggiorenne = isMaggiorenne;
	}
	
	public void setOtherv2(String data, String desc, String collab, String max, String min, String premio, String isMaggiorenne) {
		this.data = data;
		this.desc = desc;
		this.collab = collab;
		this.numMax = max;
		this.numMin = min;
		this.premio2 = premio;
		if(isMaggiorenne.equals("false"))
			this.isMaggiorenne = false;
		else if(isMaggiorenne.equals("true"))
			this.isMaggiorenne = true;
	}
	
	public void setListaGiochi(ListaGiochi l) {this.listaGiochi = l;}
	public void setPannelloGioco(PannelloGioco pan) {this.pann = pan;}
}