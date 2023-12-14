import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;

public class Tile {
    protected int value;
    protected ImageIcon imageIcon;
	public static final int WIDTH =80;
	public static final int	HEIGHT =80;
	public static final int SLIDE_SPEED = 20;
	public static final int ARC_WIDTH = 15;
	public static final int ARC_HEIGHT = 15;
    public Tile(int value, String imagePath) {
        this.value = value;
        this.imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource(imagePath)));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
    
    public ImageIcon getScaledImage() {
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}