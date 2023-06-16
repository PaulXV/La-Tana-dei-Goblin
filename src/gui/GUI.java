package gui;
import java.awt.*;
import javax.swing.*;
import model.*;

public class GUI extends JFrame{

	GUI(){
		this.setLayout(new BorderLayout());
		this.setTitle("La Tana dei Goblin"); //TODO
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		MenuGui m = new MenuGui();
		this.add( m, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}