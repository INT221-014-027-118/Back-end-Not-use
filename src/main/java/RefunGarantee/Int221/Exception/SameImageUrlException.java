package RefunGarantee.Int221.Exception;

public class SameImageUrlException extends RuntimeException{
    public SameImageUrlException(String name){
        super("Imageurl: " + name + " has all ready in database");
    }
}
