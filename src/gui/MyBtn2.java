package gui;

import java.awt.event.*;

public class MyBtn2 extends MyBtn implements Style{

	private String data;
	private String desc;
	private String autore;
	private String numMax;
	private String numMin;
	
	MyBtn2(String title) {
		super(title);
		this.setFont(btn_font_sm);
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				//TODO: creare un frame con le info descritte in 'CreaGioco' linea 80
			}
			
		});
	}
	
	public void setOther(String data, String desc, String autore, String numPly) {
		this.data = data;
		this.desc = desc;
		this.autore = autore;
		this.numMax = numPly.split("-")[2];
		this.numMin = numPly.split("-")[0];
	}

}