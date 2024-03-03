package application.ports.in;

import infrastructure.rest.dto.UserRequest;
import infrastructure.rest.dto.UserResponse;
import domain.exceptions.UserRegistrationException;

/**
 * The UserRegistrationUseCase interface defines the contract for the application service to register a new user,
 * ensuring that the core application logic is decoupled from external concerns.
 */
public interface UserRegistrationUseCase {

    /**
     * Register a new user in the system with the provided user details and return the registered user data.
     *
     * @param userRequest the user details
     * @return the registered user data
     * @throws UserRegistrationException if the registration process fails
     */
    UserResponse registerUser(UserRequest userRequest) throws UserRegistrationException;

}