package sk.builders.game.interfaces;

import sk.builders.game.bo.Building;
import sk.builders.game.bo.Position;
import sk.builders.game.results.Result;

public interface GameApi {

    Result build(Building building);

    Result destroy(Position position);

}
