package sk.builders.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import sk.builders.core.annotations.Autowired;
import sk.builders.utils.Utils;

public class MouseMotionEvent implements MouseMotionListener {

    @Autowired
    private DisplayMap displayMap;
    @Autowired
    private MousePositionRightPressed mousePositionRightPressed;

    @Override
    public void mouseDragged(MouseEvent arg0) {
        if (SwingUtilities.isRightMouseButton(arg0)) {

            Utils.OFFSET_X = mousePositionRightPressed.getTemporaryOffsetX() + (arg0.getX() - mousePositionRightPressed.getPosition().getX());
            Utils.OFFSET_Y = mousePositionRightPressed.getTemporaryOffsetY() + (arg0.getY() - mousePositionRightPressed.getPosition().getY());
            displayMap.repaint();
            /*
             * System.out.println(arg0.getX()); System.out.println(arg0.getY()); Utils.OFFSET++; displayMap.repaint();
             */
        }

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

}
