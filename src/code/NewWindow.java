package code;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class NewWindow {
	int score = 0;
	int count = 0;
	int answ = 0;
	int maxL;
	JFrame frame;
	StringBuilder sb = new StringBuilder();
	JTextArea textArea = new JTextArea();
	String responses[] = { "EVET!", "HAYIR", "BİLMİYORUM" };

	NewWindow() {
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/flashcartlogo.png"));
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		textArea.setFont(new Font("Broadway", Font.BOLD, 20));
		frame.add(textArea);
		textArea.setBackground(new Color(0xd1d1d1));
		textArea.setForeground(new Color(0x3e3e3e));
		frame.setVisible(false);
		frame.setTitle("Questions and Answers");
		try {
			InputStream input = getClass().getResourceAsStream("/file/flashcards.txt");
			if (input == null)
				throw new FileNotFoundException();
			Scanner file = new Scanner(input);
			while (file.hasNextLine()) {
				count++;
				String q = file.nextLine();
				int answer = JOptionPane.showOptionDialog(null, q, "question", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, responses, 0);
				String qa = file.nextLine();
				if (qa.equalsIgnoreCase("true"))
					answ = 0;
				else
					answ = 1;
				if(q.length()>=maxL) maxL=q.length();
				if (answer == answ) {
					score++;
					sb.append(q + "'s answer is: " + qa + "\n");
				} else {
					sb.append(q + "'s answer is: " + qa +" you made a mistake!"+ "\n");
				}
			}
			textArea.setText(sb + "Score is: " + score + " out of " + count);
			textArea.setEditable(false);
			file.close();
			frame.setSize(maxL * 15, count * 40);
			frame.setLocation(360, 270);
			System.out.println(maxL);
			frame.setVisible(true);
			System.out.println("Your score is " + score + " out of " + count);
		} catch (FileNotFoundException e1) {
			System.out.println("File cannot be founded. " + e1.getMessage());
			frame.setVisible(true);
			frame.setSize(100, 100);
			textArea.setText("File Not Found");
			frame.add(textArea);
		}

	}
}
