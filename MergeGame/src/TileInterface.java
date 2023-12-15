import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public interface TileInterface {	
	public static final int WIDTH =80;
	public static final int	HEIGHT =80;
	
	 void drawImage();
	 default void drawCommon(Graphics2D g, ImageIcon imageIcon) {
	        Image img = imageIcon.getImage();
	        
	        // 변환된 Image를 그래픽스에 그림
	        g.setColor(new Color(0, 0, 0, 0));
	        g.fillRect(0, 0, WIDTH, HEIGHT);
	        g.drawImage(img, 0, 0, null);
	        g.dispose();
	    }
}
