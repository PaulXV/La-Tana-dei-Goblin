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
				
				if(!Username.isEmpty()) {
					try {
						if(!datas.getUserEsistente(Username, Password1, author)) {
							datas.newUser(Username, Password1, author);
							
							JOptionPane.showMessageDialog(null, "SUCCESS");
							SingIn.this.dispose();
						}else
							JOptionPane.showOptionDialog(null, "Failed: try other credentials or Singing in.", "SingIn Issue", 2, 2, null, null, null);
						
					}catch (HeadlessException e1){}
					catch (IOException e1) {e1.printStackTrace();}
				}else
					JOptionPane.showOptionDialog(null, "Failed: try other credentials or Singing in.", "SingIn Issue", 2, 2, null, null, null);
			}
		});
		
		this.setVisible(true);
	}

}