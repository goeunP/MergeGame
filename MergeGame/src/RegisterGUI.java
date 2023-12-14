import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.util.Date;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel registerPane;
	ImageIcon backgroundImg;
	private JPanel titlePane;
	private JLabel titleLabel;
	private JPanel namePane;
	private JButton registerBtn;
	private JPanel datePane;
	private JTextField nameField;
	private JTextField dateField;
	private JLabel nameLabel;
	private JLabel dateLabel;


	/**
	 * exception 처리 !!!!!!!!!!!!!!!!
	 */
	public RegisterGUI() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		registerPane = new JPanel() {
			 private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	             
	                Dimension d = getSize();
	                g.drawImage(backgroundImg.getImage(), 0, 0, d.width, d.height, null);
	            
	                setOpaque(false); 
	                super.paintComponent(g);
	            }
		};
		contentPane.add(registerPane);
		registerPane.setLayout(null);
		
		titlePane = new JPanel();
		titlePane.setBounds(31, 49, 256, 60);
		titlePane.setBackground(Color.WHITE);
		registerPane.add(titlePane);
		titlePane.setLayout(new BorderLayout(0, 0));
		
		titleLabel = new JLabel("Register");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 35));
		titlePane.add(titleLabel);
		
		namePane = new JPanel();
		namePane.setBackground(Color.WHITE);
		namePane.setBounds(31, 161, 79, 51);
		registerPane.add(namePane);
		namePane.setLayout(new BorderLayout(0, 0));
		
		nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		namePane.add(nameLabel, BorderLayout.CENTER);
		
		registerBtn = new JButton("Start Game");
		registerBtn.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		registerBtn.setBounds(74, 333, 176, 60);
		registerPane.add(registerBtn);
		
		registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    checkInput();
                    Game frame3 = new Game();
                    setVisible(false); // 창 안보이게 하기
                    frame3.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		

		
		datePane = new JPanel();
		datePane.setBackground(Color.WHITE);
		datePane.setBounds(31, 242, 79, 51);
		registerPane.add(datePane);
		datePane.setLayout(new BorderLayout(0, 0));
		
		dateLabel = new JLabel("Date");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		datePane.add(dateLabel);
		
		nameField = new JTextField();
		nameField.setBounds(122, 161, 165, 51);
		registerPane.add(nameField);
		nameField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(122, 242, 165, 51);
		registerPane.add(dateField);
	}
	
	 private void checkInput() {
	        String nameInput = nameField.getText().trim();
	        String dateInput = dateField.getText().trim();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	        
	        if (nameInput.isEmpty() || dateInput.isEmpty()) {
	            throw new IllegalArgumentException("Name and Date cannot be empty.");
	        }
	        try {Date date = dateFormat.parse(dateInput);} catch(ParseException e) {
	        	throw new IllegalArgumentException("Invalid date format. Please enter the date in YYYY.MM.DD format.");
		        
	        }
	    
	        	 
	        

	        // Add more validation logic as needed
	    }
}
