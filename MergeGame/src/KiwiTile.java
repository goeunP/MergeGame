import java.awt.Graphics2D;

public class KiwiTile extends Tile {
   
    private static final long serialVersionUID = 1L;
    
    // this tile contains value 8 and this will be used for score
    // it draws kiwi image in the tile
	public KiwiTile(int x, int y) {
            super(8, x, y ,"/image/kiwi.png");
        }
    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}