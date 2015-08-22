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
    private BufferedImage personAB;
    private BufferedImage personAA;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("terrain.png"));
        water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("water.png"));
        mountain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("mountain.png"));
        forest = ImageIO.read(getClass().getClassLoader().getResourceAsStream("forest.png"));
        building = ImageIO.read(getClass().getClassLoader().getResourceAsStream("building.png"));
        personAB = ImageIO.read(getClass().getClassLoader().getResourceAsStream("personAB.png"));
        personAA = ImageIO.read(getClass().getClassLoader().getResourceAsStream("personAA.png"));
    }

    public BufferedImage getPersonAA() {
        return personAA;
    }

    public BufferedImage getPersonAB() {
        return personAB;
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
