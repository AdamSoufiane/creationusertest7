package domain.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class UserAlreadyExistsException extends UserRegistrationException {

    private static final long serialVersionUID = 1L;

    private final String email;
    private final String errorCode;
    private final String errorMessage;

    public UserAlreadyExistsException() {
        super("User already exists.");
        this.email = null;
        this.errorCode = null;
        this.errorMessage = null;
    }

    public UserAlreadyExistsException(String email) {
        super(String.format("User with email %s already exists.", email));
        this.email = email;
        this.errorCode = null;
        this.errorMessage = null;
    }

    public UserAlreadyExistsException(String email, String errorCode) {
        super(String.format("User with email %s already exists. Error Code: %s", email, errorCode));
        this.email = email;
        this.errorCode = errorCode;
        this.errorMessage = null;
    }

    public UserAlreadyExistsException(String email, Throwable cause) {
        super(String.format("User with email %s already exists.", email), cause);
        this.email = email;
        this.errorCode = null;
        this.errorMessage = null;
    }

}