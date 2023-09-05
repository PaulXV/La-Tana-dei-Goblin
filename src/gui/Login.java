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
		
		super.setTitle("Login");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String password = "";
				for(char c : Password.getPassword() ){
					password += c;
				}
				boolean author = isAuthor.isSelected();

				try {
					if(datas.getUserEsistente(Username, password, author)) {
						JOptionPane.showMessageDialog(null, "Login Successful");
						done( password );
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
	
	public void done(String password) throws IOException{
		
		this.dispose();
		panel.setVisible(false);
		JFrame frame = (JFrame) Login.getFrames()[0];

		if(isAuthor.isSelected()) {
			Author a = new Author(panel, username.getText(), frame);
			a.setFrame(frame);
		}else {
			Player p = new Player( panel, username.getText(),
					datas.getBirthdate(username.getText(), password), frame );
					p.setFrame(frame);
		}
	}
}