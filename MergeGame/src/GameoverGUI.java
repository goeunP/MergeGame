
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class GameoverGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel rankPane;
	ImageIcon backgroundImg;
	private JPanel rankingTitlePane;
	private JLabel rankingTitle;
	private JButton tryAgainBtn;
	private JButton btnScoreBoard;
	private JLabel lblOver;



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
		rankingTitlePane.setBounds(48, 66, 226, 134);
		rankPane.add(rankingTitlePane);
		rankingTitlePane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rankingTitle = new JLabel("GAME");
		rankingTitle.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 46));
		rankingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rankingTitlePane.add(rankingTitle);
		
		lblOver = new JLabel("OVER");
		lblOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblOver.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 46));
		rankingTitlePane.add(lblOver);
		
		tryAgainBtn = new JButton("Try Again");
		tryAgainBtn.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		tryAgainBtn.setBounds(77, 283, 172, 50);
		rankPane.add(tryAgainBtn);
		tryAgainBtn.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
//			       
				   Start frame3 = new Start();
                 setVisible(false); 
                 frame3.setVisible(true);
			    }
		});
		
		btnScoreBoard = new JButton("Score Board");
		btnScoreBoard.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		btnScoreBoard.setBounds(77, 366, 172, 50);
		rankPane.add(btnScoreBoard);
		btnScoreBoard.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
//			       
				   ScoreGUI frame3 = new ScoreGUI();
                setVisible(false); 
                frame3.setVisible(true);
			    }
		});
		
		new JLabel("New label");
	
		
	}
}