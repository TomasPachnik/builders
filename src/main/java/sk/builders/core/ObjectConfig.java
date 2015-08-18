package sk.builders.core;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.game.bl.impl.GameApiImpl;
import sk.builders.game.bo.Map;
import sk.builders.game.exceptions.WrongMapSizeException;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.DisplayMap;
import sk.builders.gui.MainScreen;
import sk.builders.mas.core.MasCore;
import static sk.builders.utils.Utils.MAIN_RESOURCE_PATH;

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

    @Bean
    public BufferedImage castle() throws IOException {
        return ImageIO.read(new File(MAIN_RESOURCE_PATH + "castle.png"));
    }
    
    @Bean
    public BufferedImage grass() throws IOException {
        return ImageIO.read(new File(MAIN_RESOURCE_PATH + "grass.png"));
    }

}
