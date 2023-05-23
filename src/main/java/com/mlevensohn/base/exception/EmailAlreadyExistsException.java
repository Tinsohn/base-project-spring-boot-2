package com.mlevensohn.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {
    public EmailAlreadyExistsException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
