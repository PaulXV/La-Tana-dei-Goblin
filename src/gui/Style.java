package gui;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;

public interface Style {
	Color text_color = new Color(224,224,224);
	Color background = new Color(51,102,0);
	Cursor pointer = new Cursor(12);
	Font btn_font_sm = new Font("Serif", Font.BOLD, 17);
	Font btn_font = new Font("Serif", Font.BOLD, 30);
	Font title_font = new Font("Serif", Font.BOLD, 60);
	Border border = BorderFactory.createLineBorder(Color.white);
	Color hover = new Color(44,132,0);
}