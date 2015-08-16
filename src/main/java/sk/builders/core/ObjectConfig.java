package sk.builders.core;

import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.game.bl.impl.GameApiImpl;
import sk.builders.game.bo.Map;
import sk.builders.game.exceptions.WrongMapSizeException;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.DisplayMap;
import sk.builders.gui.MainScreen;
import sk.builders.mas.core.MasCore;

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

    @Bean
    public MainScreen mainScreen() {
        return new MainScreen();
    }

    @Bean
    public MasCore masCore() {
        return new MasCore();
    }

    @Bean
    public DisplayMap displayMap() {
        return new DisplayMap();
    }

}
