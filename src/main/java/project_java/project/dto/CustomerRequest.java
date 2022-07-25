package project_java.project.dto;

import javax.validation.constraints.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import static project_java.project.dto.PatternRequest.PHONENUMBER;

public class CustomerRequest {

    @NotBlank (message = "First name field is required")
    @Size(min=3, max=50)
    private String firstName;
    @NotBlank (message = "Last name field is required")
    @Size(min=3, max=50)
    private String lastName;
    @NotBlank(message = "Email field is required")
    @Email
    private String email;
    @NotBlank(message = "Phonenumber field is required")
    @Pattern(regexp = PHONENUMBER)
    private String phoneNumber;
    private String dateOfBirth;

    public CustomerRequest(){

    }

    public CustomerRequest(String firstName, String lastName, String email, String phoneNumber, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
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

    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
