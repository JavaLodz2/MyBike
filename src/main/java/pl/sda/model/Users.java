package pl.sda.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login", unique = true)
    @NotBlank(message = "Login nie może być pusty.")
    @Pattern(regexp = "[a-z-A-Z-0-9]*", message = "Można używać tylko liter i cyfr.")
    private String login;

    @Column(name = "first_name")
    @NotBlank(message = "Imię nie może być puste.")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Nazwisko nie może być puste.")
    private String lastName;

    @Column(name = "contact_number")
    @NotBlank(message = "Podaj numer telefonu")
    private String contactNumber;

    @OneToOne(mappedBy = "userBorrowed")
    private Bikes bike;

    public Users() {
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

    public Bikes getBike() {
        return bike;
    }

    public void setBike(Bikes bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
