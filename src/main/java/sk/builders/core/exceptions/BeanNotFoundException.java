package sk.builders.core.exceptions;

public class BeanNotFoundException extends Exception {

    public BeanNotFoundException(String name) {
        super("Bean '" + name + "' not found");
    }
}
