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
     }
}
