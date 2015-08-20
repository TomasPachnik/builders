package sk.builders.gui;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sk.builders.core.annotations.Autowired;
import sk.builders.gui.listeners.ActionListeners;
import sk.builders.gui.listeners.MouseMotionEvent;

public class MainScreen {

    @Autowired
    private DisplayMap displayMap;
    @Autowired
    private MouseMotionEvent mouseMotionEvent;
    @Autowired
    private ActionListeners actionListeners;

    public void draw() {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Builders");
        guiFrame.setSize(1280, 700);
        guiFrame.setLocationRelativeTo(null);
        final JPanel panel = new JPanel();

        JButton destroy = new JButton("destroy");
        displayMap.setPreferredSize(new Dimension(1280 - 32, 700 - 32));
        displayMap.addMouseMotionListener(mouseMotionEvent);
        panel.add(destroy);
        panel.add(displayMap);
        guiFrame.add(panel);
        actionListeners.initListeners();

        guiFrame.setVisible(true);
    }
}
