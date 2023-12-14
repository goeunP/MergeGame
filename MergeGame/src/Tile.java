import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Tile {
    protected int value;
    protected ImageIcon imageIcon;

    public Tile(int value, String imagePath) {
        this.value = value;
        this.imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource(imagePath)));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}