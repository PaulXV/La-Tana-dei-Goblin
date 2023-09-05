package gui;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{

	public GUI(){
		this.setLayout(new BorderLayout());
		this.setTitle("La Tana dei Goblin");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MenuGui m = new MenuGui();
		this.add(m, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
}