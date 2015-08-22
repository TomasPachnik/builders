package sk.builders.core;

import java.io.IOException;

import javax.swing.JButton;

import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.game.bl.impl.GameApiImpl;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Person;
import sk.builders.game.bo.Position;
import sk.builders.game.interfaces.GameApi;
import sk.builders.gui.Displayer;
import sk.builders.gui.MainScreen;
import sk.builders.gui.bo.ImageBuffer;
import sk.builders.gui.listeners.ActionListeners;
import sk.builders.gui.listeners.ComboBoxListener;
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
    public Displayer displayMap() {
        return new Displayer();
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
    public ImageBuffer imageBuffer() throws IOException {
        return new ImageBuffer();
    }

    @Bean
    public ComboBoxListener comboBoxListener() {
        return new ComboBoxListener();
    }

    @Bean
    public JButton save() {
        return new JButton("uloz");
    }

    @Bean
    public JButton load() {
        return new JButton("nacitaj");
    }

    @Bean
    public Person person() {
        return new Person(new Position(92, 562));
    }
}
