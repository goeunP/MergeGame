
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;


public class GameoverGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel rankPane;
	ImageIcon backgroundImg;
	private JLabel lblNewLabel;
	private JPanel rankingTitlePane;
	private JLabel rankingTitle;



	/**
	 * Create the frame.
	 */
	public GameoverGUI() {
		setTitle("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		contentPane.setLayout(null);
		rankPane = new JPanel() {
			 private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	             
	                Dimension d = getSize();
	                g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
	            
	                setOpaque(false); 
	                super.paintComponent(g);
	            }
		};
		rankPane.setBounds(5, 5, 318, 463);
		contentPane.add(rankPane);
		rankPane.setLayout(null);
		
		rankingTitlePane = new JPanel();
		rankingTitlePane.setBackground(Color.WHITE);
		rankingTitlePane.setBounds(45, 24, 222, 55);
		rankPane.add(rankingTitlePane);
		rankingTitlePane.setLayout(new BorderLayout(0, 0));
		
		rankingTitle = new JLabel("Ranking");
		rankingTitle.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 35));
		rankingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rankingTitlePane.add(rankingTitle);
		
		lblNewLabel = new JLabel("New label");
		//rankPane.setViewportView(lblNewLabel);
	
		
	}
}