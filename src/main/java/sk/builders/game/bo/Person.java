package sk.builders.game.bo;

import sk.builders.utils.Utils;

public class Person {
    private Position position;
    private Position totalPosition;
    private int tact;
    private boolean leftHand;

    public Person(Position position) {
        super();
        this.position = position;
        this.totalPosition = position;
        this.tact = 0;
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
        tact++;
        leftHand = !leftHand;
        Position pos = Utils.calculatePosition(position);
        pos.setX(pos.getX() + (tact * 2));
        pos.setY(pos.getY() + tact);
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
        if (tact >= 16) {
            tact = 0;
            position.setX(position.getX() + 1);
        }
    }

    public void moveRightUp() {
        tact++;
        leftHand = !leftHand;
        Position pos = Utils.calculatePosition(position);
        pos.setX(pos.getX() + (tact * 2));
        pos.setY(pos.getY() - tact);
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
        if (tact >= 16) {
            tact = 0;
            position.setY(position.getY() - 1);
            position.setX(position.getX() - 1);
        }
    }

    public void moveLeftDown() {
        tact++;
        leftHand = !leftHand;
        Position pos = Utils.calculatePosition(position);
        pos.setX(pos.getX() - (tact * 2));
        pos.setY(pos.getY() + tact);
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
        if (tact >= 16) {
            tact = 0;
            position.setY(position.getY() + 1);
        }
    }

    public void moveLeftUp() {
        System.out.println(position);
        leftHand = !leftHand;
        tact++;
        Position pos = Utils.calculatePosition(position);
        pos.setX(pos.getX() + 32 - (tact * 2));
        pos.setY(pos.getY() + 16 - tact);
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
        if (tact >= 16) {
            tact = 0;
        }
    }

    public boolean isLeftHand() {
        return leftHand;
    }
}
