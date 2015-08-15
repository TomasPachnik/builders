package sk.builders.game.bo;

import sk.builders.game.enums.Type;

/**
 * zakladna trieda budovy
 * 
 * @author Tomas
 *
 */
public abstract class Building {

    private Type type;
    private Position position;

    public Building(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
