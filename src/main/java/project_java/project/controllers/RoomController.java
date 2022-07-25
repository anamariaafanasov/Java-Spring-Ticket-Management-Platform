package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.RoomRequest;
import project_java.project.mapper.RoomMapper;
import project_java.project.models.Room;
import project_java.project.models.Room;
import project_java.project.services.RoomService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    private RoomMapper roomMapper;

    @GetMapping("/get")
    public List<RoomRequest> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping
    public  ResponseEntity<Room> addRoom(@Valid @RequestBody RoomRequest roomRequest) {

        Room room = roomMapper.roomRequestToRoom(roomRequest);
        Room recieved_room = roomService.addRoom(room);
        return ResponseEntity
                .created(URI.create("/rooms/" + roomRequest.getName())).body(recieved_room);
    }

    @DeleteMapping("/delete")
    public List<RoomRequest> deleteRoomById(@RequestParam int id) {
        return roomService.deleteRoomById(id);
    }
}
