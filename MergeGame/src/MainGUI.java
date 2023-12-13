import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel startPane;
	ImageIcon backgroundImg;
	private JLabel title;
	private JButton rankingBtn;
	private JButton startBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("My Fruits Basket");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		startPane = new JPanel() {
			 public void paintComponent(Graphics g) {
	             
	                Dimension d = getSize();
	                g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
	            
	                setOpaque(false); 
	                super.paintComponent(g);
	            }
		};
		contentPane.add(startPane);
		GridBagLayout gbl_startPane = new GridBagLayout();
		gbl_startPane.columnWidths = new int[]{57, 204, -58, 0};
		gbl_startPane.rowHeights = new int[]{26, 154, 0, 57, 0, 0, 0};
		gbl_startPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_startPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		startPane.setLayout(gbl_startPane);
		
		title = new JLabel("");
		//Dimension titleSize = title.getPreferredSize();
		
		  ImageIcon originalTitleImgIcon = new ImageIcon(MainGUI.class.getResource("/image/titleImg.png"));
	        // Get the preferred size of the title label
	        Dimension titleSize = new Dimension(200, 200); // Set the desired size
	        // Resize the image to fit the size of the title label
	        Image originalTitleImg = originalTitleImgIcon.getImage();
	        Image resizedTitleImg = originalTitleImg.getScaledInstance(titleSize.width, titleSize.height, Image.SCALE_SMOOTH);
	        ImageIcon resizedTitleImgIcon = new ImageIcon(resizedTitleImg);
	        title.setIcon(resizedTitleImgIcon);
//	        
//		ImageIcon titleImg = new ImageIcon(new ImageIcon(MainGUI.class.getResource("/image/titleImg.png")).getImage().getScaledInstance(titleSize.width, titleSize.height, Image.SCALE_SMOOTH));
//	    title.setIcon(new ImageIcon(MainGUI.class.getResource("/image/titleImg.png")));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 1;
		gbc_title.gridy = 1;
		startPane.add(title, gbc_title);
		Dimension startBtnSize = new Dimension(150, 50);
		Dimension rankingBtnSize = new Dimension(150, 50);
		
		startBtn = new JButton("Game Start");
		startBtn.setFont(new Font("October Tamil", Font.BOLD, 20));
		startBtn.setPreferredSize(startBtnSize);
		
		startBtn.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
//			        new RegisterGUI();
			        
			       
			        RegisterGUI frame2 = new RegisterGUI();
			        setVisible(false); // 창 안보이게 하기 
					frame2.setVisible(true);
			    }
		});
		GridBagConstraints gbc_startBtn = new GridBagConstraints();
		gbc_startBtn.insets = new Insets(0, 0, 5, 5);
		gbc_startBtn.gridx = 1;
		gbc_startBtn.gridy = 4;
		startPane.add(startBtn, gbc_startBtn);
		
		rankingBtn = new JButton("Ranking");
		rankingBtn.setFont(new Font("October Condensed Tamil", Font.BOLD, 20));
		rankingBtn.setPreferredSize(rankingBtnSize);
		GridBagConstraints gbc_rankingBtn = new GridBagConstraints();
		gbc_rankingBtn.insets = new Insets(0, 0, 0, 5);
		gbc_rankingBtn.gridx = 1;
		gbc_rankingBtn.gridy = 5;
		startPane.add(rankingBtn, gbc_rankingBtn);
	}

}
