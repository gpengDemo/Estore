package cn.nsu.edu.estore.exception;

public class RegistException extends Exception {
    public RegistException() {
        super();
    }

    public RegistException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RegistException(String message, Throwable cause) {
        super(message, cause);

    }

    public RegistException(String message) {
        super(message);
    }

    public RegistException(Throwable cause) {
        super(cause);
    }
}
