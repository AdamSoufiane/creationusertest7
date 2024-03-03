package infrastructure.rest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * UserRequest is a data transfer object that contains the incoming user data for registration, such as name, email, and password.
 */
@Data
public class UserRequest {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Email
    @Size(min = 1, max = 100)
    private String email;

    @NotNull
    @Size(min = 1, max = 100)
    private String password;

    public UserRequest() {
    }
}