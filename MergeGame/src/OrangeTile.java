import java.awt.Graphics2D;

public class OrangeTile extends Tile {
	
	 private static final long serialVersionUID = 1L;

	// this tile contains value 16 and this will be used for score
    // it draws orange image in the tile
    public OrangeTile(int x, int y) {

        super(16, x, y ,"/image/orange.png");
    }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}