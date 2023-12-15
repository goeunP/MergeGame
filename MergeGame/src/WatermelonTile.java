import java.awt.Graphics2D;

public class WatermelonTile extends Tile {
    public WatermelonTile(int x, int y) {
        //	super(2, 1, 1);
            super(64, x, y ,"/image/watermelon.png");
        }

    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}