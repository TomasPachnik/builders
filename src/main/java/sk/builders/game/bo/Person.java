package sk.builders.game.bo;

import sk.builders.utils.Utils;

public class Person {
    private Position position;
    private Position positionInTile;
    private Position totalPosition;

    public Person(Position position) {
        super();
        this.position = position;
        positionInTile = new Position(0, 0);
        this.totalPosition = position;
    }

    public Position getPosition() {
        return position;
    }

    public Position getTotal() {
        return totalPosition;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void moveRightDown() {
        positionInTile = new Position(positionInTile.getX() + 2, positionInTile.getY() + 1);
        if (positionInTile.getX() > 31 || positionInTile.getY() > 15) {
            position.setX(position.getX() + 1);
            positionInTile.setX(0);
            positionInTile.setY(0);
        }
        move();
    }

    public void moveRightUp() {
        positionInTile = new Position(positionInTile.getX() + 2, positionInTile.getY() - 1);
        if (positionInTile.getX() > 31 || positionInTile.getY() > 15) {
            position.setY(position.getY() - 1);
            positionInTile.setX(0);
            positionInTile.setY(0);
        }
        move();
    }

    public void moveLeftDown() {
        positionInTile = new Position(positionInTile.getX() - 2, positionInTile.getY() + 1);
        if (positionInTile.getX() < -31 || positionInTile.getY() < -15) {
            position.setY(position.getY() + 1);
            positionInTile.setX(0);
            positionInTile.setY(0);
        }
        move();
    }

    public void moveLeftUp() {
        positionInTile = new Position(positionInTile.getX() - 2, positionInTile.getY() - 1);
        if (positionInTile.getX() < -31 || positionInTile.getY() < -15) {
            position.setX(position.getX() - 1);
            positionInTile.setX(0);
            positionInTile.setY(0);
        }
        move();
    }

    private void move() {
        Position pos = Utils.calculatePosition(position);
        pos.setX(pos.getX() + positionInTile.getX());
        pos.setY(pos.getY() + positionInTile.getY());
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
        System.out.println(position);
    }
}
