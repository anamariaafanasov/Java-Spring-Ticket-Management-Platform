package project_java.project.queries;

public class CustomerQueries {
    public final static String GET_CUSTOMERS_SQL = "select * from customer";
    public final static String ADD_CUSTOMER ="INSERT INTO customer(id,firstName,lastName, email, phoneNumber, dateOfBirth) values (null,?,?,?,?,?)";
    public final static String DELETE_CUSTOMER ="DELETE FROM customer where id = ?";

}
