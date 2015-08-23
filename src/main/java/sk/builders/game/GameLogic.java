package sk.builders.game;

import java.util.ArrayList;
import java.util.List;

import sk.builders.game.bo.Building;

public class GameLogic {

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

}
