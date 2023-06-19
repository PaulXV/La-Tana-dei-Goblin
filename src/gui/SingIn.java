package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SingIn extends Entry_System {
	
	SingIn(){
		this.setTitle("La Tana dei Goblin - Sing In");
		button.setText("Sing In");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password1 = Password.getText();

				//qui si dovrà mettere in un file il nome e password con anche il check se autore o giocatore (+ controllare se è gia stato inserito)
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