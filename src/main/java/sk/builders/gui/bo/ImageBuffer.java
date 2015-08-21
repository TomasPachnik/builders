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
        terrain = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "terrain.png"));
        water = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "water.png"));
        mountain = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "mountain.png"));
        forest = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "forest.png"));
        building = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "building.png"));
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
