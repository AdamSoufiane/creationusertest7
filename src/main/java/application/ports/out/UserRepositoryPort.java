package application.ports.out;

import domain.entity.User;
import org.springframework.dao.DataAccessException;

/**
 * The UserRepositoryPort interface outlines the data access operations for the User entity,
 * such as saving a user and checking if an email is already in use.
 */
public interface UserRepositoryPort {

    /**
     * Persists a given User entity and returns the persisted entity.
     * Implementations of this method may throw DataAccessException if there is a problem with the database access.
     *
     * @param user the User entity to save
     * @return the saved User entity
     * @throws DataAccessException if there is a problem with the database access
     */
    User saveUser(User user) throws DataAccessException;

    /**
     * Checks if a User entity with the provided email address already exists in the system.
     * Implementations of this method may throw DataAccessException if there is a problem with the database access.
     *
     * @param email the email address to check
     * @return true if a User with the email exists, otherwise false
     * @throws DataAccessException if there is a problem with the database access
     */
    boolean existsByEmail(String email) throws DataAccessException;
}