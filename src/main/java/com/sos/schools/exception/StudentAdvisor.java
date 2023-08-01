package com.sos.schools.exception;

import com.sos.schools.apis.StudentResource;
import com.sos.schools.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class StudentAdvisor {
    Logger logger = (Logger) LoggerFactory.getLogger(StudentResource.class);
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handelStudentNotFoundExecption(StudentNotFoundException ex, WebRequest request){
        logger.error("ERROR Student With ID Not Found");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(final MethodArgumentNotValidException exception, final HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        exceptionResponse.setErrors(errors);
        exceptionResponse.setRequestUrl(request.getRequestURI());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(final ConstraintViolationException exception, final HttpServletRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        Map<String, String> errors = new HashMap<>();
//        exception.getConstraintViolations().forEach((error) -> {
//            String fieldName = error.getPropertyPath().toString();
//            String errorMessage = error.getMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        exceptionResponse.setErrors(errors);
//        exceptionResponse.setRequestUrl(request.getRequestURI());
//
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex, HttpHeaders headers,
//            HttpStatusCode status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDate.now());
//        body.put("status", status.value());
//
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }

}
