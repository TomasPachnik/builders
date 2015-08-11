package sk.builders.mas.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sk.builders.mas.exceptions.BackInTimeException;

public class Core {

    private long simulationTime;
    private List<Message> messageCalendar;

    public Core() {
        this.simulationTime = 0;
        this.messageCalendar = new ArrayList<Message>();
    }

    public long getSimulationTime() {
        return simulationTime;
    }

    public void sendMessage(Message message) {
        messageCalendar.add(message);
        Collections.sort(messageCalendar);
    }

    public void start() {
        try {
            run();
        } catch (BackInTimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private void run() throws BackInTimeException {
        while (!messageCalendar.isEmpty()) {
            Message message = messageCalendar.get(0);
            if (message.getExecuteTime() < simulationTime) {
                throw new BackInTimeException();
            }
            simulationTime = message.getExecuteTime();
            messageCalendar.remove(0);
            message.getRecipient().perform(this, message);
        }
    }

}
