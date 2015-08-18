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
import sk.builders.game.bo.Terrain;
import sk.builders.game.interfaces.GameApi;

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

        JButton build = new JButton("build");
        JButton destroy = new JButton("destroy");
        displayMap.setPreferredSize(new Dimension(640-32, 640-32));
        panel.add(build);
        panel.add(destroy);
        panel.add(displayMap);
        guiFrame.add(panel);

        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Castle base = new Castle();
                Position position = new Position(0, 0);
                System.out.println(gameApi.build(base, position).isResult());
                displayMap.repaint();
            }
        });

        destroy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Terrain terrain = new Terrain();
                Position position = new Position(0, 0);
                System.out.println(gameApi.destroy(position).isResult());
                displayMap.repaint();
            }
        });

        displayMap.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                double x = ((double) e.getX() / ((double) displayMap.getWidth() / (double) map.getMap()[0].length));
                double y = ((double) e.getY() / ((double) displayMap.getHeight() / (double) map.getMap()[1].length));

                Position position = new Position((int) x, (int) y);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Building building = new Castle();
                    System.out.println(gameApi.build(building, position).isResult());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    System.out.println(gameApi.destroy(position).isResult());
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
