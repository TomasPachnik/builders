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
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Castle;
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

    public void initListeners() {
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
                try {
                    gameApi.load();
                } catch (IOException e1) {
                    System.err.println(e1);
                }
                displayMap.repaint();
            }
        });

        displayMap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Position clicked = Utils.calculateReverse(new Position(e.getX(), e.getY()), map);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Building building = null;
                    building = new Building(comboBoxListener.getType(), clicked);
                    System.out.println(Utils.calculatePosition(clicked));
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
