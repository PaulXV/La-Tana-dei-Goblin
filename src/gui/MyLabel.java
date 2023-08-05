package gui;
import java.awt.event.*;
import javax.swing.*;

public class MyLabel extends JLabel implements Style{

	private String title;
	private String data;
	private String desc;
	private String autore;
	private String numMax;
	private String numMin;
	
	MyLabel(String title) {
		this.title = title;
		this.setFont(Style.title_font_sm);
		this.setBorder(Style.border);
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		this.setText(title);
		
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				MyLabel.this.setBackground(Style.background);
				JFrame info = new JFrame();
				info.setSize(400, 400);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				info.setTitle(title);
				JPanel panel = new JPanel();
				panel.setBackground(Style.background);
			}
			
		});
	}
	
	public String toString() {
		return title + ")" + data + ")" + desc + ")" + autore + ")"
				+ numMax + ")" + numMin;
	}

	public void setOther(String data, String desc, String autore, String numPly) {
		this.data = data;
		this.desc = desc;
		this.autore = autore;
		this.numMax = numPly.split("-")[1];
		this.numMin = numPly.split("-")[0];
	}
	
}