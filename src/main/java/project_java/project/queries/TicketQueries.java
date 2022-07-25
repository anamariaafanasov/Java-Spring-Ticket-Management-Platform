package project_java.project.queries;

public class TicketQueries {
    public final static String GET_TICKETS_SQL = " SELECT * FROM ticket";
    public final static String GET_CUSTOMER_TICKETS = " SELECT * FROM ticket where customerId = ?";
    public final static String GET_HISTORY_TICKETS = "select * from ticket t join performance p on t.performanceId = p.id where t.customerId = ?  and p.start < sysdate()";
    public final static String GET_FUTURE_TICKETS = " select *\n" +
            "from ticket t join performance p on t.performanceId = p.id\n" +
            "where t.customerId = ?  and p.start >= sysdate()";
    public final static String ADD_TICKET = "INSERT INTO ticket(id,customerId, performanceId) VALUES(null,?,?)";
    public final static String DELETE_TICKET = "DELETE FROM ticket WHERE id=?";
}
