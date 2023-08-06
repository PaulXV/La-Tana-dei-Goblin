package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLabel extends JLabel implements Style{

	private String title;
	private String data;
	private String desc;
	private String autore;
	private String numMax;
	private String numMin;
	public boolean author = false;
	
	MyLabel(String title, boolean author) {
		this.author = author;
		this.setText(title);
		this.setFont(Style.title_font_sm);
		this.setBorder(Style.border);
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		
		this.addMouseListener(new MouseAdapter()  {
			
			public void mouseClicked(MouseEvent e) {
				JFrame info = new JFrame(title);
				info.setBackground(Style.text_color);
				info.setLayout(new GridLayout(6,1));
				info.setSize(400, 400);
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
				
				JLabel coAuthor = new JLabel("Autore in collab: " + autore);
				coAuthor.setFont(Style.title_font_sm);
				coAuthor.setForeground(Style.background);
				coAuthor.setBackground(Style.background);
				
				info.add(titolo);
				info.add(dataCreazione);
				info.add(descrizione);
				info.add(numPLYs);
				info.add(coAuthor);
				
				if(!author) {
					MyBtn addToList = new MyBtn("Add Game");
					info.add(addToList);
				}else {
					MyBtn delete = new MyBtn("Delete");
					info.add(delete);
				}
				
				info.setVisible(true);
			}
			
		});
		
	}
	
	public String toString() {
		return title + "/" + data + "/" + desc + "/" + autore + "/"
				+ numMax + "/" + numMin + " div\n";
	}

	public void setOther(String data, String desc, String autore, String numPly) {
		this.data = data;
		this.desc = desc;
		this.autore = autore;
		this.numMax = numPly.split("-")[1];
		this.numMin = numPly.split("-")[0];
	}
	
	public void setOtherv2(String data, String desc, String autore, String max, String min) {
		this.data = data;
		this.desc = desc;
		this.autore = autore;
		this.numMax = max;
		this.numMin = min;
	}
	
}