package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Entry_System extends JFrame{

	protected static JLabel password_text, label;
	protected static JTextField username;
	protected static JButton button;
	protected static JPasswordField Password;
	
	private Color text_color = new Color(224,224,224);
	private Color background = new Color(51,102,0);
	private Cursor pointer = new Cursor(12);
	private Font btn_font = new Font("Serif", Font.BOLD, 17);
	private Font title_font = new Font("Serif", Font.BOLD, 60);
	private Border border = BorderFactory.createLineBorder(Color.white);
	
	Entry_System(){
		this.setLayout(new BorderLayout());
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setLayout(null);
		
		label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		label.setForeground(text_color);
		panel.add(label);
		
		username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		panel.add(username);
		
		password_text = new JLabel("Password");
		password_text.setBounds(100, 55, 70, 20);
		password_text.setForeground(text_color);
		panel.add(password_text);
		
		Password = new JPasswordField();
		Password.setBounds(100, 75, 193, 28);
		panel.add(Password);
		
		button = new JButton("Login");
		button.setBounds(100, 110, 90, 25);
		button.setForeground(text_color);
		button.setBackground(background);
		button.setFont(btn_font);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password1 = Password.getText();

				if (Username.equals("section.io") && Password1.equals("123"))
					JOptionPane.showMessageDialog(null, "Login Successful");
				else
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
			}
		});
		
		button.setBorder(border);
		button.setCursor(pointer);
		button.setRolloverEnabled(true);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
	}
}