package project_java.project.mapper;


import org.springframework.stereotype.Component;
import project_java.project.dto.RoomRequest;
import project_java.project.models.Room;
import project_java.project.repositories.RoomRepository;


@Component
public class RoomMapper {
    public Room roomRequestToRoom(RoomRequest roomRequest){
        return new Room(roomRequest.getName());
    }
}
