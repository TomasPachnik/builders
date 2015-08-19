package sk.builders.utils;

import java.awt.Point;
import java.awt.Polygon;

import sk.builders.game.bo.Position;

public class Utils {

	public static String MAIN_RESOURCE_PATH = "src/main/resources/";
	public static int length = 64;
	public static int halfLength = length / 2;

	public static Position calculatePosition(Position position) {
		int x = (position.getX() - position.getY()) * halfLength;
		int y = (position.getX() + position.getY()) * halfLength / 2;
		return new Position(x + 300, y);
	}

	public static Position calculateReverse(Position position) {
		position.setX(position.getX() - 300);
		int x = (position.getX() / halfLength + position.getY()
				/ (halfLength / 2)) / 2;
		int y = (position.getY() / (halfLength / 2) - (position.getX() / halfLength)) / 2;
		return new Position(x, y);
	}

	public static Polygon initPolygon(Position position) {
		Polygon poly = new Polygon();
		poly.addPoint((position.getX() * halfLength) + 300,
				(position.getY() * halfLength) + 48);
		poly.addPoint((position.getX() * halfLength) + (length / 2) + 300,
				(position.getY() * halfLength) + 64);
		poly.addPoint((position.getX() * halfLength) + length + 300,
				(position.getY() * halfLength) + 48);
		poly.addPoint((position.getX() * halfLength) + (length / 2) + 300,
				(position.getY() * halfLength) + 32);

		return poly;
	}

	public static boolean containsPoint(Polygon polygon, int x, int y) {
		for (int i = 0; i < 4; i++) {
			System.out.println(polygon.xpoints[i] + ";" + polygon.ypoints[i]);
		}
		System.out.println(x + " + " + y);
		return polygon.contains(new Point(x, y));
	}

}
