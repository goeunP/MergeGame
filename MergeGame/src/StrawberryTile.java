import java.awt.Graphics2D;

public class StrawberryTile extends Tile {

    private static final long serialVersionUID = 1L;

    // this tile contains value 2 and this will be used for score
    // it draws strawberry image in the tile
	public StrawberryTile(int x, int y) {
            super(2, x, y ,"/image/strawberry.png");
        }

	@Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}