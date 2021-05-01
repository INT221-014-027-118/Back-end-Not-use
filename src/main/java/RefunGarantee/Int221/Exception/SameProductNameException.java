package RefunGarantee.Int221.Exception;

public class SameProductNameException extends RuntimeException{


    public SameProductNameException(String name) {
        super("Product: " + name + " has all ready exist in the table");
    }
}
