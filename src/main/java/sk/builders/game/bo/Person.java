package sk.builders.game.bo;

import java.util.List;

import sk.builders.game.enums.Direction;
import sk.builders.utils.Utils;

public class Person {
    private Position position;
    private Position totalPosition;
    private int tact;
    private boolean leftHand;
    private List<Direction> movement;
    // actual direction
    private Direction direction;

    public Person(Position position) {
        super();
        this.position = position;
        this.totalPosition = position;
        this.tact = 0;
        direction = Direction.STAY;
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

    public void move() {
        if (tact < 16) {
            tact++;
            switch (direction) {
            case RIGHT_UP:
                moveRightUp();
                break;
            case LEFT_UP:
                moveLeftUp();
                break;
            case LEFT_DOWN:
                moveLeftDown();
                break;
            case RIGHT_DOWN:
                moveRightDown();
                break;
            case WORK:
                // TODO dorobit
                break;
            case STAY:
                tact = 0;
                break;
            }
        } else {
            if (!movement.isEmpty()) {
                direction = movement.get(0);
                movement.remove(0);
            } else {
                direction = Direction.STAY;
            }
        }
    }

    private void moveRightDown() {
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

    private void moveRightUp() {
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

    private void moveLeftDown() {
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

    private void moveLeftUp() {
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

    public List<Direction> getMovement() {
        return movement;
    }

    public void setMovement(List<Direction> movement) {
        this.movement = movement;
    }
}
