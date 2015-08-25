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
    private BufferedImage person1A;
    private BufferedImage person1B;
    private BufferedImage person2A;
    private BufferedImage person2B;
    private BufferedImage person3A;
    private BufferedImage person3B;
    private BufferedImage person4A;
    private BufferedImage person4B;
    private BufferedImage woodcutter;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("terrain.png"));
        water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("water.png"));
        mountain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("mountain.png"));
        forest = ImageIO.read(getClass().getClassLoader().getResourceAsStream("forest.png"));
        castle = ImageIO.read(getClass().getClassLoader().getResourceAsStream("castle.png"));
        person1A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1A.png"));
        person1B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1B.png"));
        person2A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person2A.png"));
        person2B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person2B.png"));
        person3A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person3A.png"));
        person3B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person3B.png"));
        person4A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person4A.png"));
        person4B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person4B.png"));
        woodcutter = ImageIO.read(getClass().getClassLoader().getResourceAsStream("woodcutter.png"));
    }

    public BufferedImage getPerson2A() {
        return person2A;
    }

    public BufferedImage getPerson2B() {
        return person2B;
    }

    public BufferedImage getPerson3A() {
        return person3A;
    }

    public BufferedImage getPerson3B() {
        return person3B;
    }

    public BufferedImage getPerson4A() {
        return person4A;
    }

    public BufferedImage getPerson4B() {
        return person4B;
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
