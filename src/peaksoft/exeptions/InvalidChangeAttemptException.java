package peaksoft.exeptions;

public class InvalidChangeAttemptException extends RuntimeException{

    public InvalidChangeAttemptException() {
    }

    public InvalidChangeAttemptException(String message) {
        super(message);
    }
}
