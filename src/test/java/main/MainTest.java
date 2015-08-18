package main;

import org.junit.Test;

import sk.builders.core.CoreImpl;
import sk.builders.core.ObjectConfig;

public class MainTest {

    @Test
    public void main() {
        new CoreImpl(ObjectConfig.class);
    }

}
