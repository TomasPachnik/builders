package sk.builders.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;

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

    private static boolean containsPoint(Polygon polygon, Position position) {
        return polygon.contains(new Point(position.getX(), position.getY()));
    }

    public static Position calculateReverse(Position p, Map map) {
        for (int i = 0; i < map.getMap()[0].length; i++) {
            for (int j = 0; j < map.getMap()[1].length; j++) {
                if (Utils.containsPoint(map.getBuilding(new Position(i, j)).getPolygon(), new Position(p.getX() - Utils.OFFSET_X, p.getY() - Utils.OFFSET_Y))) {
                    return map.getBuilding(new Position(i, j)).getPosition();
                }
            }
        }
        return null;
    }

    public static List<Position> aStar(Position start, Position destination) {
        List<AStarNode> open = new LinkedList<AStarNode>();
        List<AStarNode> closed = new LinkedList<AStarNode>();
        open.add(new AStarNode(getH(start, destination), start));
        AStarNode best = getBestNode(open);
        while (best.getPosition() != destination) {
            if (!listContainsPosition(closed, best.getPosition())) {
                closed.add(best);
            }
            if ((best.getPosition().getX() == destination.getX()) && (best.getPosition().getY() == destination.getY())) {
                List<Position> returnList = new LinkedList<Position>();
                for (AStarNode node : closed) {
                    returnList.add(node.getPosition());
                }
                return returnList;
            }
            List<Position> neighbors = getClosestPositions(best.getPosition());
            for (Position position : neighbors) {
                if (listContainsPosition(closed, position) && (getH(position, destination) < best.getValue())) {
                    AStarNode node = getNode(closed, position);
                    node.setValue(getH(position, destination));
                    best = node;
                } else {
                    if (listContainsPosition(open, position) && (getH(position, destination) < best.getValue())) {
                        best = new AStarNode(getH(position, destination), position);
                    } else {
                        if (!listContainsPosition(open, position)) {
                            open.add(new AStarNode(getH(position, destination), position));
                        }
                    }
                }
            }

        }
        return new LinkedList<Position>();
    }

    private static AStarNode getNode(List<AStarNode> list, Position position) {
        for (AStarNode node : list) {
            if (node.getPosition() == position) {
                return node;
            }
        }
        return null;
    }

    private static boolean listContainsPosition(List<AStarNode> list, Position position) {
        for (AStarNode node : list) {
            if ((node.getPosition().getX() == position.getX()) && (node.getPosition().getY() == position.getY())) {
                return true;
            }
        }
        return false;
    }

    public static double getH(Position start, Position destination) {
        return Math.sqrt(Math.pow((start.getX() - destination.getX()), 2) + Math.pow((start.getY() - destination.getY()), 2));
    }

    private static AStarNode getBestNode(List<AStarNode> list) {
        double value = Double.MAX_VALUE;
        AStarNode aStarNode = null;
        for (AStarNode node : list) {
            if (node.getValue() < value) {
                value = node.getValue();
                aStarNode = node;
            }
        }
        return aStarNode;
    }

    /**
     * return list of closest tiles
     * 
     * @param start
     * @return
     */
    private static List<Position> getClosestPositions(Position start) {
        List<Position> list = new LinkedList<Position>();
        if (start.getX() != 0) {
            list.add(new Position(start.getX() - 1, start.getY()));
        }
        if (start.getY() != 0) {
            list.add(new Position(start.getX(), start.getY() - 1));
        }
        list.add(new Position(start.getX(), start.getY() + 1));
        list.add(new Position(start.getX() + 1, start.getY()));
        return list;
    }
}
