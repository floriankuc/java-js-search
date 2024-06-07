package org.openapitools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ResponseStatusExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, HttpServletRequest request) {
            HttpStatus status = ex.getStatus();
            String errorMessage;

            switch (status) {
                case NOT_FOUND:
                    errorMessage = "Resource not found";
                    break;
                case BAD_REQUEST:
                    errorMessage = "Validation error";
                    break;
                default:
                    errorMessage = "Unexpected error";
                    break;
            }

            Map<String, String> errors = Map.of("errors", Objects.requireNonNullElse(ex.getReason(), errorMessage));
            CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), status.value(), errorMessage, request.getRequestURI(), errors);
            return new ResponseEntity<>(response, status);
    }
}
