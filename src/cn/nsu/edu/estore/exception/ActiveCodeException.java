package cn.nsu.edu.estore.exception;

@SuppressWarnings("all")
public class ActiveCodeException extends Exception{
    public ActiveCodeException() {
        super();
    }

    public ActiveCodeException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ActiveCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActiveCodeException(String message) {
        super(message);
    }

    public ActiveCodeException(Throwable cause) {
        super(cause);
    }

}
