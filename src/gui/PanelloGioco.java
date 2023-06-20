package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelloGioco extends JPanel implements Style{

	private ArrayList<MyBtn2> giochiCreati = new ArrayList<MyBtn2>();
	
	public PanelloGioco() {
		this.setLayout(new GridLayout(0,2));
		Border border = BorderFactory.createTitledBorder("Giochi creati");
		Border border2 = BorderFactory.createEmptyBorder(10,10,10,10);
		this.setBorder(BorderFactory.createCompoundBorder(border, border2));
		
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		
		this.setVisible(true);
	}
}