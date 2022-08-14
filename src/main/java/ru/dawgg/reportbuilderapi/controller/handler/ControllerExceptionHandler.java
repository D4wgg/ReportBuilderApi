package ru.dawgg.reportbuilderapi.controller.handler;

import java.sql.SQLSyntaxErrorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.dawgg.reportbuilderapi.exception.InvalidFieldNameException;
import ru.dawgg.reportbuilderapi.exception.InvalidIdException;
import ru.dawgg.reportbuilderapi.exception.TableNotFoundException;
import ru.dawgg.reportbuilderapi.exception.TableAlreadyExistsException;
import ru.dawgg.reportbuilderapi.exception.TableQueryNotFoundException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validationExceptionHandler(MethodArgumentNotValidException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorMessage> invalidIdExceptionHandler(InvalidIdException ex) {
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

    @ExceptionHandler(TableNotFoundException.class)
    public ResponseEntity<ErrorMessage> tableNotFoundExceptionHandler(TableNotFoundException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(TableQueryNotFoundException.class)
    public ResponseEntity<ErrorMessage> tableQueryNotFoundExceptionHandler(TableQueryNotFoundException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<ErrorMessage> sqlSyntaxErrorExceptionHandler(SQLSyntaxErrorException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ErrorMessage> jdbcConnectionExceptionHandler(JDBCConnectionException ex) {
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
