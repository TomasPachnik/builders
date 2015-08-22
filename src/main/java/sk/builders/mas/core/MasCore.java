package sk.builders.mas.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Person;
import sk.builders.gui.Displayer;
import sk.builders.mas.exceptions.BackInTimeException;

public class MasCore {

    @Autowired
    private Map map;
    @Autowired
    private Displayer displayMap;
    @Autowired
    private Person person;

    public Person getPerson() {
        return person;
    }

    private long simulationTime;
    private List<Message> messageCalendar;

    public MasCore() {
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
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void run() throws BackInTimeException, InterruptedException {
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

    public Map getMap() {
        return map;
    }

    public Displayer getDisplayer() {
        return displayMap;
    }

}
