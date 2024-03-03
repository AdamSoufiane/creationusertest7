package infrastructure.rest;

import application.ports.in.UserRegistrationUseCase;
import domain.exceptions.UserNotFoundException;
import domain.exceptions.UserRegistrationException;
import infrastructure.rest.dto.UserRequest;
import infrastructure.rest.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRegistrationUseCase userRegistrationUseCase;

    public UserController(UserRegistrationUseCase userRegistrationUseCase) {
        this.userRegistrationUseCase = userRegistrationUseCase;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userRegistrationUseCase.registerUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<String> handleUserRegistrationException(UserRegistrationException exception) {
        return new ResponseEntity<>("User registration failed: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}