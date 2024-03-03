package infrastructure.persistence;

import application.ports.out.UserRepositoryPort;
import domain.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) throws DataAccessException {
        return userRepository.saveUser(user);
    }

    @Override
    public boolean existsByEmail(String email) throws DataAccessException {
        return userRepository.existsByEmail(email);
    }

}