package sk.builders.gui.bo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageBuffer {

    private BufferedImage terrain;
    private BufferedImage water;
    private BufferedImage mountain;
    private BufferedImage forest;
    private BufferedImage building;
    private BufferedImage person1B;
    private BufferedImage person1A;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("terrain.png"));
        water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("water.png"));
        mountain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("mountain.png"));
        forest = ImageIO.read(getClass().getClassLoader().getResourceAsStream("forest.png"));
        building = ImageIO.read(getClass().getClassLoader().getResourceAsStream("building.png"));
        person1B = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1B.png"));
        person1A = ImageIO.read(getClass().getClassLoader().getResourceAsStream("person1A.png"));
    }

    public BufferedImage getPerson1A() {
        return person1A;
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

    public BufferedImage getBuilding() {
        return building;
    }
}
