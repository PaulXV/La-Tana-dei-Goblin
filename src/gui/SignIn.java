package gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.*;
import javax.swing.*;

public class SignIn extends Entry_System {
	
	private UsersData datas = new UsersData();
	
	SignIn(){
		super.setTitle("La Tana dei Goblin - Sing In");
		super.setSize(400,300);
		super.dataNascita.setVisible(true);
		super.chooseDate.setVisible(true);
		
		button.setText("Sing In");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String Username = username.getText();
				String password = "";
				for(char c : Password.getPassword() ){
					password += c;
				}
				boolean author = isAuthor.isSelected();
				
				if(!Username.isEmpty()) {
					try {
						if(!datas.getUserEsistente(Username, password, author)) {
							datas.newUser(Username, password, author, dataNascita.getText().split(": ")[1]);
							
							JOptionPane.showMessageDialog(null, "SUCCESS");
							SignIn.this.dispose();
						}else
							JOptionPane.showOptionDialog(null, "Failed: try other credentials or Singing in.", "SingIn Issue", 2, 2, null, null, null);
						
					}catch (HeadlessException e1){}
					catch (IOException e1) {e1.printStackTrace();}
				}else
					JOptionPane.showOptionDialog(null, "Failed: try other credentials or Log in.", "SingIn Issue", 2, 2, null, null, null);
			}
		});
		
		this.setVisible(true);
	}

}