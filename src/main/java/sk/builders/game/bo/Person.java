package sk.builders.game.bo;

public class Person {
    private Position position;

    public Person(Position position) {
        super();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void moveRightDown() {
        position = new Position(position.getX() + 2, position.getY() + 1);
    }

    public void moveRightUp() {
        position = new Position(position.getX() + 2, position.getY() - 1);
    }

    public void moveLeftDown() {
        position = new Position(position.getX() - 2, position.getY() + 1);
    }
    
    public void moveLeftUp() {
        position = new Position(position.getX() - 2, position.getY() - 1);
    }
}
