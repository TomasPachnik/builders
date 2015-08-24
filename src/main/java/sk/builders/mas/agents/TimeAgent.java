package sk.builders.mas.agents;

import java.util.Collections;
import java.util.List;

import sk.builders.game.bo.Building;
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

        core.getGameLogic().work();
        List<Building> list = Collections.synchronizedList(core.getGameLogic().getBuildings());
        for (Building building : list) {
            building.getWorker().move();
        }
        core.getDisplayer().repaint();
        message.setSendTime(core.getSimulationTime());
        message.setExecuteTime(core.getSimulationTime() + sleep);
        core.sendMessage(message);
        Thread.sleep(sleep);
    }

}
