package peaksoft.exeptions;

public class JsonFileNotFoundExeption extends RuntimeException{

    public JsonFileNotFoundExeption(String message) {
        super(message);
    }
}
