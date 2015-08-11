package sk.builders.mas.core;

public class Message implements Comparable<Message> {

    private Agent sender;
    private Agent recipient;
    private long sendTime;
    private long executeTime;
    private Object content;

    public Message(Agent sender, Agent recipient, long sendTime, long receiveTime, Object content) {
        super();
        this.sender = sender;
        this.recipient = recipient;
        this.sendTime = sendTime;
        this.executeTime = receiveTime;
        this.content = content;
    }

    public Message(Agent sender, Agent recipient, long sendTime, long receiveTime) {
        super();
        this.sender = sender;
        this.recipient = recipient;
        this.sendTime = sendTime;
        this.executeTime = receiveTime;
    }

    public Agent getSender() {
        return sender;
    }

    public void setSender(Agent sender) {
        this.sender = sender;
    }

    public Agent getRecipient() {
        return recipient;
    }

    public void setRecipient(Agent recipient) {
        this.recipient = recipient;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int compareTo(Message o) {
        if (this.getExecuteTime() < o.getExecuteTime()) {
            return -1;
        }
        if (this.getExecuteTime() > o.getExecuteTime()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Message [sender=" + sender + ", recipient=" + recipient + ", sendTime=" + sendTime + ", executeTime=" + executeTime + ", content=" + content
                + "]";
    }

}
