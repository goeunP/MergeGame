
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


public class GameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel gamePane;
	ImageIcon backgroundImg;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public GameGUI() {
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		gamePane = new JPanel() {
			 private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	             
	                Dimension d = getSize();
	                g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
	            
	                setOpaque(false); 
	                super.paintComponent(g);
	            }
		};
		contentPane.add(gamePane);
		StrawberryTile StrawberryTile = new StrawberryTile();
//	      JLabel strlabel = new JLabel(StrawberryTile.getImageIcon());
//	       gamePane.add(strlabel);
		gamePane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 156, 306, 282);
		gamePane.add(panel);
		
		lblNewLabel = new JLabel(StrawberryTile.getImageIcon());
		panel.add(lblNewLabel);
	
		
	}
}
