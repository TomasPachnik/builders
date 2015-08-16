package sk.builders.mas.core;

public abstract class Agent {

    public abstract void perform(MasCore core, Message message) throws InterruptedException;

}
