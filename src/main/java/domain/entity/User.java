package domain.entity;

import java.time.LocalDateTime;
import util.validator.Validator;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public User() {
        // No-argument constructor for JPA and other frameworks
    }

    public User(Long id, String name, String email, String password, boolean active, LocalDateTime createdAt) {
        if (!Validator.validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (!Validator.validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password format.");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
    }

    public void setEmail(String email) {
        if (!Validator.validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (!Validator.validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password format.");
        }
        this.password = password;
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword) || !Validator.validatePassword(newPassword)) {
            throw new IllegalArgumentException("Invalid old password or new password does not meet criteria.");
        }
        this.password = newPassword;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean validate() {
        return this.id != null &&
               this.name != null && !this.name.trim().isEmpty() &&
               Validator.validateEmail(this.email) &&
               Validator.validatePassword(this.password) &&
               this.createdAt != null &&
               (this.lastLogin == null || this.lastLogin.isBefore(LocalDateTime.now())) &&
               this.active == (this.active == true || this.active == false);
        // Note: 'active' is a primitive boolean, so it is always a valid boolean state
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", active=" + active +
               ", createdAt=" + createdAt +
               ", lastLogin=" + lastLogin +
               '}';
    }
}
