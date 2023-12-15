import java.awt.Graphics2D;

public class OrangeTile extends Tile {
    public OrangeTile(int x, int y) {
    //	super(2, 1, 1);
        super(16, x, y ,"/image/orange.png");
    }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}