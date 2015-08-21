package sk.builders.game.bl.impl;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.bo.Terrain;
import sk.builders.game.enums.Type;
import sk.builders.game.interfaces.GameApi;
import sk.builders.game.results.EverythingOk;
import sk.builders.game.results.NoBuilding;
import sk.builders.game.results.NotEmptyPlace;
import sk.builders.game.results.Result;

public class GameApiImpl implements GameApi {

    @Autowired
    private Map map;

    @Override
    public Result build(Building building) {
        Building foundBuilding = map.getBuilding(building.getPosition());
        // if (foundBuilding.getType() == Type.TERRAIN) {
        map.setBuilding(building, building.getPosition());
        return new EverythingOk();
        // } else {
        // return new NotEmptyPlace();
        // }
    }

    @Override
    public Result destroy(Position position) {
        Building foundBuilding = map.getBuilding(position);
        if (foundBuilding.getType() == Type.BUILDING) {
            map.setBuilding(new Terrain(position), position);
            return new EverythingOk();
        } else {
            return new NoBuilding();
        }
    }
}
