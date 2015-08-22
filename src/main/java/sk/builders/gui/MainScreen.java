package sk.builders.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.listeners.ActionListeners;
import sk.builders.gui.listeners.ComboBoxListener;

public class MainScreen {

    @Autowired
    private Displayer displayMap;
    @Autowired
    private ActionListeners actionListeners;
    @Autowired
    private ComboBoxListener comboBoxListener;
    @Autowired
    private GameApi gameApi;
    @Autowired
    private JButton save;
    @Autowired
    private JButton load;

    public void draw() {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Builders");
        guiFrame.setSize(1280, 700);
        guiFrame.setLocationRelativeTo(null);
        final JPanel panel = new JPanel();

        String[] petStrings = { "luka", "voda", "les", "hory" };
        JComboBox petList = new JComboBox(petStrings);
        petList.addActionListener(comboBoxListener);
        petList.setSelectedIndex(0);
        displayMap.setPreferredSize(new Dimension(1280 - 32, 700 - 32));
        panel.add(petList);
        panel.add(save);
        panel.add(load);
        panel.add(displayMap);
        guiFrame.add(panel);
        actionListeners.initListeners();
        guiFrame.setVisible(true);
    }
}
