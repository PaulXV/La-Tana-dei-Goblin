package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Login extends Entry_System{

	Login(){
		this.setTitle("La Tana dei Goblin - Login");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password1 = Password.getText();

				//si dovrà cercare nel file se è già esistente la persona e la password è giusta
				if (Username.equals("section.io") && Password1.equals("123")) {
					JOptionPane.showMessageDialog(null, "Login Successful");
				}else {
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
				}
			}
		});
		
		this.setVisible(true);
	}
}