package se.lexicon.jpa_workshop.Exception;

public class DataWasNotFound extends Exception{
    private String message;

    public DataWasNotFound(String message) {
        super(message);
    }
}
