package de.club.usermanager.core.exceptions;

import java.io.Serial;

public class NotPossibleOperationException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;



    public NotPossibleOperationException(String message) {
        super(message);
    }
}
