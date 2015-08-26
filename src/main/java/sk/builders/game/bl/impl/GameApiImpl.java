package sk.builders.game.bl.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.GameLogic;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Castle;
import sk.builders.game.bo.Forest;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Mountain;
import sk.builders.game.bo.Position;
import sk.builders.game.bo.Terrain;
import sk.builders.game.enums.Type;
import sk.builders.game.interfaces.GameApi;
import sk.builders.game.results.EverythingOk;
import sk.builders.game.results.Result;

public class GameApiImpl implements GameApi {

    @Autowired
    private Map map;
    @Autowired
    private GameLogic gameLogic;

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
        if (foundBuilding.getType() == Type.WOODCUTTER) {
            gameLogic.removeByUuid(foundBuilding.getWorker().getUuid());
            map.setBuilding(new Terrain(position), position);
        }
        return new EverythingOk();

    }

    @Override
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("map.map", "UTF-8");
        for (int i = 0; i < map.getMap()[0].length; i++) {
            String string = "";
            for (int j = 0; j < map.getMap()[1].length; j++) {
                string += map.getMap()[i][j].getType().getId();
                string += ";";
            }
            writer.println(string);
        }
        writer.close();
    }

    @Override
    public void load(String name) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(name + ".map")))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                for (int j = 0; j < map.getMap()[1].length; j++) {
                    switch (lines[j]) {
                    case "1":
                        map.getMap()[count][j] = new Forest(new Position(count, j));
                        break;
                    case "2":
                        map.getMap()[count][j] = new Forest(new Position(count, j));
                        break;
                    case "3":
                        map.getMap()[count][j] = new Mountain(new Position(count, j));
                        break;
                    case "4":
                        map.getMap()[count][j] = new Castle(new Position(count, j));
                        break;
                    default:
                        map.getMap()[count][j] = new Terrain(new Position(count, j));
                        break;
                    }
                }
                count++;
            }
        }

    }
}
