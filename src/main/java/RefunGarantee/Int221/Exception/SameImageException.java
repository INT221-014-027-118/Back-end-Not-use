package RefunGarantee.Int221.Exception;

public class SameImageException extends RuntimeException{

    public SameImageException(String name){
        super("Image: " + name + " has all ready in database");
    }
}
