package sk.builders.gui.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.builders.utils.Utils;

public class ImageBuffer {

    private BufferedImage terrain;
    private BufferedImage water;
    private BufferedImage mountain;
    private BufferedImage forest;
    private BufferedImage building;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("terrain.png"));
        water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("water.png"));
        mountain = ImageIO.read(getClass().getClassLoader().getResourceAsStream("mountain.png"));
        forest = ImageIO.read(getClass().getClassLoader().getResourceAsStream("forest.png"));
        building = ImageIO.read(getClass().getClassLoader().getResourceAsStream("building.png"));
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
