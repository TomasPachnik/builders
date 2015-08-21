package sk.builders.game.bo;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import sk.builders.game.enums.Type;
import sk.builders.utils.Utils;

/**
 * zakladna trieda budovy
 * 
 * @author Tomas
 *
 */
public abstract class Building {

    private Type type;
    private Position position;
    private Polygon polygon;

    public Building(Type type, Position position) {
        this.type = type;
        this.position = position;
        this.polygon = Utils.initPolygon(position);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

}
