package project_java.project.mapper;

import org.springframework.stereotype.Component;

import project_java.project.dto.CustomerRequest;
import project_java.project.models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class CustomerMapper {
    public Customer customerRequestToCustomer(CustomerRequest customerRequest) throws ParseException {
        return new Customer(customerRequest.getFirstName(), customerRequest.getLastName(),
                customerRequest.getEmail(), customerRequest.getPhoneNumber(), new java.util.Date(new SimpleDateFormat("dd/MM/yyyy").parse(customerRequest.getDateOfBirth()).getTime()));
    }

}
