package project_java.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import project_java.project.controllers.CustomerController;
import project_java.project.dto.CustomerRequest;
import project_java.project.mapper.CustomerMapper;
import project_java.project.models.Customer;
import project_java.project.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerMapper customerMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addNewCustomer() throws Exception{
        //arrange
        CustomerRequest customerRequest = new CustomerRequest("Daniel","Dan","dan@mail.com","0749412224", "20/04/1999");
        Customer customer = new Customer("Daniel","Dan","dan@mail.com","0749412224",new SimpleDateFormat("dd/MM/yyyy").parse("20/04/1999"));

        when(customerService.addCustomer(any())).thenReturn(customer);
        when(customerMapper.customerRequestToCustomer(any())).thenReturn(customer);
        mockMvc.perform(
                post("/customers")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(customerRequest))

        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(customer.getFirstName()));

    }

}
