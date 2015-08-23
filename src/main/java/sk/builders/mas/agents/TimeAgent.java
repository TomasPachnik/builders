package sk.builders.mas.agents;

import sk.builders.mas.core.Agent;
import sk.builders.mas.core.MasCore;
import sk.builders.mas.core.Message;

public class TimeAgent extends Agent {

    private int sleep;

    public TimeAgent(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void perform(MasCore core, Message message) throws InterruptedException {
        core.getPerson().move();

        core.getDisplayer().repaint();
        message.setSendTime(core.getSimulationTime());
        message.setExecuteTime(core.getSimulationTime() + sleep);
        core.sendMessage(message);
        Thread.sleep(sleep);
    }

}
