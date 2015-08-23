package sk.builders.gui.bo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageBuffer {

    private BufferedImage terrain;
    private BufferedImage water;
    private BufferedImage mountain;
    private BufferedImage forest;
    private BufferedImage castle;
    private BufferedImage person1B;
    private BufferedImage person1A;
    private BufferedImage woodcutter;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("terrain.png"));
        water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("water.png"));
        mountain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("mountain.png"));
        forest = ImageIO.read(getClass().getClassLoader().getResourceAsStream("forest.png"));
        castle = ImageIO.read(getClass().getClassLoader().getResourceAsStream("castle.png"));
        person1B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1B.png"));
        person1A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1A.png"));
        woodcutter = ImageIO.read(getClass().getClassLoader().getResourceAsStream("woodcutter.png"));
    }

    public BufferedImage getPerson1A() {
        return person1A;
    }

    public BufferedImage getWoodcutter() {
        return woodcutter;
    }

    public BufferedImage getPerson1B() {
        return person1B;
    }

    public BufferedImage getTerrain() {
        return terrain;
    }

    public BufferedImage getWater() {
        return water;
    }

    public BufferedImage getMountain() {
        return mountain;
    }

    public BufferedImage getForest() {
        return forest;
    }

    public BufferedImage getCastle() {
        return castle;
    }
}
