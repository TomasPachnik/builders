package sk.builders.mas.exceptions;

public class BackInTimeException extends Exception {
    private static final String message = "you can not send message back in time!";

    public BackInTimeException() {
        super(message);
    }

}
