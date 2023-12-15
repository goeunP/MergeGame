
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, Runnable {

	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 328;
	public static final int HEIGHT = 501;
	public static final Font main = new Font(".AppleSystemUIFont", Font.PLAIN,28);
	private Thread game;
	private boolean running;
	private BufferedImage Image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private GameGUI board;
	
	ImageIcon backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));

	
	public Game() {
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		board = new GameGUI(WIDTH/2 - GameGUI.BOARD_WIDTH/2, HEIGHT - GameGUI.BOARD_HEIGHT - 10);
	}
	
	private void update() {
		board.update();
		Keyboard.update();
	}
	
	private void render() {
		Graphics2D g = (Graphics2D) Image.getGraphics();
		   Dimension d = getSize();
           g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
       
           setOpaque(false); 

		board.render(g);
		g.dispose();
		
		Graphics g2d = (Graphics2D) getGraphics();
		g2d.drawImage(Image, 0, 0, null);
		g.dispose();
	}
	
	public void run() {
	    while (running) {
	        update();
	        render();
	        try {
	            Thread.sleep(1);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	public synchronized void start() {
		if(running) return;
		running = true;
		game = new Thread(this,"game");
		game.start();
	}
	public synchronized void stop() {
		if(running) return;
		running = false;
		System.exit(0);
		
	}
	
	public void keyPressed(KeyEvent e) {
		Keyboard.keyPressed(e);
		
		
	}
	public void keyReleased(KeyEvent e) {
		Keyboard.keyReleased(e);
	}
	public void keyTyped(KeyEvent e) {
		
	}
	
	 public boolean getGUIDead() {
	        return board.getDead();
	   }
	
}