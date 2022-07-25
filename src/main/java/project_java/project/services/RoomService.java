package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.dto.RoomRequest;
import project_java.project.models.Room;
import project_java.project.repositories.RoomRepository;


import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomRequest> getRooms(){
        return roomRepository.getRooms();
    }

    public Room addRoom(Room room){
        return roomRepository.addRoom(room);
    }

    public List <RoomRequest> deleteRoomById(int id){
        return roomRepository.deleteRoom(id);
    }
}
