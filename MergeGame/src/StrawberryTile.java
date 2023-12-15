import java.awt.Graphics2D;

public class StrawberryTile extends Tile {

    private static final long serialVersionUID = 1L;

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