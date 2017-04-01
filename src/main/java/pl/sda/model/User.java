package pl.sda.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login", unique = true)
    @Size(min = 5, message = "Minimum 5 characters")
    @NotBlank(message = "Login nie może być pusty.")
    @Pattern(regexp = "[a-z-A-Z-0-9]*", message = "You can youse only letters and digits.")
    private String login;

    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be empty.")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be empty.")
    private String lastName;

    @Column(name = "contact_number")
    @NotBlank(message = "You need to specify phone number.")
    private String contactNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String role;

    @Column(name = "enabled")
    @NotNull
    private boolean enabled;


    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
