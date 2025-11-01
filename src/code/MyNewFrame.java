package code;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class MyNewFrame {
	JFrame frame;

	MyNewFrame() {
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/flashcartlogo.png"));
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
	int	answer=JOptionPane.showConfirmDialog(null,"Do you want to continue?","FLASHCARDS",JOptionPane.YES_NO_OPTION);
		System.out.println(answer);
		if(answer==0) {
			new NewWindow();
		}

	}

}
