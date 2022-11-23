package com.bankaya.challenge.exception;

import challenge.carlosvelazquez.pokeapi.ServiceException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final ServiceException serviceException;

    /**
     * Create a new CustomException to set values in response body
     *
     * @param errorCode  error code value
     * @param message    error message description
     * @param httpStatus http status code
     * @param args       args to build message
     */
    public CustomException(String errorCode, String message, HttpStatus httpStatus, Object... args) {
        super(httpStatus.getReasonPhrase());
        ServiceException se = new ServiceException();
        se.setCode(errorCode);
        se.setMessage(String.format(message, args));
        se.setHttpStatusCode(httpStatus.toString());
        this.serviceException = se;
    }

}
