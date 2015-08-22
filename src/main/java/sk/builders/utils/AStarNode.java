package sk.builders.utils;

import sk.builders.game.bo.Position;

public class AStarNode {
    private double value;
    private Position position;

    public AStarNode(double value, Position position) {
        this.value = value;
        this.setPosition(position);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "AStarNode [value=" + value + ", position=" + position + "]";
    }

}
