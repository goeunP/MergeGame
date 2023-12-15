import java.awt.Graphics2D;

public class AppleTile extends Tile {

    
    public AppleTile(int x, int y) {
        //	super(2, 1, 1);
            super(4, x, y ,"/image/apple.png");
      }
    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}