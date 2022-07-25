package project_java.project.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import project_java.project.utils.ErrorResponse;
import project_java.project.utils.ObjectNotFoundException;

import java.util.Objects;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> performanceCategoryValidation(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest()
                .body("Invalid value " + Objects.requireNonNull(exception.getFieldError()).getRejectedValue()
                        + " for field " + exception.getFieldError().getField()
                        + " with message: " + exception.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> retriveCategoryValidation(RuntimeException exception){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ParseException.class})
    public ResponseEntity<Object> wrongParsing( ParseException exception){
        Map<String,Object> body = new HashMap<>();
        body.put("errOffset", exception.getErrorOffset());
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }


}