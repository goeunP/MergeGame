import javax.swing.JFrame;

public class Start extends JFrame {
	private static final long serialVersionUID = 1L;
	public boolean dead;
    public Start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Game game = new Game();
        add(game);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        game.start();
    }
}