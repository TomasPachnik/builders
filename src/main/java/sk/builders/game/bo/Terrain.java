package sk.builders.game.bo;

import sk.builders.game.enums.Type;

public class Terrain extends Building {

	public Terrain() {
		super(Type.TERRAIN, new Position(0, 0));
	}
}
