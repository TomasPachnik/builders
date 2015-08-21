package sk.builders.game.bo;

import sk.builders.game.enums.Type;
import sk.builders.utils.Utils;

public class Terrain extends Building {

    public Terrain(Position position) {
        super(Type.TERRAIN, position, Utils.getImage(Type.TERRAIN));
    }
}
