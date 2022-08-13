package ru.dawgg.reportbuilderapi.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.dawgg.reportbuilderapi.exception.InvalidFieldNameException;
import ru.dawgg.reportbuilderapi.exception.TableAlreadyExistsException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validationExceptionHandler(MethodArgumentNotValidException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidFieldNameException.class)
    public ResponseEntity<ErrorMessage> invalidTableNameException(InvalidFieldNameException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(TableAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> tableAlreadyExceptionHandler(TableAlreadyExistsException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<ErrorMessage> commonMessage(Exception ex, HttpStatus httpStatus) {
        var message = ex.getMessage();
        log.error(message, ex);
        return new ResponseEntity<>(
                ErrorMessage.builder().message(message).stackTrace(ExceptionUtils.getStackTrace(ex)).build(),
                httpStatus
        );
    }
}
