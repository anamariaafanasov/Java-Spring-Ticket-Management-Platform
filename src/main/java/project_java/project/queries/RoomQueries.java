package project_java.project.queries;

public class RoomQueries {
    public final static String GET_ROOMS_SQL = " SELECT * FROM room";
    public final static String ADD_ROOM = "INSERT INTO room(id,name) VALUES(null,?)";
    public final static String DELETE_ROOM = "DELETE FROM room WHERE id=?";
}
