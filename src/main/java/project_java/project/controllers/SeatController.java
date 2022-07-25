package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.SeatRequest;
import project_java.project.mapper.SeatMapper;
import project_java.project.models.Seat;
import project_java.project.services.SeatService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/seats")
public class SeatController {

    private SeatService seatService;
    private SeatMapper seatMapper;

    public SeatController(SeatService seatService, SeatMapper seatMapper) {
        this.seatService = seatService;
        this.seatMapper = seatMapper;
    }

    @GetMapping("/get")
    public List <Seat> getSeats() {

        return seatService.getSeats();
    }

    @PostMapping
    public ResponseEntity<Seat> addSeat(@Valid @RequestBody SeatRequest seatRequest) {
        Seat seat = seatMapper.seatRequestToSeat(seatRequest);
        Seat recievedSeat = seatService.addSeat(seat);
        return ResponseEntity
                .created(URI.create("/seats" + seatRequest.getRowNumber() + seatRequest.getRowLetter() +
                        seatRequest.getRoomId() + seatRequest.getPerformanceId() + seatRequest.isBooked()))
                .body(recievedSeat);
    }

    @DeleteMapping("/delete")
    public List<Seat> deleteSeatById(@RequestParam int id) {
        return seatService.deleteSeatById(id);
    }

    @GetMapping("/available")
    public List<Seat> getAvailableSeatsByPerformanceId(@RequestParam int performanceId) {
        return seatService.getAvailableSeatsByPerformanceId(performanceId);
    }

    @GetMapping("/booked")
    public List<Seat> getBookedSeatsByPerformanceId( @RequestParam int performanceId) {
        return seatService.getBookedSeatsByPerformanceId(performanceId);
    }

    @GetMapping("/book-seat")
    public Seat bookSeat(@RequestParam int performanceId, @RequestParam int rowNumber, @RequestParam String rowLetter) {
        return seatService.bookSeat(performanceId, rowNumber, rowLetter);
    }
}
