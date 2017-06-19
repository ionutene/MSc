package BallFall;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	int x = 0;
	int y = 0;
	private void moveBall() {
		x = x + 1;
		y = y + 1;

		if(x==400){
			x=0;
			y=0;
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\APPS\\workspaceIntelliJ\\MSc2\\src\\main\\java\\BallFall\\imgBall.jpg");


		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.drawImage(img1, 10, 10, this);
		int width = img1.getWidth(this);
		int height = img1.getHeight(this);

		int scale = 10;
		int w =  width/scale;
		int h = height/scale;
		// explicitly specify width (w) and height (h)
		g.drawImage(img1, x, y, (int) w, (int) h, this);
		g2d.finalize();

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("BallFall");
		Game game = new Game();

		frame.add(game);
		frame.setSize(400, 400);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);

		}


	}
}
