//import java.awt.Toolkit;
//import java.awt.image.BufferedImage;
//import javax.swing.*;
//import java.awt.*;
//
//import javax.swing.ImageIcon;
//
//public class Tile {
//    protected int value;
//    protected ImageIcon imageIcon;
//	public static final int WIDTH =80;
//	public static final int	HEIGHT =80;
//	public static final int SLIDE_SPEED = 20;
//	public static final int ARC_WIDTH = 15;
//	public static final int ARC_HEIGHT = 15;
//    public Tile(int value, String imagePath) {
//        this.value = value;
//        this.imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource(imagePath)));
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public ImageIcon getImageIcon() {
//        return imageIcon;
//    }
//    
//    public ImageIcon getScaledImage() {
//        Image img = imageIcon.getImage();
//        Image scaledImg = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
//        return new ImageIcon(scaledImg);
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(value);
//    }
//}


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;

public abstract class Tile extends JFrame implements TileInterface{

	public static final int WIDTH =92;
	public static final int	HEIGHT =92;
	public static final int SLIDE_SPEED = 20;
	public static final int ARC_WIDTH = 15;
	public static final int ARC_HEIGHT = 15;
	
	private int value;
	protected BufferedImage tileImage;
	private Color background;
	private Color text;
	private Font font;
	private Point slideTo;
	private int x;
	private int y;
	protected ImageIcon imageIcon;
	
	private boolean beginningAnimation = true;
	private double scaleFirst = 0.1;
	private BufferedImage beginningImage;
	
	private boolean combineAnimation = false;
	private double scaleCombine = 1.5;
	private BufferedImage combineImage;
	private boolean canCombine = true;
	
	
	// "/image/strawberry.png"
	
	public Tile(int value, int x, int y, String imagePath) {
		this.value = value;
		this.x=x;
		this.y=y;
		this.imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource(imagePath)));
		slideTo = new Point(x,y);
		tileImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_ARGB);
		beginningImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		combineImage = new BufferedImage(WIDTH*2, HEIGHT*2, BufferedImage.TYPE_INT_ARGB);
		drawImage();
		//System.out.println(tileImage);	
	}
	
	//public abstract void drawImage();
	
	public void update() {
		if(beginningAnimation) {
			AffineTransform transform = new AffineTransform();
			transform.translate(WIDTH/2 - scaleFirst * WIDTH / 2, HEIGHT / 2 -scaleFirst* HEIGHT / 2);
			transform.scale(scaleFirst, scaleFirst);
			Graphics2D g2d = (Graphics2D) beginningImage.getGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g2d.setColor(new Color(0,0,0,0));
			g2d.fillRect(0, 0, WIDTH, HEIGHT);
			g2d.drawImage(tileImage, transform, null);
			scaleFirst += 0.1;
			g2d.dispose();
			if(scaleFirst >=1) beginningAnimation = false;
			
		}
		else if (combineAnimation) {
			AffineTransform transform = new AffineTransform();
			transform.translate(WIDTH/2 - scaleCombine * WIDTH / 2, HEIGHT / 2 -scaleCombine * HEIGHT / 2);
			transform.scale(scaleCombine, scaleCombine);
			Graphics2D g2d = (Graphics2D) combineImage.getGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g2d.setColor(new Color(0,0,0,0));
			g2d.fillRect(0, 0, WIDTH, HEIGHT);
			g2d.drawImage(tileImage, transform, null);
			scaleCombine -= 0.05;
			g2d.dispose();
			if(scaleCombine <=1) combineAnimation = false;
			
		}
	}
	public void render(Graphics2D g) {
		if(beginningAnimation) {
			g.drawImage(beginningImage, x, y, null);
		}
		else if (combineAnimation) {
			g.drawImage(combineImage, (int)(x + WIDTH/2 - scaleCombine*WIDTH/2), 
										(int)(y + HEIGHT/2 - scaleCombine*HEIGHT/2), null);
		}
		else {
		g.drawImage(tileImage, x, y, null); }
	}
		
	public int getValue() {
		return value;
	}
	


	public void setValue (int value, int x, int y) {
		//this.imageIcon=null;
		Tile tile=new StrawberryTile(x, y);
		if (value == 4) {
			 tile = new AppleTile(x, y);
	    } else if(value==8){
	    	 tile = new KiwiTile(x, y);
	    }
	    else if(value==16){
	    	 tile = new OrangeTile(x, y);
	    }
	    else if(value==32){
	    	 tile = new GrapeTile(x, y);
	    }
	    else if(value==64){
	    	 tile = new WatermelonTile(x, y);
	    }else if(value==128){
	    	 tile = new BasketTile(x, y);
	    }
		
		this.imageIcon = tile.getScaledImage();
		this.value=tile.getValue();
		
		 tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g = tileImage.createGraphics();
		    drawCommon(g, imageIcon);
		    g.dispose();
		    drawImage();
		

		
}
	
	

	public boolean CanCombine() {
		return canCombine;
	}

	public void setCanCombine(boolean canCombine) {
		this.canCombine = canCombine;
	}

	public Point getSlideTo() {
		return slideTo;
	}

	public void setSlideTo(Point slideTo) {
		this.slideTo = slideTo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCombineAnimation() {
		return combineAnimation;
	}

	public void setCombineAnimation(boolean combineAnimation) {
		this.combineAnimation = combineAnimation;
		if(combineAnimation) scaleCombine = 1.2;
	}
	
	public ImageIcon getScaledImage() {
		Image img = imageIcon.getImage();
		Image scaledImg = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImg);
	}
}
