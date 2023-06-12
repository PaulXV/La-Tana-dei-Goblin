package gui;
import java.awt.*;
import javax.swing.*;
import model.*;

public class GUI extends JFrame{

	GUI(){
		this.setBackground(new Color(228,228,228));
		this.setLayout(new BorderLayout());
		this.setTitle("La Tana dei Goblin"); //TODO	
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setVisible(true);
	}
}