import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int ROWS = 3;
	public static final int COLS = 3;
	private final int startingTiles = 2;
	private Tile[][] board;
	private boolean dead;
	private BufferedImage gameBoard;
	private BufferedImage finalBoard;
	private int score = 0;
	//private int highScore= 0;
	private Font scoreFont;
	private Font Font;
	
	private static int SPACING = 5;
	public static int BOARD_WIDTH = (COLS+1) * SPACING + COLS * Tile.WIDTH;
	public static int BOARD_HEIGHT = (ROWS+1) * SPACING + ROWS * Tile.HEIGHT;
	

	private boolean hasStarted;

	private String saveDataPath;
	private String fileName = "SaveData";
	
	public GameGUI(int x, int y) {
		try {
			saveDataPath = GameGUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			//saveDataPath = System.getProperty("user.home")+ "\\foldername";
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		scoreFont = Game.main.deriveFont(42f);
		Font = Game.main.deriveFont(36f);
		board = new Tile[ROWS][COLS];
		gameBoard = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		finalBoard = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		//startTime = System.nanoTime();
		
		
		//loadHighScore();
		createBoardImage();
		start();
	}
	
	private void createBoardImage() {
		Graphics2D g = (Graphics2D) gameBoard.getGraphics();
		g.setColor(Color.white);
		
		g.setColor(Color.white); 
		
		for (int row=0; row<ROWS; row++) {
			for(int col =0; col<COLS; col++) {
				int x = SPACING + SPACING * col + Tile.WIDTH * col;
				int y = SPACING + SPACING * row + Tile.HEIGHT * row;
				g.fillRoundRect(x, y, Tile.WIDTH, Tile.HEIGHT, Tile.ARC_WIDTH, Tile.ARC_HEIGHT);
			
			}
		}
		
	}
	private void start() {
		for(int i =0; i<startingTiles; i++) {
			spawnRandom();
		}
		
	}
	
	private void spawnRandom() {
		Random random = new Random();
		
		boolean notValid = true;
		while(notValid) {
			int location = random.nextInt(ROWS*COLS);
			int row = location / ROWS;
			int col = location % COLS;
			Tile tile = new OrangeTile(getTileX(col), getTileY(row));
			Tile current = board[row][col];
			
			
			if(current == null) {

				int[] valueSet = {2, 4};
			    int randomIndex = new Random().nextInt(2);
			    int value = valueSet[randomIndex];
				  switch (value) {
		            case 2:
		                tile = new StrawberryTile(getTileX(col), getTileY(row));
		                break;
		            case 4:
		                tile = new AppleTile(getTileX(col), getTileY(row));
		                break;

		            default:
		                tile = new StrawberryTile(getTileX(col), getTileY(row));
		                break;
		        }
			
				board[row][col] = tile;
				notValid = false;	
			}
		}
	}
	public int getTileX(int col) {
		return SPACING + col * Tile.WIDTH + col * SPACING;
	}
	public int getTileY(int row) {
		return SPACING + row * Tile.HEIGHT + row * SPACING;
	}
	public void render(Graphics2D g) {
		Graphics2D g2d = (Graphics2D)finalBoard.getGraphics();
		g2d.drawImage(gameBoard, 0, 0, null);
		
		for(int row = 0; row <ROWS; row++) {
			for (int col =0; col < COLS; col++) {
				Tile current = board[row][col];
				if(current == null) continue;
				current.render(g2d);
			}
		}
		g.drawImage(finalBoard, 10, 200, null);
		g2d.dispose();
		
		g.setColor(Color.WHITE);
		g.setFont(scoreFont);
		g.drawString(""+ score, 230, 50);
		
		g.setColor(Color.WHITE);
		g.setFont(Font);	
		g.drawString("score", 100, 50);
		
		
		
		//System.out.println("");
		
	}
	
	public void update() {
//		if(!won && !dead) {
//			if(hasStarted) {
//			//	elapsedMS = (System.nanoTime() - startTime) / 1000000;
//				//formattedTime = formatTime(elapsedMS);
//			}
//			else {
//				startTime = System.nanoTime();
//			}
//		}
		
		
		checkKeys();
//		if(score >= highScore) {
//			highScore = score;
//			
//		}
		
		for(int row = 0; row <ROWS; row++) {
			for (int col =0; col<COLS; col++) {
				Tile current = board[row][col];
				if(current == null) continue;
				current.update();
				resetPosition(current, row, col);
				if(current.getValue()==2048) {
				}
			}
		}
	}

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
			if(board[newRow][newCol] == null) {
				board[newRow][newCol] = current;
				board[newRow - verticalDirection][newCol- horizontalDirection] = null;
				board[newRow][newCol].setSlideTo(new Point(newRow, newCol));
				canMove = true;
			}
			else if (board[newRow][newCol].getValue()==current.getValue() && board[newRow][newCol].CanCombine()) {
				board[newRow][newCol].setCanCombine(false);
				board[newRow][newCol].setValue(board[newRow][newCol].getValue()*2, newRow, newCol);
				//System.out.println(board[newRow][newCol].getValue());
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
	private void checkDead() {
		for(int row=0; row <ROWS; row++) {
			for(int col =0; col<COLS; col++) {
				if(board[row][col] == null) return;
				if(checkSurroundingTils(row, col,board[row][col])) {
					closeWindow();
					return;
			}
			
			}
		}
		 dead = true;
		    System.out.println("game over");
		    GameoverGUI frame = new GameoverGUI();
		    frame.setVisible(true);
		    saveScore();
}
	private boolean checkSurroundingTils(int row, int col, Tile current) {
		if(row >0) {
			Tile check = board[row -1 ][col];
			if(check == null) return true;
			if(current.getValue() == check.getValue()) 
				return true;
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
	
	  public boolean getDead() {
	        return dead;
	    }
	  public void closeWindow() {
	        this.dispose();
	    }
	  private void saveScoreToFile(int score) {
		    String fileName = "score.txt"; // 파일명 설정

		    try {
		        FileWriter fileWriter = new FileWriter(fileName);
		        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		        // "score: " + score 형식으로 파일에 쓰기
		        bufferedWriter.write("score: " + score);

		        bufferedWriter.close(); // 파일 닫기
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	    
	    private void saveScore() {
	        saveScoreToFile(score);
	    }
	    

}
