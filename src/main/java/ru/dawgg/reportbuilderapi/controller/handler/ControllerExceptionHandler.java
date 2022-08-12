package ru.dawgg.reportbuilderapi.controller.handler;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validationExceptionHandler(MethodArgumentNotValidException ex) {
        return commonMessage(HttpStatus.NOT_ACCEPTABLE, ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> someExceptionHandler(RuntimeException ex) {
        return commonMessage(HttpStatus.BAD_REQUEST, ex);
    }

    private ResponseEntity<ErrorMessage> commonMessage(HttpStatus httpStatus, Exception ex) {
        var message = ex.getMessage();
        log.error(message, ex);
        return new ResponseEntity<>(
                ErrorMessage.builder().message(message).stackTrace(ExceptionUtils.getStackTrace(ex)).build(),
                httpStatus
        );
    }
}
