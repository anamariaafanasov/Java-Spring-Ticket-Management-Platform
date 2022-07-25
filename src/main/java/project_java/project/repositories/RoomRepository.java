package project_java.project.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project_java.project.dto.RoomRequest;
import project_java.project.models.Room;
import project_java.project.queries.RoomQueries;


import java.util.List;
@Repository
public class RoomRepository {

    private JdbcTemplate jdbcTemplate;

    public RoomRepository(JdbcTemplate template){jdbcTemplate = template;}

    public List<RoomRequest> getRooms(){
        return jdbcTemplate.query(RoomQueries.GET_ROOMS_SQL,new BeanPropertyRowMapper<>(RoomRequest.class));
    }

    public Room addRoom (Room room){
        jdbcTemplate.update(RoomQueries.ADD_ROOM, room.getName());
        List <Room> query = jdbcTemplate.query(RoomQueries.GET_ROOMS_SQL,new BeanPropertyRowMapper<>());
        int last_id = query.get(query.size()-1).getId();
        room.setId(last_id);

        return room;
    }

    public List<RoomRequest> deleteRoom(int id){
        jdbcTemplate.update(RoomQueries.DELETE_ROOM,id);
        return jdbcTemplate.query(RoomQueries.GET_ROOMS_SQL,new BeanPropertyRowMapper<>());
    }
}
