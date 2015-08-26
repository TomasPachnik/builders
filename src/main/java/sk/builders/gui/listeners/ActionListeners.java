package sk.builders.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import sk.builders.core.annotations.Autowired;
import sk.builders.game.GameLogic;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.Displayer;
import sk.builders.utils.Utils;

public class ActionListeners {

    @Autowired
    private Displayer displayMap;
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
    @Autowired
    private JButton save;
    @Autowired
    private JButton load;
    @Autowired
    private GameLogic gameLogic;

    public void initListeners() {
        loadMap();
        displayMap.addMouseMotionListener(mouseMotionEvent);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameApi.save();
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                    System.err.println(e1);
                }
            }

        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO empty listener
            }
        });

        displayMap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Position clicked = Utils.calculateReverse(new Position(e.getX(), e.getY()), map);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Building building = new Building(comboBoxListener.getType(), clicked);
                    gameLogic.addBuilding(building);
                    System.out.println(gameApi.build(building).isResult());
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

    private void loadMap() {
        try {
            gameApi.load("level");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
