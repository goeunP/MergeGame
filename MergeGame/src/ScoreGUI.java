
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ScoreGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel titlePane;
	ImageIcon backgroundImg;
	private JLabel lblNewLabel;
	private JPanel rankingTitlePane;
	private JLabel rankingTitle;
	private JPanel scorePanel;
	private JLabel scoreMentLabel;
	private JLabel mentLabel;
	public int score = 0;
	private JLabel scoreLabel;
	private JButton btnTryAgain;

	/**
	 * Create the frame.
	 */
	public ScoreGUI() {
		setTitle("Score");
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
		
		rankingTitle = new JLabel("Score");
		rankingTitle.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 35));
		rankingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rankingTitlePane.add(rankingTitle);
		
		scorePanel = new JPanel();
		scorePanel.setBackground(Color.WHITE);
		scorePanel.setBounds(22, 91, 272, 352);
		titlePane.add(scorePanel);
		scorePanel.setLayout(null);
		
		//rankPane.setViewportView(lblNewLabel);
		//loadScore();


		JLabel imgLabel = new JLabel();
        imgLabel.setBounds(137, 189, 117, 141); // 이미지의 위치와 크기 설정

        ImageIcon icon = new ImageIcon(
            ScoreGUI.class.getResource("/image/farmer.png")
        );

        Image img = icon.getImage();
        Image updateImg = img.getScaledInstance(250, 210, Image.SCALE_SMOOTH);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        imgLabel.setIcon(updateIcon); // 오류를 수정하기 위해 이 부분을 아래로 이동합니다.

        scorePanel.add(imgLabel);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        
        scoreMentLabel = new JLabel("Your score is");
        scoreMentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        scoreMentLabel.setBounds(21, 28, 173, 16);
        scorePanel.add(scoreMentLabel);
        
        mentLabel = new JLabel("Did you get the fruit basket?");
        mentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        mentLabel.setBounds(20, 147, 264, 31);
        scorePanel.add(mentLabel);
        
        scoreLabel = new JLabel("0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 67));
        scoreLabel.setBounds(31, 73, 223, 51);
        scorePanel.add(scoreLabel);
        System.out.println(score);
        scoreLabel.setText(readScoreFromFile()+"");
       
        
        btnTryAgain = new JButton("Try Again");
        btnTryAgain.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 16));
        btnTryAgain.setBounds(21, 231, 117, 51);

		btnTryAgain.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
//			       
				   Start frame3 = new Start();
                 setVisible(false); 
                 frame3.setVisible(true);
			    }
		});
        scorePanel.add(btnTryAgain);
       
        setVisible(true);
	}
	
	private int readScoreFromFile() {
        String fileName = "./score.txt"; // 파일명 설정
        

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // 파일에서 한 줄을 읽어옴 (score: 숫자)
            String line = bufferedReader.readLine();

            // "score: " 이후의 숫자 부분을 추출하여 int로 변환
            if (line != null && line.startsWith("score: ")) {
                String scoreString = line.substring(7); // "score: " 이후 문자열 추출
                score = Integer.parseInt(scoreString); // 문자열을 int로 변환하여 저장
            }

            bufferedReader.close(); // 파일 닫기
        } catch (IOException e) {
            e.printStackTrace();
        }

        return score;
    }
	
	private int loadScore() {
        int loadedScore = readScoreFromFile();
        // 읽어온 점수를 변수에 저장
        return loadedScore;
    }

}