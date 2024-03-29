import java.awt.Graphics2D;

public class BasketTile extends Tile {

	 // this tile contains value 128 and this will be used for score
    // it draws basket image in the tile
	
    private static final long serialVersionUID = 1L;

	public BasketTile(int x, int y) {
        //	super(2, 1, 1);
            super(128, x, y ,"/image/basket.png");
        }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}