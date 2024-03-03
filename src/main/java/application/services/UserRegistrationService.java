package application.services;

import application.ports.in.UserRegistrationUseCase;
import application.ports.out.UserRepositoryPort;
import domain.entity.User;
import domain.exceptions.UserAlreadyExistsException;
import infrastructure.rest.dto.UserRequest;
import infrastructure.rest.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegistrationService implements UserRegistrationUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public UserResponse registerUser(UserRequest userRequest) throws UserAlreadyExistsException {
        try {
            if (userRepositoryPort.existsByEmail(userRequest.getEmail())) {
                throw new UserAlreadyExistsException(userRequest.getEmail(), "USER_ALREADY_EXISTS");
            }

            User newUser = new User();
            newUser.setName(userRequest.getName());
            newUser.setEmail(userRequest.getEmail());
            newUser.setPassword(userRequest.getPassword());

            User savedUser = userRepositoryPort.saveUser(newUser);

            return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
        } catch (DataAccessException e) {
            // Handle the data access exception appropriately
            throw new RuntimeException("A data access error occurred during user registration.", e);
        }
    }
}