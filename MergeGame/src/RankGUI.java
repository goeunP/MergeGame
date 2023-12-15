
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RankGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel titlePane;
	ImageIcon backgroundImg;
	private JPanel rankingTitlePane;
	private JLabel rankingTitle;
	private JPanel scorePanel;
	public String score = "";
	public String scoreList="";
	private JLabel scoreLabel;
	private JButton btnTryAgain;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public RankGUI() {
		setTitle("Rank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		contentPane.setLayout(null);
		titlePane = new JPanel() {
			 private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	             
	                Dimension d = getSize();
	                g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
	            
	                setOpaque(false); 
	                super.paintComponent(g);
	            }
		};
		titlePane.setBounds(5, 5, 318, 463);
		contentPane.add(titlePane);
		titlePane.setLayout(null);
		
		rankingTitlePane = new JPanel();
		rankingTitlePane.setBackground(Color.WHITE);
		rankingTitlePane.setBounds(45, 24, 222, 55);
		titlePane.add(rankingTitlePane);
		rankingTitlePane.setLayout(new BorderLayout(0, 0));
		
		rankingTitle = new JLabel("Rank");
		rankingTitle.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 35));
		rankingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rankingTitlePane.add(rankingTitle);
		
		scorePanel = new JPanel();
		scorePanel.setBackground(Color.WHITE);
		scorePanel.setBounds(22, 91, 272, 352);
		titlePane.add(scorePanel);
		scorePanel.setLayout(null);

 
        scoreLabel = new JLabel("0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 31));
        scoreLabel.setBounds(69, 70, 127, 213);
        scorePanel.add(scoreLabel);
        scoreList=readScoreFromFile();
        scoreLabel.setText("<html>" + scoreList + "</html>");
       
     
        btnTryAgain = new JButton("Main");
        btnTryAgain.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 16));
        btnTryAgain.setBounds(73, 295, 117, 51);

		btnTryAgain.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {			       
				   MainGUI frame3 = new MainGUI();
                 setVisible(false); 
                 frame3.setVisible(true);
			    }
		});
        scorePanel.add(btnTryAgain);
        
        lblNewLabel = new JLabel("Your recent 5 game scores ...");
        lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(25, 30, 225, 28);
        scorePanel.add(lblNewLabel);
       
        setVisible(true);
	}
	
	 private String readScoreFromFile() {
	        String fileName = "./score.txt";
	        try {
	            FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            LinkedList<String> recentScoreLines = new LinkedList<>();
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                recentScoreLines.addFirst(line);
	                if (recentScoreLines.size() > 5) {
	                    recentScoreLines.removeLast();
	                }
	            }
	            bufferedReader.close();
	            for (int i=0; i<5; i++) {
	            	scoreList+=(i+1+" : "+recentScoreLines.get(i)+"\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	        return scoreList;
	    }
}
