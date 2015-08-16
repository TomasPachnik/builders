package sk.builders.main;

import sk.builders.core.CoreImpl;
import sk.builders.core.ObjectConfig;

public class Main {

    public static void main(String[] args) {
        new CoreImpl(ObjectConfig.class);
    }
}
