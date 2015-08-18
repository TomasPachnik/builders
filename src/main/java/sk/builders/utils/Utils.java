package sk.builders.utils;

import sk.builders.game.bo.Position;

public class Utils {

    public static String MAIN_RESOURCE_PATH = "src/main/resources/";
    public static int length = 64;

    public static Position calculatePosition(Position position) {
        int x = position.getX() * length;
        int y = position.getY() * length / 4;
        if (position.getY() % 2 == 1) {
            x = x + length / 2;
        }
        return new Position(x, y);
    }

}
