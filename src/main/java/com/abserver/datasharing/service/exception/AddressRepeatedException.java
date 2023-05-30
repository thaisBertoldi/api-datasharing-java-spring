package com.abserver.datasharing.service.exception;

import java.io.Serial;

public class AddressRepeatedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AddressRepeatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressRepeatedException(String message) {
        super(message);
    }

}
