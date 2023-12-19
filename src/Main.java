
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        JFrame window = new JFrame("Game");
		
		GameHander gh = new GameHander();
		window.add(gh);
		
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
    }
}