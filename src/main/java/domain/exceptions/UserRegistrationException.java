package domain.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRegistrationException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserRegistrationException() {
        super();
        log.error("User registration exception occurred");
    }

    public UserRegistrationException(String message) {
        super(message);
        log.error("User registration exception occurred: {}", message);
    }

    public UserRegistrationException(String message, Throwable cause) {
        super(message, cause);
        log.error("User registration exception occurred: {}", message, cause);
    }

    public UserRegistrationException(Throwable cause) {
        super(cause);
        log.error("User registration exception occurred", cause);
    }
}