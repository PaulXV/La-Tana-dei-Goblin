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
		
		MyBtn login = new MyBtn("  LOGIN  ");
		MyBtn singIn = new MyBtn(" SING IN ");
		
		FlowLayout flow = new FlowLayout(0,510,35);
		buttonPanel.setLayout(flow);
		
		styleBtn(login);
		styleBtn(singIn);
		buttonPanel.add(login);
		buttonPanel.add(singIn);
		
		this.add(title);
		this.add(buttonPanel);
	}
	
	private JPanel returnThisPanel() {return this;}
	
	private void styleBtn(JButton btn) {
		btn.setFont(Style.btn_font);
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
			
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