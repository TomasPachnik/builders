package sk.builders.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JComponent;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.GameLogic;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Person;
import sk.builders.game.bo.Position;
import sk.builders.gui.bo.ImageBuffer;
import sk.builders.utils.Utils;

public class Displayer extends JComponent {

    @Autowired
    private Map map;
    @Autowired
    private ImageBuffer imageBuffer;
    @Autowired
    private GameLogic gameLogic;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // najskor vykresli cely panel na zeleno
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // prelezie polom mapy a vykresli objekty
        for (int j = 0; j < map.getMap()[1].length; j++) {
            for (int i = 0; i < map.getMap()[0].length; i++) {
                for (Building building : gameLogic.getBuildings()) {
                    // System.out.println(gameLogic.getBuildings().size());
                    if (building.getWorker().getPosition().getX() == i && building.getWorker().getPosition().getY() == j) {
                        if (building.getWorker().isLeftHand()) {
                            g.drawImage(imageBuffer.getPerson1A(), building.getWorker().getTotal().getX() + Utils.OFFSET_X, building.getWorker().getTotal()
                                    .getY()
                                    + Utils.OFFSET_Y, null);
                        } else {
                            g.drawImage(imageBuffer.getPerson1B(), building.getWorker().getTotal().getX() + Utils.OFFSET_X, building.getWorker().getTotal()
                                    .getY()
                                    + Utils.OFFSET_Y, null);
                        }

                    }
                }

                try {
                    drawBuilding(map.getBuilding(new Position(i, j)), g);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    private void drawBuilding(Building b, Graphics g) throws IOException {
        Position p = Utils.calculatePosition(b.getPosition());
        p.setX(p.getX() + Utils.OFFSET_X);
        p.setY(p.getY() + Utils.OFFSET_Y);
        switch (b.getType()) {
        case TERRAIN:
            g.drawImage(imageBuffer.getTerrain(), p.getX(), p.getY(), null);
            break;
        case CASTLE:
            g.drawImage(imageBuffer.getCastle(), p.getX(), p.getY(), null);
            break;
        case FOREST:
            g.drawImage(imageBuffer.getForest(), p.getX(), p.getY(), null);
            break;
        case MOUNTAIN:
            g.drawImage(imageBuffer.getMountain(), p.getX(), p.getY(), null);
            break;
        case WATER:
            g.drawImage(imageBuffer.getWater(), p.getX(), p.getY(), null);
            break;
        case WOODCUTTER:
            g.drawImage(imageBuffer.getWoodcutter(), p.getX(), p.getY(), null);
            break;
        default:
            break;
        }
    }

}
