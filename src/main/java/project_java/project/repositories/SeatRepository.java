package project_java.project.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project_java.project.dto.SeatRequest;
import project_java.project.models.Seat;
import project_java.project.queries.SeatQueries;
import project_java.project.utils.ObjectNotFoundException;
import project_java.project.utils.SeatNotFoundException;


import java.util.List;
import java.util.Optional;

@Repository
public class SeatRepository {

    private JdbcTemplate jdbcTemplate;

    public SeatRepository(JdbcTemplate template) {
        jdbcTemplate = template;
    }

    public List<Seat> getSeats() {
        return jdbcTemplate.query(SeatQueries.GET_SEATS_SQL, new BeanPropertyRowMapper<>(Seat.class));
    }


    public Seat addSeat(Seat seat) {
        jdbcTemplate.update(SeatQueries.ADD_SEAT, seat.getRowNumber(), seat.getRowLetter(), seat.isBooked(), seat.getRoomId(), seat.getPerformanceId());
        List<Seat> query = jdbcTemplate.query(SeatQueries.GET_SEATS_SQL, new BeanPropertyRowMapper<>());
        int lastId = query.get(query.size()-1).getId();
        seat.setId(lastId);
        return seat;

    }

    public List<Seat> deleteSeat(int id) {
        jdbcTemplate.update(SeatQueries.DELETE_SEAT, id);
        return jdbcTemplate.query(SeatQueries.GET_SEATS_SQL, new BeanPropertyRowMapper<>());
    }

    public List<Seat> getAvailableSeatsByPerformanceId(int performanceId) {
        List <Seat>query = jdbcTemplate.query(SeatQueries.GET_AVAILABLE_SEATS, new BeanPropertyRowMapper<>(Seat.class), performanceId);
        if (query.size() != 0)
            return query;
        else
            throw new ObjectNotFoundException("No more seats left!!!");
    }

    public List<Seat> getBookedSeatsByPerformanceId(int performanceId) {
        return jdbcTemplate.query(SeatQueries.GET_BOOKED_SEATS, new BeanPropertyRowMapper<>(Seat.class), performanceId);

    }

    public Seat bookSeat(int performanceId , int rowNumber, String rowLetter){
        System.out.println(rowLetter);
        System.out.println(rowLetter.getClass().getName());

        jdbcTemplate.update(SeatQueries.BOOK_SEAT, performanceId, rowNumber, rowLetter);
        return jdbcTemplate.query(SeatQueries.GET_SEAT, new BeanPropertyRowMapper<>(Seat.class),performanceId, rowNumber, rowLetter)
                .stream().findFirst().orElseThrow( ()-> new SeatNotFoundException(performanceId,rowNumber,rowLetter)) ;
    }
}