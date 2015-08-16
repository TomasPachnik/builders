package sk.builders.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;

public class DisplayMap extends JComponent {

    @Autowired
    private Map map;

    @Autowired
    private BufferedImage castle;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // najskor vykresli cely panel na zeleno
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        // prelezie polom mapy a vykresli budovy
        for (int i = 0; i < map.getMap()[0].length; i++) {
            for (int j = 0; j < map.getMap()[0].length; j++) {
                try {
                    drawBuilding(map.getBuilding(new Position(i, j)), g);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    private void drawBuilding(Building b, Graphics g) throws IOException {

        double x1 = ((double) b.getPosition().getX() / (double) map.getMap()[0].length) * getWidth();
        int x2 = getWidth() / map.getMap()[0].length;
        double y1 = ((double) b.getPosition().getY() / (double) map.getMap()[1].length) * getHeight();
        int y2 = getHeight() / map.getMap()[1].length;

        BufferedImage resizedImage = new BufferedImage(x2, y2, castle.getType());
        Graphics2D graphic = resizedImage.createGraphics();
        graphic.drawImage(castle, 0, 0, x2, y2, null);
        graphic.dispose();

        switch (b.getType()) {
        case TERRAIN:
            g.setColor(Color.GREEN);
            g.fillRect((int) x1, (int) y1, x2, y2);
            break;
        case BUILDING:
            g.setColor(Color.GRAY);
            g.drawImage(resizedImage, (int) x1, (int) y1, null);
            break;
        }
    }
}
