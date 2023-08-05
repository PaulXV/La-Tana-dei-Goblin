package gui;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.*;

public class MyBtn extends JButton {
	
	MyBtn(String title){
		this.setText(title);
		this.setFocusable(false);
		this.setBorderPainted(true);
		this.setBorder(Style.border);
		this.setBackground(Style.background);
		this.setForeground(Style.text_color);
		this.setMargin( new Insets(3,3,6,6) );
		this.setCursor(Style.pointer);
		this.setRolloverEnabled(true);
		
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				setBackground(Style.hover);
				setForeground(Color.white);
			}
			
			public void mouseExited(java.awt.event.MouseEvent e) {
				setBackground(Style.background);
				setForeground(Style.text_color);
			}
		});
	}
	
}