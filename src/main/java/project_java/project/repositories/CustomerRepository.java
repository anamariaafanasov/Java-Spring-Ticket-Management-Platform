package project_java.project.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project_java.project.dto.CustomerRequest;
import project_java.project.models.Category;
import project_java.project.models.Customer;
import project_java.project.queries.CategoryQueries;
import project_java.project.queries.CustomerQueries;
import project_java.project.utils.DuplicateCustomerException;

import java.util.List;

@Repository
public class CustomerRepository {

    private JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate template){jdbcTemplate = template;}

    public Customer addCustomer (Customer customer){
        List<Customer> query = jdbcTemplate.query(CustomerQueries.GET_CUSTOMERS_SQL, new BeanPropertyRowMapper<>(Customer.class));
        boolean foundCustomer = query.stream().filter(elem ->elem.getEmail() == customer.getEmail()).findFirst() != null;
        if (foundCustomer)
//            throw new DuplicateCustomerException(customer.getEmail());
            return null;

        else
        {
            jdbcTemplate.update(CustomerQueries.ADD_CUSTOMER, customer.getFirstName(), customer.getLastName(),
                    customer.getEmail(), customer.getPhoneNumber(), customer.getDateOfBirth());

            int last_id = query.get(query.size() - 1).getId();
            customer.setId(last_id);
            return customer;
        }
    }

    public List<CustomerRequest> getCustomers(){
        return jdbcTemplate.query(CustomerQueries.GET_CUSTOMERS_SQL,new BeanPropertyRowMapper<>(CustomerRequest.class));
    }
    public List<CustomerRequest> deleteCustomerById(int id){
        jdbcTemplate.update(CustomerQueries.DELETE_CUSTOMER,id);
        return jdbcTemplate.query(CustomerQueries.GET_CUSTOMERS_SQL,new BeanPropertyRowMapper<>(CustomerRequest.class));
    }

}
