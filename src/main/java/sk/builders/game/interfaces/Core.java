package sk.builders.game.interfaces;

import sk.builders.core.exceptions.BeanNotFoundException;

public interface Core extends Runnable {

    Object getByName(String name) throws BeanNotFoundException;
}
