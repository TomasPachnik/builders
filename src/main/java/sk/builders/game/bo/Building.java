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
public class Building {

    @Override
    public String toString() {
        return "Building [type=" + type + ", position=" + position + ", polygon=" + polygon + "]";
    }

    private Type type;
    private Position position;
    private Polygon polygon;
    private Person worker;

    public Building(Type type, Position position) {
        this.type = type;
        this.position = position;
        this.polygon = Utils.initPolygon(position);
        this.worker = new Person(new Position(position.getX() + 1, position.getY() + 1));
    }

    public boolean isWorkerHome() {
        if ((position.getX() == worker.getPosition().getX() - 1) && (position.getY() == worker.getPosition().getY() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Person getWorker() {
        return worker;
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
