package sk.builders.mas.agents;

import sk.builders.mas.core.Agent;
import sk.builders.mas.core.Core;
import sk.builders.mas.core.Message;

public class TimeAgent extends Agent {

    @Override
    public void perform(Core core, Message message) {
        message.setSendTime(core.getSimulationTime());
        message.setExecuteTime(core.getSimulationTime() + 1000);
        core.sendMessage(message);
        System.out.println(core.getSimulationTime());
    }

}
