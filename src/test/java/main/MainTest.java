package main;

import org.junit.Test;

import sk.builders.mas.agents.TimeAgent;
import sk.builders.mas.core.Core;
import sk.builders.mas.core.Message;

public class MainTest {

    @Test
    public void agentTest() {
        Core c = new Core();
        TimeAgent timeAgent = new TimeAgent();
        Message m1 = new Message(timeAgent, timeAgent, 0, 1000);
        c.sendMessage(m1);
        c.start();
    }
}
