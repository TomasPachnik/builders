package sk.builders.game.bo;

import sk.builders.game.enums.Type;

public class Forest extends Building {

    private int wood;

    public Forest(Position position) {
        super(Type.FOREST, position);
        this.wood = 10;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

}
