package project_java.project.queries;

public class PerformanceQueries {
    public final static String GET_PERFORMANCE_SQL = "select * from performance";
    public final static String GET_PERFORMANCES_BY_CATEGORY = "select p.id,p.name, p.ticketPrice, p.start, p.end FROM performance p  join category c on p.categoryId = c.id Where c.name = ?";
    public final static String GET_PERFORMANCES_BY_ROOM = "select  p.id,p.name, p.ticketPrice, p.start, p.end FROM performance p join room r on p.roomId = r.id where r.name = ? ";
    public final static String BUY_TICKET_AT_PERFORMANCE_BY_SEAT = "INSERT INTO performance(id,name,ticketPrice, start, end,  categoryId) values (null,?,?,?,?,?)";
    public final static String ADD_PERFORMANCE ="INSERT INTO performance(id,name,ticketPrice, start, end, categoryId) values (null,?,?,?,?,?)";
    public final static String DELETE_PERFORMANCE ="DELETE FROM performance where id = ?";
}
