package gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.*;
import javax.swing.*;

public class SingIn extends Entry_System {
	
	private UsersData datas = new UsersData();
	
	SingIn(){
		super.setTitle("La Tana dei Goblin - Sing In");
		button.setText("Sing In");
		
		button.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				String Username = username.getText();
				String Password1 = Password.getText();
				boolean author = isAuthor.isSelected();
				author = false;

				try {
					if(!datas.getUserEsistente(Username, Password1, author)) {
						datas.newUser(Username, Password1, author);
						JOptionPane.showMessageDialog(null, "SUCCESS");
					}else
						JOptionPane.showMessageDialog(null, "Username or Password mismatch");
				}catch (HeadlessException e1){}
				catch (IOException e1) {e1.printStackTrace();}
			}
		});
		
		this.setVisible(true);
	}

}