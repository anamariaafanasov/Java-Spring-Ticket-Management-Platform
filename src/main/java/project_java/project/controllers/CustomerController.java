package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.CategoryRequest;
import project_java.project.dto.CustomerRequest;
import project_java.project.mapper.CustomerMapper;
import project_java.project.models.Category;
import project_java.project.models.Customer;
import project_java.project.services.CustomerService;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private CustomerService customerService;
    private CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/get")
    public List<CustomerRequest> getCustomers() {

        return customerService.getCustomers();
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerRequest customerRequest) throws ParseException {
            Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
            Customer c = customerService.addCustomer(customer);
            return ResponseEntity
                    .created(URI.create("/customers/" + customerRequest.getFirstName() + customerRequest.getLastName() + customerRequest.getEmail() + customerRequest.getPhoneNumber() + customerRequest.getDateOfBirth())).body(c);

    }

    @DeleteMapping("/delete")
    public List<CustomerRequest> deleteCustomerById(@RequestParam int id) {
        return customerService.deleteCustomerById(id);
    }
}
