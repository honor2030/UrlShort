package com.url.urlshort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e, HttpServletRequest request){

        ErrorResponse errorResponse = makeErrorResponse(e.getBindingResult());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request){

        ErrorResponse errorResponse = makeErrorResponse(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    private ErrorResponse makeErrorResponse(BindingResult bindingResult){
        String code = "";
        String description = "";

        if(bindingResult.hasErrors()){

            String bindResultCode = bindingResult.getFieldError().getCode();

            switch (bindResultCode){
                case "NotBlank":
                    code = ErrorCode.NOT_BLANK.getCode();
                    description = ErrorCode.NOT_BLANK.getDesc();
                    break;
                case "Pattern":
                    code = ErrorCode.NOT_VALID.getCode();
                    description = ErrorCode.NOT_VALID.getDesc();
                    break;
            }
        }

        return new ErrorResponse(code, description);
    }

    private ErrorResponse makeErrorResponse(String errorMessage){
        String code = "";
        String description = "";

        code = ErrorCode.ENTITY_NOT_FOUND.getCode();
        description = ErrorCode.ENTITY_NOT_FOUND.getDesc();

        return new ErrorResponse(code, description);
    }
}
