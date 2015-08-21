package sk.builders.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Castle;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.DisplayMap;
import sk.builders.utils.Utils;

public class ActionListeners {

    @Autowired
    private DisplayMap displayMap;
    @Autowired
    private Map map;
    @Autowired
    private GameApi gameApi;
    @Autowired
    private MouseMotionEvent mouseMotionEvent;
    @Autowired
    private MousePositionRightPressed mousePositionRightPressed;
    @Autowired
    private ComboBoxListener comboBoxListener;

    public void initListeners() {
        displayMap.addMouseMotionListener(mouseMotionEvent);

        displayMap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Position clicked = null;
                for (int i = 0; i < map.getMap()[0].length; i++) {
                    for (int j = 0; j < map.getMap()[1].length; j++) {
                        if (Utils.containsPoint(map.getBuilding(new Position(i, j)).getPolygon(), new Position(e.getX() - Utils.OFFSET_X, e.getY()
                                - Utils.OFFSET_Y))) {
                            clicked = map.getBuilding(new Position(i, j)).getPosition();
                            break;
                        }
                    }
                }

                if (SwingUtilities.isLeftMouseButton(e)) {
                    Building building = null;
                    building = new Building(comboBoxListener.getType(), clicked);
                    System.out.println(gameApi.build(building).isResult());
                    displayMap.repaint();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    System.out.println(gameApi.destroy(clicked).isResult());
                }
                displayMap.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePositionRightPressed.setPosition(new Position(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

}
