package application;

public class ModelException extends Exception {
    protected String msg;

    public ModelException(String message) {
        msg = message;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

