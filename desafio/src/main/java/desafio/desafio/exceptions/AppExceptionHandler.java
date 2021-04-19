package desafio.desafio.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptions(Exception ex, WebRequest request) {
        String errordescription = ex.getLocalizedMessage();
        if(errordescription == null)
            errordescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errordescription);
        return new ResponseEntity<>(ex,new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }
}
