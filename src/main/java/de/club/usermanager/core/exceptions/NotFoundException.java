package de.club.usermanager.core.exceptions;

import java.io.Serial;

public class NotFoundException extends Exception {


    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public NotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public NotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }


}
