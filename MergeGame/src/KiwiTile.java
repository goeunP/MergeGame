import java.awt.Graphics2D;

public class KiwiTile extends Tile {
   
    public KiwiTile(int x, int y) {
        //	super(2, 1, 1);
            super(8, x, y ,"/image/kiwi.png");
        }
    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}