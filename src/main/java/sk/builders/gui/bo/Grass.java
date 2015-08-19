package sk.builders.gui.bo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Grass {
    private int X;
    private int Y;
    private BufferedImage grass;

    public Grass(int X, int Y, BufferedImage grass) {
        this.X = X;
        this.Y = Y;
        this.grass = grass;
    }

    public void draw(Graphics g) {
        g.drawImage(grass, X, Y, null);
    }
}
