import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class GameHander extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    final int width = 800, height = 450; //may change later
	final int fps = 30; // how often the game updates
    private Typewriter typewriter = new Typewriter("hellaur");
    private int frameCount = 0;

    Thread gameThread;

    private JTextField t;

    /* 
     * KeyHandler kh = new KeyHandler();
     * SoundManager sm = new SoundManager();
     */

    Font font;

    public GameHander(JTextField t_){
        setPreferredSize(new Dimension(width, height));
        //addKeyListener(kh);
        setFocusable(true);

        t = t_;

        initialize();

        gameThread = new Thread(this); //apparently for looping
        gameThread.start();//I dont know what's going on
    }

    public void initialize() {
		this.setBackground(Color.black);

        try {
            font = FontLoader.loadFont("./assets/fonts/Dogtown Typewriter.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // setting style for text field
        t.setFont(font.deriveFont(16f));
        t.setBackground(Color.DARK_GRAY);
        t.setForeground(Color.WHITE);
        t.setCaretColor(Color.WHITE);
        t.setBorder(new LineBorder(Color.DARK_GRAY,5));
        t.setPreferredSize(new Dimension(width,height / 13));
        
        t.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        			String placeholder = t.getText();
        			System.out.println(placeholder);
        			t.setText("");
        		} //if statement
        	} //keyPressed
        }); //addKeyListener
        
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
        if(frameCount%5 == 0) typewriter.pulse();//may add stuff perchance
        frameCount++;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (font != null) {
            Font f = font.deriveFont(14f);
            g.setFont(f);
        }
        
        g.setColor(Color.white);
        g.drawString(typewriter.getString(), 75, 75); //figure out how to throw in a typewriter here
    }
}
