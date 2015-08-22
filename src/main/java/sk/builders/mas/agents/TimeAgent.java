package sk.builders.mas.agents;

import sk.builders.mas.core.Agent;
import sk.builders.mas.core.MasCore;
import sk.builders.mas.core.Message;

public class TimeAgent extends Agent {

    private int sleep;
    private int count;
    private int direction;

    public TimeAgent(int sleep) {
        this.sleep = sleep;
        count = 0;
        direction = 0;
    }

    @Override
    public void perform(MasCore core, Message message) throws InterruptedException {
        if (count < 16) {
            count++;
            switch (direction) {
            case 0:
                core.getPerson().moveRightUp();
                break;
            case 1:
                core.getPerson().moveLeftUp();
                break;
            case 2:
                core.getPerson().moveLeftDown();
                break;
            case 3:
                core.getPerson().moveRightDown();
                break;
            }
        } else {
            count = 0;
            if (direction > 2) {
                direction = 0;
            } else {
                direction++;
            }

        }

        core.getDisplayer().repaint();
        message.setSendTime(core.getSimulationTime());
        message.setExecuteTime(core.getSimulationTime() + sleep);
        core.sendMessage(message);
         Thread.sleep(sleep);
    }

}
