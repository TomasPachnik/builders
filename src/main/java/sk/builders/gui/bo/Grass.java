package sk.builders.gui.bo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Grass {
    private int X;
    private int Y;
    private BufferedImage castle;

    public Grass(int X, int Y, BufferedImage castle) {
        this.X = X;
        this.Y = Y;
        this.castle = castle;
    }

    public void draw(Graphics g) {
        g.drawImage(castle, X, Y, null);
    }
}
