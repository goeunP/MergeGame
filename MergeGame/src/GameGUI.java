
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.Icon;
import java.awt.Color;


public class GameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel gamePane;
	ImageIcon backgroundImg;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

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
		StrawberryTile strawberry= new StrawberryTile();
		KiwiTile kiwi=new KiwiTile();
		GrapeTile grape =new GrapeTile();
		OrangeTile orange = new OrangeTile();
		AppleTile apple = new AppleTile();
		BasketTile basket= new BasketTile();
		WatermelonTile watermelon = new WatermelonTile();
		
//	      JLabel strlabel = new JLabel(StrawberryTile.getImageIcon());
//	       gamePane.add(strlabel);
		gamePane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 156, 306, 282);
		gamePane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 1, 1));
		
//		lblNewLabel_3 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_3);
//		
//		lblNewLabel_2 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_2);
//		
//		lblNewLabel_1 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_1);
//		
//		lblNewLabel_6 = new JLabel((Icon) null);
//		lblNewLabel_6.setBackground(new Color(255, 255, 255));
//		panel.add(lblNewLabel_6);
//		
//		lblNewLabel_7 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_7);
//		
//		lblNewLabel_5 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_5);
//		
//		lblNewLabel_4 = new JLabel((Icon) null);
//		panel.add(lblNewLabel_4);
		
		lblNewLabel = new JLabel(strawberry.getScaledImage());
		lblNewLabel_1 = new JLabel(watermelon.getScaledImage());
		lblNewLabel_2 = new JLabel(basket.getScaledImage());
		lblNewLabel_3 = new JLabel(grape.getScaledImage());
		lblNewLabel_4 = new JLabel(orange.getScaledImage());
		lblNewLabel_5 = new JLabel(apple.getScaledImage());
		lblNewLabel_6 = new JLabel(kiwi.getScaledImage());
		lblNewLabel_7 = new JLabel(kiwi.getScaledImage());
	
		panel.add(lblNewLabel);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_2);
		panel.add(lblNewLabel_3);
		panel.add(lblNewLabel_4);
		panel.add(lblNewLabel_5);
		panel.add(lblNewLabel_6);
		panel.add(lblNewLabel_7);
		
	}
}
