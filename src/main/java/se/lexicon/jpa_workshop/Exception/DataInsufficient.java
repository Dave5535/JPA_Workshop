package se.lexicon.jpa_workshop.Exception;

public class DataInsufficient extends Exception{
    private String message;

    public DataInsufficient(String message) {
        super(message);
    }
}
