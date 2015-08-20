package sk.builders.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import sk.builders.core.annotations.Autowired;
import sk.builders.gui.DisplayMap;
import sk.builders.utils.Utils;

public class MouseMotionEvent implements MouseMotionListener {

    @Autowired
    private DisplayMap displayMap;
    @Autowired
    private MousePositionRightPressed mousePositionRightPressed;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            Utils.OFFSET_X = mousePositionRightPressed.getTemporaryOffsetX() + (e.getX() - mousePositionRightPressed.getPosition().getX());
            Utils.OFFSET_Y = mousePositionRightPressed.getTemporaryOffsetY() + (e.getY() - mousePositionRightPressed.getPosition().getY());
            displayMap.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }

}
