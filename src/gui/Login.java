package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.*;
import javax.swing.*;

public class Login extends Entry_System{
	
	private UsersData datas = new UsersData();
	private JPanel panel = new JPanel();
	
	Login(){
		
		super.setTitle("La Tana dei Goblin - Login");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password1 = Password.getText();
				boolean author = isAuthor.isSelected();
				
				try {
					if(datas.getUserEsistente(Username, Password1, author)) {
						JOptionPane.showMessageDialog(null, "Login Successful");
						done();
					}else
						JOptionPane.showOptionDialog(null, "Failed: try other credentials or Singing in.", "Login Issue", 2, 2, null, null, null);
						
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	public void setPanel(JPanel panel) {this.panel = panel;}
	
	public void done() throws IOException{
		
		this.dispose();
		panel.setVisible(false);
		if(isAuthor.isSelected()) {
			Author a = new Author(panel, username.getText(), (JFrame) this.getFrames()[0]);
		}else {
			Player p = new Player(panel, username.getText(), (JFrame) this.getFrames()[0]);
		}
	}
}