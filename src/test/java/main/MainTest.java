package main;

import org.junit.Test;
import sk.builders.game.bo.Position;
import sk.builders.utils.Utils;

public class MainTest {

    @Test
    public void main() {
        Position start = new Position(1, 2);
        Position destination = new Position(5, 3);
       // System.out.println(Utils.getH(start, destination));
        Utils.aStar(start, destination).forEach(System.out::println);
    }

}
