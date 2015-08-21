package sk.builders.gui.bo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Castle {

	private int X;
	private int Y;
	private BufferedImage castle;

	public Castle(int X, int Y, BufferedImage castle) {
		this.X = X;
		this.Y = Y;
		this.castle = castle;
	}

	public void draw(Graphics g) {
		g.drawImage(castle, X, Y, null);
	}

}
