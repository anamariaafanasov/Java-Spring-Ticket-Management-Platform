package project_java.project.queries;

public class SeatQueries {
    public final static String GET_SEATS_SQL = "SELECT * FROM SEAT";
    public final static String GET_SEAT = "SELECT * FROM seat where performanceId = ? and rowNumber = ? and rowLetter = ?";
    public final static String ADD_SEAT = "INSERT INTO SEAT(id,rowNumber, rowLetter, roomId, performanceId, booked) VALUES(null,?,?,?,?,?)";
    public final static String DELETE_SEAT = "DELETE FROM seat WHERE id=?";
    public final static String BOOK_SEAT = "Update Seat Set booked = true where  performanceId = ? and rowNumber = ? and rowLetter = ? ";
    public final static String GET_BOOKED_SEATS = "Select * from seat s join performance p on s.performanceId = p.id where s.booked = true and p.id = ?";
    public final static String GET_AVAILABLE_SEATS = "Select * from seat s join performance p on s.performanceId = p.id where s.booked = false and p.id = ?";
}
