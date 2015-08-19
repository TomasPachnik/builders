package main;

import java.awt.Polygon;

import org.junit.Test;

import sk.builders.core.CoreImpl;
import sk.builders.core.ObjectConfig;
import sk.builders.game.bo.Position;
import sk.builders.utils.Utils;

public class MainTest {

    @Test
    public void main() {
         new CoreImpl(ObjectConfig.class);
        Position p = new Position(2, 1);
        Utils.calculatePosition(p);
        Utils.calculateReverse(Utils.calculatePosition(p));
    	/*
    	final Polygon polygon = new Polygon();
        polygon.addPoint(300, 48);
        polygon.addPoint(332,64);
        polygon.addPoint(364,48);
        polygon.addPoint(332,32);

        System.out.println(polygon.contains(332, 46));*/
    }

}
