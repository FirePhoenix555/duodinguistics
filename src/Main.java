
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        JFrame window = new JFrame("Game");
		
		GameHander gh = new GameHander();
		//window.add(gh);
		
		//panel
		JPanel p = new JPanel(new BorderLayout());
		
		//text input
		JTextField t = new JTextField("", 16);
		p.add(t, BorderLayout.SOUTH);
		p.add(gh);
		window.add(p);
		
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
    }
}