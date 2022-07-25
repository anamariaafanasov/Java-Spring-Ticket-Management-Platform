package project_java.project.mapper;


import org.springframework.stereotype.Component;
import project_java.project.dto.SeatRequest;
import project_java.project.models.Seat;

@Component
public class SeatMapper {
    public Seat seatRequestToSeat(SeatRequest seatRequest){
        return new Seat(seatRequest.getRowNumber(),seatRequest.getRowLetter(),seatRequest.getRoomId(),
                seatRequest.getPerformanceId(), seatRequest.isBooked());

    }
}
