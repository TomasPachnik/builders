package sk.builders.game;

import java.util.ArrayList;
import java.util.List;
import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.enums.Direction;
import sk.builders.game.enums.Type;
import sk.builders.utils.Utils;

public class GameLogic {

    @Autowired
    private Map map;

    private List<Building> buildings;

    public GameLogic() {
        buildings = new ArrayList<Building>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void work() {
        for (Building building : buildings) {
            if (building.getWorker().getDirection() == Direction.STAY) {
                if (building.isWorkerHome()) {
                    findWork(building);
                } else {
                    goHome(building);
                }
            }
        }
    }

    private void goHome(Building building) {
        building.getWorker().setDestination(new Position(building.getPosition().getX() + 1, building.getPosition().getY() + 1));
    }

    private void findWork(Building building) {
        switch (building.getType()) {
        case WOODCUTTER:
            Position destination = findClosestTerrainType(building.getPosition(), Type.WOODCUTTER);
            building.getWorker().setDestination(new Position(destination.getX() + 1, destination.getY() + 1));
            break;
        }
    }

    private Position findClosestTerrainType(Position position, Type type) {
        double length = Double.MAX_VALUE;
        Position result = null;
        for (int j = 0; j < map.getMap()[1].length; j++) {
            for (int i = 0; i < map.getMap()[0].length; i++) {
                switch (map.getMap()[i][j].getType()) {
                case FOREST:
                    if (Utils.getH(position, new Position(i, j)) < length) {
                        length = Utils.getH(position, new Position(i, j));
                        result = new Position(i, j);
                    }
                    break;
                default:
                    break;
                }
            }
        }
        return result;
    }
}
