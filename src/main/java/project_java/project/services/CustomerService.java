package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.dto.CustomerRequest;
import project_java.project.models.Customer;
import project_java.project.repositories.CustomerRepository;
import project_java.project.utils.DuplicateCustomerException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerRequest> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer addCustomer(Customer customer) {
//        Optional <Customer> existingCusomer = Optional.ofNullable(customerRepository.addCustomer(customer));
//        if(existingCusomer.isEmpty())
//            throw new DuplicateCustomerException(customer.getEmail());
       return customerRepository.addCustomer(customer);
    }


    public List<CustomerRequest> deleteCustomerById(int id) {
        return customerRepository.deleteCustomerById(id);
    }
}
