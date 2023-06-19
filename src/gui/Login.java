package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.*;
import javax.swing.*;

public class Login extends Entry_System{
	
	private UsersData datas = new UsersData();
	
	Login(){
		super.setTitle("La Tana dei Goblin - Login");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password1 = Password.getText();
				boolean author = isAuthor.isSelected();
				author = false;
				
				try {
					if(datas.getUserEsistente(Username, Password1, author))
						JOptionPane.showMessageDialog(null, "Login Successful");
					else
						JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		this.setVisible(true);
	}
}