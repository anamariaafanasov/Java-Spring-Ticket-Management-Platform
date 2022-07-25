package project_java.project.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import project_java.project.dto.CustomerRequest;
import project_java.project.mapper.CustomerMapper;
import project_java.project.models.Customer;
import project_java.project.repositories.CustomerRepository;
import project_java.project.services.CustomerService;
import project_java.project.utils.DuplicateCustomerException;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @InjectMocks
    private CustomerMapper customerMapper;

    @Test
    @DisplayName("Add a new Customer - HappyFlow")
    public void createCustomerTest() throws ParseException {

        //arrange
        CustomerRequest customerRequest = new CustomerRequest("Preda", "Mihai", "mihai@gmail.com", "0732123123", "25/02/1999");
        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
        CustomerRequest savedCustomerRequest = new CustomerRequest("Preda", "Mihai", "mihai@gmail.com", "0732123123", "25/02/1999");
        Customer savedCustomer = customerMapper.customerRequestToCustomer(savedCustomerRequest);
        when(customerRepository.addCustomer(customer)).thenReturn(savedCustomer);

        //act
        Customer result = customerService.addCustomer(customer);

        //assert
        assertEquals(customer.getFirstName(), result.getFirstName());
        assertEquals(customer.getLastName(), result.getLastName());
        assertEquals(customer.getEmail(), result.getEmail());
        assertEquals(customer.getPhoneNumber(), result.getPhoneNumber());
        verify(customerRepository, times((1))).addCustomer(customer);
    }

    @Test
    @DisplayName("Add a new Customer - Duplicate email")
    public void createDuplicateCustomerTest() throws ParseException {

        //arrange
        CustomerRequest customerRequest = new CustomerRequest("Preda", "Mihai", "anamaria@mail.com", "0732123123", "25/02/1999");
        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
        CustomerRequest savedCustomerRequest = new CustomerRequest("Preda", "Mihai", "anamaria@mail.com", "0732123123", "25/02/1999");
        Customer savedCustomer = customerMapper.customerRequestToCustomer(savedCustomerRequest);
        when(customerRepository.addCustomer(any())).thenReturn(null);

        //act
        DuplicateCustomerException exception = assertThrows(DuplicateCustomerException.class, () -> customerService.addCustomer(customer));

        //assert
        assertEquals("A customer with email: " + customer.getEmail() + " already exists.", exception.getMessage());
        verify(customerRepository, times(1)).addCustomer(any());

    }

}