package sk.builders.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JComponent;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.gui.bo.Castle;
import sk.builders.gui.bo.Grass;
import sk.builders.utils.Utils;

public class DisplayMap extends JComponent {

    private int length = 64;

    @Autowired
    private Map map;

    @Autowired
    private BufferedImage castle;

    @Autowired
    private BufferedImage grass;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // najskor vykresli cely panel na zeleno
        g.setColor(Color.BLACK);
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
        Position p = Utils.calculatePosition(b.getPosition());
        switch (b.getType()) {
        case TERRAIN:
            Grass grassObj = new Grass(p.getX(), p.getY(), grass);
            grassObj.draw(g);
            break;
        case BUILDING:
            Castle castleObj = new Castle(p.getX(), p.getY(), castle);
            castleObj.draw(g);
            break;
        }
    }
}
