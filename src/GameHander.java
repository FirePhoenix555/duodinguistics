import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameHander extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    final int width = 100, height = 100; //may change later
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
        //will add stuff probably perchance
    }

    private void update(){
        //may add stuff perchance
    }
}
