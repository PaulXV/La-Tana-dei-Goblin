package gui;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

public class MenuGui extends JPanel{
	
	private Border border = BorderFactory.createLineBorder(Color.white);
	private Color text_color = new Color(224,224,224);
	private Color hover = new Color(44,132,0);
	private Color background = new Color(51,102,0);
	private Cursor pointer = new Cursor(12);
	private Font btn_font = new Font("Serif", Font.BOLD, 30);
	private Font title_font = new Font("Serif", Font.BOLD, 60);
	
	MenuGui(){
		this.setBackground(new Color(51, 102, 0));
		this.setLayout(new GridLayout(0,1));
		
		
		JLabel title = new JLabel("La Tana dei Goblin");
		title.setFont(title_font);
		title.setForeground(text_color);
		title.setHorizontalAlignment(0);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(background);
		buttonPanel.setAlignmentY(0);
		buttonPanel.setAlignmentX(0);
		
		JButton login = new JButton("  LOGIN  ");
		JButton singIn = new JButton(" SING IN ");
		
		FlowLayout flow = new FlowLayout(0,510,35);
		buttonPanel.setLayout(flow);
		
		styleBtn(login);
		styleBtn(singIn);
		buttonPanel.add(login);
		buttonPanel.add(singIn);
		
		this.add(title);
		this.add(buttonPanel);
	}
	
	private void styleBtn(JButton btn) {
		btn.setFont(btn_font);
		btn.setFocusable(false);
		btn.setBorderPainted(true);
		btn.setBorder(border);
		btn.setBackground(background);
		btn.setForeground(text_color);
		btn.setMargin( new Insets(3,3,6,6) );
		btn.setCursor(pointer);
		btn.setRolloverEnabled(true);
		
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {mouseClicked(e);}
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btn.setBackground(hover);
				btn.setForeground(Color.white);
			}
			
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn.setBackground(background);
				btn.setForeground(text_color);
			}
			
			//dopo l'accesso devi far vedere o schermata autori o schermata giocatori
			public void mouseClicked(MouseEvent e) {
				if(btn.getText().equals("  LOGIN  ")) {
					//TODO: quando click su login fare schermata di login nel portale
				}
				else if(btn.getText().equals(" SING IN ")) {
					//TODO: quando click su singin fare schermata di singin nel portale;
				}
			}
			
		});
	}
	
}