package sk.builders.game.bo;

import sk.builders.game.exceptions.WrongMapSizeException;

/**
 * jednoducha mapa pre development
 * 
 * @author Tomas
 *
 */
public class Map {

    private Building[][] map;

    public Map(int x, int y) throws WrongMapSizeException {
        if (x < 1 || y < 1) {
            throw new WrongMapSizeException();
        }
        this.map = new Building[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = new Terrain(new Position(i, j));
                map[i][j].setPosition(new Position(i, j));
            }
        }
    }

    public Map() throws WrongMapSizeException {
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
