package sk.builders.game.bl;

import sk.builders.game.bo.Building;
import sk.builders.game.bo.Position;
import sk.builders.game.results.Result;

public interface GameApi {

    Result build(Building building, Position position);

}
