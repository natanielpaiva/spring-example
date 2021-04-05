package sonar.exemplo.sonarqube.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sonar.exemplo.sonarqube.controller.response.ErrorResponse;
import sonar.exemplo.sonarqube.exceptions.ResourceNotFoundException;

@ControllerAdvice
@Slf4j
public class InterceptController {

    private static final  String MESSAGE = "ERROR";

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorResponseResponseEntity(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .status(httpStatus.value())
                .build();
        log.error(MESSAGE, e);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorInvalid(MethodArgumentNotValidException e) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .status(httpStatus.value())
                .build();
        log.error(MESSAGE, e);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorInvalid(ResourceNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .status(httpStatus.value())
                .build();
        log.error(MESSAGE, e);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
