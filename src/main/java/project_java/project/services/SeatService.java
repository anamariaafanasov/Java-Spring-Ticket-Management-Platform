package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.dto.SeatRequest;
import project_java.project.models.Seat;
import project_java.project.repositories.SeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeats(){
        return seatRepository.getSeats();
    }
    public List<Seat> getAvailableSeatsByPerformanceId(int performanceId){

        return seatRepository.getAvailableSeatsByPerformanceId(performanceId);
    }
    public List<Seat> getBookedSeatsByPerformanceId(int performanceId){

        return seatRepository.getBookedSeatsByPerformanceId(performanceId);
    }

    public Seat bookSeat(int performanceId, int rowNumber, String rowLetter){
        return seatRepository.bookSeat(performanceId,rowNumber, rowLetter);
    }

    public Seat addSeat(Seat seat){
        return seatRepository.addSeat(seat);
    }

    public List <Seat> deleteSeatById(int id){
        return seatRepository.deleteSeat(id);
    }
}
