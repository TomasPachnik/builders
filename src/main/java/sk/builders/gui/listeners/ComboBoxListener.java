package sk.builders.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import sk.builders.game.enums.Type;

public class ComboBoxListener implements ActionListener {
    private Type type;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String selectedItem = (String) cb.getSelectedItem();
        switch (selectedItem) {
        case "voda":
            type = Type.WATER;
            break;
        case "les":
             type = Type.FOREST;
            break;
        case "hory":
            type = Type.MOUNTAIN;
            break;
        default:
            type = Type.TERRAIN;
            break;
        }
    }

    public Type getType() {
        return type;
    }

}
