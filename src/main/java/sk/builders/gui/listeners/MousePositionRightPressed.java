package sk.builders.gui.listeners;

import sk.builders.game.bo.Position;
import sk.builders.utils.Utils;

/**
 * track mouse position on right pressed
 * 
 * @author Tomas
 *
 */
public class MousePositionRightPressed {

    private Position position;
    private int temporaryOffsetX;
    private int temporaryOffsetY;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        setTemporaryOffsetX(Utils.OFFSET_X);
        setTemporaryOffsetY(Utils.OFFSET_Y);
    }

    public int getTemporaryOffsetX() {
        return temporaryOffsetX;
    }

    public void setTemporaryOffsetX(int temporaryOffsetX) {
        this.temporaryOffsetX = temporaryOffsetX;
    }

    public int getTemporaryOffsetY() {
        return temporaryOffsetY;
    }

    public void setTemporaryOffsetY(int temporaryOffsetY) {
        this.temporaryOffsetY = temporaryOffsetY;
    }
}
