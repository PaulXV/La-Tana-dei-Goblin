package gui;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import model.*;
import javax.swing.*;

public class CreaGioco extends JFrame {

	protected JLabel lNome, lDesc, lGioc, lDate, lAut;
	protected JTextField nome, descrizione, giocatori, dataEdizione;
	protected MyBtn button;
	protected JComboBox<String> authors;
	protected UsersData u = new UsersData();
	
	CreaGioco() throws IOException{
		
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Style.background);
		panel.setLayout(new GridLayout(0,1));
		
		lNome = new JLabel("Nome del gioco:");
		lNome.setBounds(100, 8, 200, 20);
		lNome.setForeground(Style.text_color);
		panel.add(lNome);
		
		nome = new JTextField();
		nome.setBounds(100, 27, 200, 28);
		nome.setBorder(null);
		panel.add(nome);
		
		lDesc = new JLabel("Descrizione del gioco:");
		lDesc.setBounds(100, 8, 200, 20);
		lDesc.setForeground(Style.text_color);
		panel.add(lDesc);
		descrizione = new JTextField();
		descrizione.setBounds(100, 27, 200, 28);
		descrizione.setBorder(null);
		panel.add(descrizione);
		
		lDate = new JLabel("Data di rilascio:");
		lDate.setBounds(100, 8, 200, 20);
		lDate.setForeground(Style.text_color);
		panel.add(lDate);
		dataEdizione = new JTextField();
		dataEdizione.setBounds(100, 27, 200, 28);
		dataEdizione.setBorder(null);
		panel.add(dataEdizione);
		
		lGioc = new JLabel("Numero di giocatori (nMin - nMax) :");
		lGioc.setBounds(100, 8, 200, 20);
		lGioc.setForeground(Style.text_color);
		panel.add(lGioc);
		giocatori = new JTextField();
		giocatori.setBounds(100, 27, 200, 28);
		giocatori.setBorder(null);
		panel.add(giocatori);
		
		lAut = new JLabel("Con chi hai collaborato:");
		lAut.setBounds(100, 8, 200, 20);
		lAut.setForeground(Style.text_color);
		panel.add(lAut);
		authors = new JComboBox<String>(u.getAllUsers());
		panel.add(authors);
		
		button = new MyBtn("Crea");
		button.setBounds(100, 110, 90, 25);
		button.setFont(Style.btn_font_sm);
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//TODO: creare un bottone da ritornare tramite una funzione a 'PannelloGioco'
				//il bottone avrà come testo il nome del gioco e se cliccato potrai vedere le sue caratteristiche
				//funzione a riga 89 - creare MyBtn2 prima
			}
		});
		
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	//public MyBtn2 newGioco(MyBtn2 btn) {return btn;}
	
}