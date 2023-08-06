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
				JFrame info = new JFrame();
				info.setBackground(Style.background);
				info.setLayout(new BorderLayout());
				info.setSize(400, 400);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				info.setTitle(title);
				
				JLabel titolo = new JLabel(title);
				titolo.setFont(Style.title_font_sm);
				titolo.setForeground(Style.text_color);
				titolo.setHorizontalAlignment(0);
				titolo.setBackground(Style.background);
				
				info.add(titolo, BorderLayout.NORTH);
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