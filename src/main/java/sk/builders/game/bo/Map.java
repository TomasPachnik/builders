package sk.builders.game.bo;

import static sk.builders.utils.Utils.MAP_LENGTH;

import java.io.IOException;

/**
 * jednoducha mapa pre development
 * 
 * @author Tomas
 *
 */
public class Map {

    private Building[][] map;

    public Map() throws IOException {
        this.map = new Building[MAP_LENGTH][MAP_LENGTH];
        for (int i = 0; i < MAP_LENGTH; i++) {
            for (int j = 0; j < MAP_LENGTH; j++) {
                map[i][j] = new Terrain(new Position(i, j));
                map[i][j].setPosition(new Position(i, j));
            }
        }
    }

    public Building[][] getMap() {
        return map;
    }

    public Building getBuilding(Position position) {
        return map[position.getX()][position.getY()];
    }

    public void setBuilding(Building building, Position position) {
        building.setPosition(position);
        map[position.getX()][position.getY()] = building;
    }

}
