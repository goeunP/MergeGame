import java.awt.Graphics2D;

public class GrapeTile extends Tile {
    
	 private static final long serialVersionUID = 1L;

	// this tile contains value 32 and this will be used for score
    // it draws grape image in the tile
    public GrapeTile(int x, int y) {
        //	super(2, 1, 1);
            super(32, x, y ,"/image/grape.png");
        }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
    
}