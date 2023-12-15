import java.awt.Graphics2D;

public class AppleTile extends Tile {

    
    private static final long serialVersionUID = 1L;
	public AppleTile(int x, int y) {
            super(4, x, y ,"/image/apple.png");
      }
    @Override
	public void drawImage() {	
		  	Graphics2D g = (Graphics2D) tileImage.getGraphics();
		  	imageIcon=this.getScaledImage();
	        drawCommon(g, imageIcon);
	}
}