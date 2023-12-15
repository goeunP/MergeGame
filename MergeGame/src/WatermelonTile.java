import java.awt.Graphics2D;

public class WatermelonTile extends Tile {
	private static final long serialVersionUID = 1L;

	// this tile contains value 64 and this will be used for score
    // it draws watermelon image in the tile
    public WatermelonTile(int x, int y) {
       
            super(64, x, y ,"/image/watermelon.png");
        }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}