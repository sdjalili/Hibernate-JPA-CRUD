package sd.demo.ioc.common.exceptions;

public class NoRecordsFoundException extends RuntimeException{
    public NoRecordsFoundException(String errorMessage) {
        super(errorMessage);
    }
}
