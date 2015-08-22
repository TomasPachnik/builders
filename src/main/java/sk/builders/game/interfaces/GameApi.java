package sk.builders.game.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sk.builders.game.bo.Building;
import sk.builders.game.bo.Position;
import sk.builders.game.results.Result;

public interface GameApi {

    Result build(Building building);

    Result destroy(Position position);
    
    void save() throws FileNotFoundException, UnsupportedEncodingException;
    
    void load() throws FileNotFoundException, IOException;

}
