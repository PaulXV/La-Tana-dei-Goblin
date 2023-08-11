package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Entry_System extends JFrame implements Style{

	protected JLabel password_text, label, dataNascita;
	protected JTextField username;
	protected MyBtn button, chooseDate;
	protected JPasswordField Password;
	protected boolean isAuthorChecked;
	protected JCheckBox isAuthor;
	
	Entry_System(){
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Style.background);
		panel.setLayout(new GridLayout(0,1));
		
		label = new JLabel("Username");
		label.setBounds(100, 8, 200, 20);
		label.setForeground(Style.text_color);
		panel.add(label);
		
		username = new JTextField();
		username.setBounds(100, 27, 200, 28);
		username.setBorder(null);
		panel.add(username);
		
		password_text = new JLabel("Password - min 3 caratteri");
		password_text.setBounds(100, 55, 200, 20);
		password_text.setForeground(Style.text_color);
		panel.add(password_text);
		
		Password = new JPasswordField();
		Password.setBounds(100, 75, 200, 28);
		Password.setBorder(null);
		panel.add(Password);
		
		isAuthor = new JCheckBox("Author", true);
		isAuthor.setVisible(true);
		isAuthor.setFocusable(false);
		isAuthor.setForeground(Style.text_color);
		isAuthor.setMnemonic(KeyEvent.VK_C);
		isAuthor.setBackground(Style.background);
		isAuthor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				isAuthorChecked = true;
				if (e.getStateChange() == ItemEvent.DESELECTED)
					isAuthorChecked = false;
			}
		});
		
		panel.add(isAuthor);
		
		dataNascita = new JLabel("Inserisci la tua data di nascita:");
		dataNascita.setBounds(100, 55, 200, 20);
		dataNascita.setForeground(Style.text_color);
		dataNascita.setBorder(null);
		dataNascita.setVisible(false);
		chooseDate = new MyBtn(" + ");
		chooseDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	dataNascita.setText("Data di nascita: " + new DatePick(Entry_System.this).Set_Picked_Date());
            }
        });
		chooseDate.setVisible(false);
		panel.add(dataNascita);
		panel.add(chooseDate);
		
		button = new MyBtn("Login");
		button.setBounds(100, 110, 90, 25);
		button.setFont(Style.btn_font_sm);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
	}
}