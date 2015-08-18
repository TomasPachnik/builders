package sk.builders.utils;

import sk.builders.game.bo.Position;

public class Utils {

    public static String MAIN_RESOURCE_PATH = "src/main/resources/";
    public static int length = 64/2;

    public static Position calculatePosition(Position position) {
        int x = (position.getX() - position.getY()) * length;
        int y = (position.getX() + position.getY()) * length / 2;
        return new Position(x+300, y);
    }

    public static Position calculateReverse(Position position) {
        position.setX(position.getX()-300);
        int x = (position.getX() / length + position.getY() / (length / 2)) / 2;
        int y = (position.getY() / (length / 2) - (position.getX() / length)) / 2;
        return new Position(x-1, y);
    }
}
