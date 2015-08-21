package sk.builders.core;

import static sk.builders.utils.Utils.MAIN_RESOURCE_PATH;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.game.bl.impl.GameApiImpl;
import sk.builders.game.bo.Map;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.DisplayMap;
import sk.builders.gui.MainScreen;
import sk.builders.gui.bo.ImageBuffer;
import sk.builders.gui.listeners.ActionListeners;
import sk.builders.gui.listeners.MouseMotionEvent;
import sk.builders.gui.listeners.MousePositionRightPressed;
import sk.builders.mas.core.MasCore;

@Config
public class ObjectConfig {

    @Bean
    public Map map() throws IOException {
        return new Map();
    }

    @Bean
    public MousePositionRightPressed mousePositionRightPressed() {
        return new MousePositionRightPressed();
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
    public MouseMotionEvent mouseMotionEvent() {
        return new MouseMotionEvent();
    }
    
    @Bean
    public ActionListeners actionListeners() {
        return new ActionListeners();
    }
    
    @Bean
    public ImageBuffer imageBuffer() throws IOException{
        return new ImageBuffer();
    }

}
