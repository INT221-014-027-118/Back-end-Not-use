package RefunGarantee.Int221.Exception;

public class NotFoundNameException extends RuntimeException{
    public NotFoundNameException(String name) {
        super("Could not find product name: " + name);
    }
}
