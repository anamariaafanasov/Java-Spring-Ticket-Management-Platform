package project_java.project.utils;

public class DuplicateCustomerException extends RuntimeException{
    public DuplicateCustomerException(String email){
        super("A customer with email: " + email + " already exists.");

    }
}
