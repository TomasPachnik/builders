package sk.builders.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Castle;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.interfaces.GameApi;
import sk.builders.utils.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainScreen {

    @Autowired
    private DisplayMap displayMap;
    @Autowired
    private GameApi gameApi;
    @Autowired
    private Map map;

    public void draw() {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Builders");
        guiFrame.setSize(640, 480);
        guiFrame.setLocationRelativeTo(null);
        final JPanel panel = new JPanel();

        JButton destroy = new JButton("destroy");
        displayMap.setPreferredSize(new Dimension(640 - 32, 640 - 32));
        panel.add(destroy);
        panel.add(displayMap);
        guiFrame.add(panel);

        destroy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        displayMap.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                Position clicked = null;
                for (int i = 0; i < map.getMap()[0].length; i++) {
                    for (int j = 0; j < map.getMap()[1].length; j++) {
                        if (Utils.containsPoint(map.getBuilding(new Position(i, j)).getPolygon(), new Position(e.getX(), e.getY()))) {
                            clicked = map.getBuilding(new Position(i, j)).getPosition();
                            break;
                        }
                    }
                }

                if (SwingUtilities.isLeftMouseButton(e)) {
                    Building building = new Castle(clicked);
                    System.out.println(gameApi.build(building, clicked).isResult());
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
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        guiFrame.setVisible(true);
    }
}
