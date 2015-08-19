package sk.builders.game.bo;

import sk.builders.game.enums.Type;

public class Terrain extends Building {

    public Terrain(Position position) {
        super(Type.TERRAIN, position);
    }
}
