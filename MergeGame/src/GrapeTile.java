import java.awt.Graphics2D;

public class GrapeTile extends Tile {
    
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