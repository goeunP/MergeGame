import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
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
	public static final int ROWS = 3;
	public static final int COLS = 3;
	private final int startingTiles = 2;
	private Tile[][] board;
	private boolean over;
	private boolean win;
	private BufferedImage gameBoard;
	private BufferedImage finalBoard;
	private int x;
	private int y;
	private int score = 0;
	private int highScore= 0;
	private Font scoreFont;

	private static int SPACE = 10;
	public static int BOARD_WIDTH = (COLS+1) * SPACE + COLS * Tile.WIDTH;
	public static int BOARD_HEIGHT = (ROWS+1) * SPACE + ROWS * Tile.HEIGHT;
	

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
	public MainGUI(int x, int y) {
		setTitle("My Fruits Basket");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		backgroundImg= new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/image/background.jpeg")));
		startPane = new JPanel() {
			 private static final long serialVersionUID = 1L;

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
		startBtn.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
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
		rankingBtn.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		rankingBtn.setPreferredSize(rankingBtnSize);
		rankingBtn.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
			        RankGUI frame4 = new RankGUI();
			        setVisible(false); // 창 안보이게 하기 
					frame4.setVisible(true);
			    }
		});
		GridBagConstraints gbc_rankingBtn = new GridBagConstraints();
		gbc_rankingBtn.insets = new Insets(0, 0, 0, 5);
		gbc_rankingBtn.gridx = 1;
		gbc_rankingBtn.gridy = 5;
		startPane.add(rankingBtn, gbc_rankingBtn);
		
		
		//세연 코드
		scoreFont = Game.main.deriveFont(24f); //게임 클래스의 메인 폰트를 24크기로 초기화 
		this.x=x; //좌표값 
		this.y=y; //좌표값  
		board = new Tile[ROWS][COLS];
		gameBoard = new BufferedImage(BOARD_WIDTH,BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		finalBoard = new BufferedImage(BOARD_WIDTH,BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		//게임 보드의 이미지를 저장하는 버퍼 이미지  

	}
	
	private void createBoardImage() {
		Graphics2D g = (Graphics2D) gameBoard.getGraphics(); //그래픽의 객체 가져옴 
		g.setColor(Color.darkGray);
		g.fillRect(0,0,BOARD_WIDTH,BOARD_HEIGHT);
		g.setColor(Color.lightGray); 
		
		//각 타일의 위치를 계산하고 타일의 위치에 fillroundrect로 사각형 그림 
		for (int row=0; row<ROWS; row++) {
			for(int col =0; col<COLS; col++) {
				int x = SPACE + SPACE * col + Tile.WIDTH * col;
				int y = SPACE + SPACE * row + Tile.HEIGHT * row;
				g.fillRoundRect(x, y, Tile.WIDTH, Tile.HEIGHT, Tile.ARC_WIDTH, Tile.ARC_HEIGHT);
			
			}
		}
		
	}
	
	private void start() {
		for(int i =0; i<startingTiles; i++) {
			spawnRandom();
		}
	}
	
	//게임 시작 시 초기 타일 배치  
	private void spawnRandom() {
		Random random = new Random();
			
		boolean notValid = true;
		while(notValid) {
			int location = random.nextInt(ROWS*COLS);
			int row = location / ROWS;
			int col = location % COLS;
			Tile current = board[row][col];
			if(current == null) {
				int value = random.nextInt(10) < 9 ? 2 : 4;
				Tile tile = new Tile(value, getTileX(col), getTileY(row));
				board[row][col] = tile;
				notValid = false;
		}
			
	}
		
	public int getTileX(int col) {
	return SPACE + col * Tile.WIDTH + col * SPACE;
	}
		
	public int getTileY(int row) {
		return SPACE + row * Tile.HEIGHT + row * SPACE;
	}
	
	public void update() {
		
		checkKeys();
		if(score >= highScore) {
			highScore = score;
			
		}
		
		for(int row = 0; row <ROWS; row++) {
			for (int col =0; col<COLS; col++) {
				Tile current = board[row][col];
				if(current == null) continue;
				current.update();
				resetPosition(current, row, col);
				if(current.getValue()==2048) {
					win = true;
				}
			}
		}//타일을 순회하면서 board의 요소를 확인하고 해당 위치에 타일이 잇으면 타일 업데이트 및 타일 위치 재설정
		//타일의 값이 2048이면 게임을 클리어 상태로 변경   
	}
	
	//타일 위치를 재설정
		private void resetPosition(Tile current, int row, int col) {
			if (current == null) return;
			int x = getTileX(col);
			int y = getTileY(row);
			int distX = current.getX() -x;
			int distY = current.getY() -y;
			
			if(Math.abs(distX) <Tile.SLIDE_SPEED) {
				current.setX(current.getX()-distX);
			}
			if(Math.abs(distY) < Tile.SLIDE_SPEED) {
				current.setY(current.getY() - distY);
			}
			if(distX <0) {
				current.setX(current.getX() + Tile.SLIDE_SPEED);
			}
			if(distY < 0) { 
				current.setY(current.getY() + Tile.SLIDE_SPEED);
			}
			if(distX > 0) {
				current.setX(current.getX() - Tile.SLIDE_SPEED);
				}
			if(distY > 0) {
				current.setY(current.getY() - Tile.SLIDE_SPEED);
				}
		}
		
		//타일을 이동시킴 타일을 이동하고 병합
		private boolean move(int row, int col, int horizontalDirection, int verticalDirection, Direction dir) {
			boolean canMove = false;
			Tile current = board[row][col];
			if(current == null) return false;
			
			boolean move = true;
			int newCol = col;
			int newRow = row;
			while(move) {
				newCol += horizontalDirection;
				newRow += verticalDirection;
				if(checkOutOfBounds(dir, newRow, newCol)) break;
				if(board[newRow][newCol] == null) { //새로운 위치에 타일이 없는 경우  
					board[newRow][newCol] = current;
					board[newRow - verticalDirection][newCol- horizontalDirection] = null;
					board[newRow][newCol].setSlideTo(new Point(newRow, newCol));
					canMove = true;
				} //새로운 위치에 있는 타일이 병합 가능한 경우  
				else if (board[newRow][newCol].getValue()==current.getValue() && board[newRow][newCol].CanCombine()) {
					board[newRow][newCol].setCanCombine(false);
					board[newRow][newCol].setValue(board[newRow][newCol].getValue()*2);
					canMove = true;
					board[newRow - verticalDirection][newCol - horizontalDirection] = null;
					board[newRow][newCol].setSlideTo(new Point(newRow, newCol));
					board[newRow][newCol].setCombineAnimation(true);
					score += board[newRow][newCol].getValue();
				}
				else {
					move =false;
				}
			}
			
			
			return canMove;
		}
		
		//보드에서 벗어나는지 판
		private boolean checkOutOfBounds(Direction dir, int row, int col) {
			if(dir == Direction.LEFT) {
				return col<0;
			}
			else if (dir == Direction.RIGHT) {
				return col>COLS-1;
			}
			else if (dir == Direction.UP) {
				return row<0;
			}
			else if (dir == Direction.DOWN) {
				return row>ROWS-1;
			}
			return false;
		}
		
		//주어진 방향(dir)으로 타일들을 이동시킴
		//방향별로 타일을 이동, 이동 가능 여부 확인, 타일이 합쳐질 수 있는지 여부를 검사  
		private void moveTiles(Direction dir) {
			boolean canMove = false;
			int horizontalDirection =0;
			int verticalDirection = 0;
			
			if(dir == Direction.LEFT) {
				horizontalDirection = -1;
				for(int row =0; row<ROWS; row++) {
					for (int col =0; col<COLS; col++) {
						if(!canMove) {
							canMove = move(row, col, horizontalDirection, verticalDirection, dir);
							
						}
						else move(row, col, horizontalDirection, verticalDirection, dir);
					}
				}
			}
			else if(dir == Direction.RIGHT) {
				horizontalDirection = 1;
				for(int row =0; row<ROWS; row++) {
					for (int col =COLS-1; col>=0; col--) {
						if(!canMove) {
							canMove = move(row, col, horizontalDirection, verticalDirection, dir);
							
						}
						else move(row, col, horizontalDirection, verticalDirection, dir);
					}
				}
			}
			else if(dir == Direction.UP) {
				verticalDirection = -1;
				for(int row =0; row<ROWS; row++) {
					for (int col =0; col<COLS; col++) {
						if(!canMove) {
							canMove = move(row, col, horizontalDirection, verticalDirection, dir);
							
						}
						else move(row, col, horizontalDirection, verticalDirection, dir);
					}
				}
			}
			else if(dir == Direction.DOWN) {
				verticalDirection = 1;
				for(int row =ROWS-1; row>=0; row--) {
					for (int col =0; col<COLS; col++) {
						if(!canMove) {
							canMove = move(row, col, horizontalDirection, verticalDirection, dir);
							
						}
						else move(row, col, horizontalDirection, verticalDirection, dir);
					}
				}
			}
			
			else {
				System.out.println(dir + "is not a valid direction.");
			}
			for (int row =0; row<ROWS; row ++) {
				for(int col =0; col<COLS; col++) {
					Tile current = board[row][col];
					if(current == null) continue;
					current.setCanCombine(true);
				}
			}
			if (canMove) {
				spawnRandom();
				checkDead();
			}
		}
		
		//게임이 끝났는지 확인  
		//최고 점수 업데이트 
		private boolean checkSurroundingTils(int row, int col, Tile current) {
			if(row >0) {
				Tile check = board[row -1 ][col];
				if(check == null) return true;
				if(current.getValue() == check.getValue()) return true;
			}
			if(row<ROWS-1) {
				Tile check = board[row+1][col];
				if(check == null) return true;
				if(current.getValue() == check.getValue()) return true;
					
			}
			if(col>0) {
				Tile check = board[row][col-1];
				if(check == null) return true;
				if(current.getValue() == check.getValue()) return true;
					
			}
			if(col<COLS-1) {
				Tile check = board[row][col+1];
				if(check == null) return true;
				if(current.getValue() == check.getValue()) return true;
					
			}
			return false;
		}
		//키값에 따라서 타일이동  
		private void checkKeys() {
			if(Keyboard.typed(KeyEvent.VK_LEFT)) {
				moveTiles(Direction.LEFT);
				if(!hasStarted) hasStarted = true;
			}
			if(Keyboard.typed(KeyEvent.VK_RIGHT)) {
				moveTiles(Direction.RIGHT);
				if(!hasStarted) hasStarted = true;
			}
			if(Keyboard.typed(KeyEvent.VK_UP)) {
				moveTiles(Direction.UP);
				if(!hasStarted) hasStarted = true;
			}
			if(Keyboard.typed(KeyEvent.VK_DOWN)) {
				moveTiles(Direction.DOWN);
				if(!hasStarted) hasStarted = true;
			}
			
		}
}
