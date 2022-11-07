package com.bryan.bcnuwejump2digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EndpointNotDefinedException extends ResponseStatusException {
    public EndpointNotDefinedException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
