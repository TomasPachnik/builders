package sk.builders.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import sk.builders.core.annotations.Autowired;
import sk.builders.core.annotations.Bean;
import sk.builders.core.annotations.Config;
import sk.builders.core.exceptions.BeanNotFoundException;
import sk.builders.core.exceptions.MultipleBeansWithSameNameException;
import sk.builders.core.exceptions.WrongConfigClassException;
import sk.builders.game.interfaces.Core;
import sk.builders.gui.MainScreen;
import sk.builders.mas.agents.TimeAgent;
import sk.builders.mas.core.MasCore;
import sk.builders.mas.core.Message;

public class CoreImpl implements Core {

    private Map<String, Object> beans;

    public CoreImpl(Class<?> objectClass) {
        beans = new HashMap<String, Object>();
        try {
            build(objectClass);
            fill();
            this.run();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | WrongConfigClassException
                | MultipleBeansWithSameNameException | BeanNotFoundException e) {
            System.err.println(e);
        }
    }

    private void build(Class<?> objectClass) throws WrongConfigClassException, InstantiationException, IllegalAccessException,
            MultipleBeansWithSameNameException, IllegalArgumentException, InvocationTargetException {
        checkConfigClass(objectClass);
        Object object = objectClass.newInstance();

        for (Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(Bean.class)) {
                Object generatedObject = method.invoke(object);
                beans.put(method.getName(), generatedObject);
            }
        }
    }

    private void checkConfigClass(Class<?> objectClass) throws WrongConfigClassException {
        if (objectClass == null || !objectClass.isAnnotationPresent(Config.class)) {
            throw new WrongConfigClassException();
        }
    }

    private void fill() throws IllegalArgumentException, IllegalAccessException, BeanNotFoundException {
        for (Entry<String, Object> entry : beans.entrySet()) {
            for (Field field : entry.getValue().getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    if (field.getAnnotation(Autowired.class).value().equals("")) {
                        field.set(entry.getValue(), getByName(field.getName()));
                    } else {
                        field.set(entry.getValue(), getByName(field.getAnnotation(Autowired.class).value()));
                    }
                }
            }
        }
    }

    @Override
    public Object getByName(String name) throws BeanNotFoundException {
        if (beans.containsKey(name)) {
            return beans.get(name);
        } else {
            throw new BeanNotFoundException(name);
        }
    }

    @Override
    public void run() {
        MasCore core = null;
        MainScreen mainScreen = null;
        try {
            core = (MasCore) getByName("masCore");
            mainScreen = (MainScreen) getByName("mainScreen");
        } catch (BeanNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int sleep = 1000;
        TimeAgent agent = new TimeAgent(sleep);
        Message message = new Message(agent, agent, sleep, sleep);
        core.sendMessage(message);
        mainScreen.draw();
        core.start();

    }

}
