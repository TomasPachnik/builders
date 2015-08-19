package sk.builders.utils;

import java.awt.Point;
import java.awt.Polygon;

import sk.builders.game.bo.Position;

public class Utils {

    private static final int OFFSET = 300;
    public static final String MAIN_RESOURCE_PATH = "src/main/resources/";
    public static final int LENGTH = 64;
    public static final int HALF_LENGTH = LENGTH / 2;

    public static Position calculatePosition(Position position) {
        int x = (position.getX() - position.getY()) * HALF_LENGTH;
        int y = (position.getX() + position.getY()) * HALF_LENGTH / 2;
        return new Position(x + OFFSET, y);
    }

    /*
     * public static Position calculateReverse(Position position) { position.setX(position.getX() - OFFSET); int x = (position.getX() / HALF_LENGTH +
     * position.getY() / (HALF_LENGTH / 2)) / 2; int y = (position.getY() / (HALF_LENGTH / 2) - (position.getX() / HALF_LENGTH)) / 2; return new Position(x, y);
     * }
     */
    public static Polygon initPolygon(Position p) {
        Position position = calculatePosition(p);
        Polygon poly = new Polygon();
        poly.addPoint(position.getX(), position.getY() + 48);
        poly.addPoint(position.getX() + HALF_LENGTH, position.getY() + 64);
        poly.addPoint(position.getX() + LENGTH, position.getY() + 48);
        poly.addPoint(position.getX() + HALF_LENGTH, position.getY() + 32);
        /*
         * System.out.println(p); System.out.println(position); System.out.println(position.getX() + ":" + position.getY() + 48);
         * System.out.println(position.getX() + HALF_LENGTH + ":" + position.getY() + 64); System.out.println(position.getX() + LENGTH + ":" + position.getY() +
         * 48); System.out.println(position.getX() + HALF_LENGTH + ":" + position.getY() + 32);
         */
        return poly;
    }

    public static boolean containsPoint(Polygon polygon, Position position) {
        // for (int i = 0; i < 4; i++) {
        // System.out.println(polygon.xpoints[i] + ";" + polygon.ypoints[i]);
        // }
        // System.out.println(x + " + " + y);
        return polygon.contains(new Point(position.getX(), position.getY()));
    }

}
