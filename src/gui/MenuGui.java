package gui;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MenuGui extends JPanel implements Style{
	
	MenuGui(){
		
		this.setBackground(Style.background);
		this.setLayout(new GridLayout(0,1));
		
		JLabel title = new JLabel("La Tana dei Goblin");
		title.setFont(Style.title_font);
		title.setForeground(Style.text_color);
		title.setHorizontalAlignment(0);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Style.background);
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
		
		//this.remove <-- da usare una volta fatto il login per fa vedere se autore una cosa, se giocatore un'altra
	}
	
	private JPanel returnThisPanel() {return this;}
	
	private void styleBtn(JButton btn) {
		btn.setFont(Style.btn_font);
		btn.setFocusable(false);
		btn.setBorderPainted(true);
		btn.setBorder(Style.border);
		btn.setBackground(Style.background);
		btn.setForeground(Style.text_color);
		btn.setMargin( new Insets(3,3,6,6) );
		btn.setCursor(Style.pointer);
		btn.setRolloverEnabled(true);
		
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btn.setBackground(Style.hover);
				btn.setForeground(Color.white);
			}
			
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn.setBackground(Style.background);
				btn.setForeground(Style.text_color);
			}
			
			//dopo l'accesso devi far vedere o schermata autori o schermata giocatori
			public void mouseClicked(MouseEvent e) {
				if(btn.getText().equals("  LOGIN  ")) {
					Login l = new Login();
					l.setPanel(returnThisPanel());
				}
				else if(btn.getText().equals(" SING IN ")) {
					SingIn s = new SingIn();
				}
			}
			
		});
	}
	
}