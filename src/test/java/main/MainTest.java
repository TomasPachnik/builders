package main;

import org.junit.Test;

import sk.builders.core.Core;
import sk.builders.core.ObjectConfig;
import sk.builders.game.bo.Map;
import sk.builders.game.exceptions.WrongMapSizeException;

public class MainTest {

    @Test
    public void coreStartTest() throws WrongMapSizeException {
        Core core = new Core(ObjectConfig.class);
    }
}
