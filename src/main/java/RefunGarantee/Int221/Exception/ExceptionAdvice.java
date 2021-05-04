package RefunGarantee.Int221.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFound(NotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SameProductNameException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String productSameName(SameProductNameException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotFoundNameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundName(NotFoundNameException ex){
        return ex.getMessage();
    }


}
