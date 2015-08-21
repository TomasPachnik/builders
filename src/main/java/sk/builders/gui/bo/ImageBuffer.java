package sk.builders.gui.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.builders.utils.Utils;

public class ImageBuffer {

    private BufferedImage terrain;
    private BufferedImage water;
    private BufferedImage building;

    public ImageBuffer() throws IOException {
        terrain = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "terrain.png"));
        water = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "water.png"));
        building = ImageIO.read(new File(Utils.MAIN_RESOURCE_PATH + "building.png"));
    }

    public BufferedImage getTerrain() {
        return terrain;
    }

    public BufferedImage getWater() {
        return water;
    }

    public BufferedImage getBuilding() {
        return building;
    }

}
