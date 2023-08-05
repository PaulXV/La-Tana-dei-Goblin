package gui;

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

				try {
					if(!datas.isUserLogged(Username, Password1, author)) {
						datas.newUser(Username, Password1, author);
						if(author) {
							Autore autore = new Autore(username.getText(), "", "");
						}
						
						JOptionPane.showMessageDialog(null, "SUCCESS");
					}else
						JOptionPane.showMessageDialog(null, "Failed: try other credentials or Logging in.");
				}catch (HeadlessException e1){}
				catch (IOException e1) {e1.printStackTrace();}
			}
		});
		
		this.setVisible(true);
	}

}