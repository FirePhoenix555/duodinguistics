import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.swing.JPanel;


public class GameHander extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    final int width = 800, height = 450; //may change later
	final int fps = 30; // how often the game updates

     Thread gameThread;

    /* 
     * KeyHandler kh = new KeyHandler();
     * SoundManager sm = new SoundManager();
     */

     public GameHander(){
        setPreferredSize(new Dimension(width, height));
        //addKeyListener(kh);
        setFocusable(true);

        initialize();

        gameThread = new Thread(this); //apparently for looping
		gameThread.start();//I dont know what's going on
     }

    public void initialize() {
		this.setBackground(Color.black);
	}//initialize

    @Override
    public void run(){
        double loopInterval = 1000000000/fps;
		double nextLoopTime = System.nanoTime() + loopInterval;
		
		while (gameThread != null) {
			update();
			repaint();
			
			try {
				double remainingTime = (nextLoopTime - System.nanoTime())/1000000;
				if (remainingTime < 0) remainingTime = 0;
				Thread.sleep((long) remainingTime);
				nextLoopTime += loopInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }

    private void update(){
        //may add stuff perchance
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        String fontPath = "./assets/fonts/Dogtown Typewriter.ttf";
        
        try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontPath)).deriveFont(14f);
	        g.setFont(font);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        g.setColor(Color.white);
        g.drawString("hehe", 75, 75);
    }
}
