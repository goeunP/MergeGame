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

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel startPane;
	ImageIcon backgroundImg;


	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setTitle("Register");
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
		
	}

}
