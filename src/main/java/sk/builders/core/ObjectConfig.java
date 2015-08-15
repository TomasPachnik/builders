package sk.builders.core;

import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.game.bl.GameApi;
import sk.builders.game.bl.impl.GameApiImpl;
import sk.builders.game.bo.Map;
import sk.builders.game.exceptions.WrongMapSizeException;

@Config
public class ObjectConfig {

    @Bean
    public Map map() throws WrongMapSizeException {
        return new Map(10, 10);
    }

    @Bean
    public GameApi gameApi() {
        return new GameApiImpl();
    }

}
