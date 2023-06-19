package gui;

import java.awt.event.*;
import javax.swing.*;

public class Entry_System extends JFrame implements Style{

	protected static JLabel password_text, label;
	protected static JTextField username;
	protected static JButton button;
	protected static JPasswordField Password;
	protected boolean isAuthorChecked;
	
	Entry_System(){
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Style.background);
		panel.setLayout(null);
		
		label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		label.setForeground(Style.text_color);
		panel.add(label);
		
		username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		panel.add(username);
		
		password_text = new JLabel("Password");
		password_text.setBounds(100, 55, 70, 20);
		password_text.setForeground(Style.text_color);
		panel.add(password_text);
		
		Password = new JPasswordField();
		Password.setBounds(100, 75, 193, 28);
		panel.add(Password);
		
		JCheckBox isAuthor = new JCheckBox("Author");
		isAuthor.setMnemonic(KeyEvent.VK_C); 
		isAuthor.setSelected(true);
		isAuthor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				isAuthorChecked = true;
				if (e.getStateChange() == ItemEvent.DESELECTED)
					isAuthorChecked = false;
			}
		});
		panel.add(isAuthor);
		
		button = new JButton("Login");
		button.setFocusable(false);
		button.setBounds(100, 110, 90, 25);
		button.setForeground(Style.text_color);
		button.setBackground(Style.background);
		button.setFont(Style.btn_font_sm);
		
		button.setBorder(Style.border);
		button.setCursor(Style.pointer);
		button.setRolloverEnabled(true);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
	}
}