package sk.builders.game.bo;

import java.util.LinkedList;
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
        this.totalPosition = Utils.calculatePosition(position);
        this.totalPosition.setX(totalPosition.getX() + 26);
        this.totalPosition.setY(totalPosition.getY() + 16);
        this.tact = 0;
        this.movement = new LinkedList<Direction>();
        this.direction = Direction.STAY;
    }

    public void setDestination(Position destination) {
        if (direction != Direction.STAY) {
            switch (direction) {
            case LEFT_DOWN:
                movement = Utils.aStar(new Position(position.getX(), position.getY() + 1), destination);
                break;
            case LEFT_UP:
                movement = Utils.aStar(new Position(position.getX() - 1, position.getY()), destination);
                break;
            case RIGHT_DOWN:
                movement = Utils.aStar(new Position(position.getX() + 1, position.getY()), destination);
                break;
            case RIGHT_UP:
                movement = Utils.aStar(new Position(position.getX(), position.getY() - 1), destination);
                break;
            }
        } else {
            movement = Utils.aStar(position, destination);

        }
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
        if (tact > 0 && tact <= 16) {
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
                tact = 1;
            } else {
                direction = Direction.STAY;
            }
        }
    }

    private void moveRightDown() {
        Position pos = before();
        pos.setX(pos.getX() + (tact * 2));
        pos.setY(pos.getY() + tact);
        after(pos);
        if (tact >= 16) {
            tact = 0;
            position.setX(position.getX() + 1);
        }
    }

    private void moveRightUp() {
        if (tact == 2) {
            position.setY(position.getY() - 1);
        }
        Position pos = before();
        pos.setX(pos.getX() - 32 + (tact * 2));
        pos.setY(pos.getY() + 16 - tact);
        after(pos);
        if (tact >= 16) {
            tact = 0;
        }
    }

    private void moveLeftDown() {
        Position pos = before();
        pos.setX(pos.getX() - (tact * 2));
        pos.setY(pos.getY() + tact);
        after(pos);
        if (tact >= 16) {
            tact = 0;
            position.setY(position.getY() + 1);
        }
    }

    private void moveLeftUp() {
        if (tact == 2) {
            position.setX(position.getX() - 1);
        }
        Position pos = before();
        pos.setX(pos.getX() + 32 - (tact * 2));
        pos.setY(pos.getY() + 16 - tact);
        after(pos);
        if (tact >= 16) {
            tact = 0;
        }
    }

    private Position before() {
        tact++;
        leftHand = !leftHand;
        return Utils.calculatePosition(position);
    }

    private void after(Position pos) {
        totalPosition = pos;
        totalPosition.setX(totalPosition.getX() + 26);
        totalPosition.setY(totalPosition.getY() + 16);
    }

    public boolean isLeftHand() {
        return leftHand;
    }

    public List<Direction> getMovement() {
        return movement;
    }
}
