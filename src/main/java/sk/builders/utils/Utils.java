package sk.builders.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.builders.game.bo.Position;
import sk.builders.game.enums.Type;

public class Utils {

    public static final int MAP_LENGTH = 50;
    public static int OFFSET_X = 300;
    public static int OFFSET_Y = 0;
    public static final int LENGTH = 64;
    public static final int HALF_LENGTH = LENGTH / 2;

    public static Position calculatePosition(Position position) {
        int x = (position.getX() - position.getY()) * HALF_LENGTH;
        int y = (position.getX() + position.getY()) * HALF_LENGTH / 2;
        return new Position(x, y);
    }

    public static Polygon initPolygon(Position p) {
        Position position = calculatePosition(p);
        Polygon poly = new Polygon();
        poly.addPoint(position.getX(), position.getY() + 48);
        poly.addPoint(position.getX() + HALF_LENGTH, position.getY() + 64);
        poly.addPoint(position.getX() + LENGTH, position.getY() + 48);
        poly.addPoint(position.getX() + HALF_LENGTH, position.getY() + 32);
        return poly;
    }

    public static boolean containsPoint(Polygon polygon, Position position) {
        return polygon.contains(new Point(position.getX(), position.getY()));
    }
}
