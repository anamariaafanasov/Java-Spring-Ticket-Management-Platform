package project_java.project.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project_java.project.dto.TicketRequest;
import project_java.project.models.Ticket;
import project_java.project.queries.TicketQueries;
import project_java.project.utils.NoFutureTicketsFoundException;
import project_java.project.utils.NoHistoryFoundException;
import project_java.project.utils.ObjectNotFoundException;


import java.util.List;

@Repository
public class TicketRepository {

    private JdbcTemplate jdbcTemplate;

    public TicketRepository(JdbcTemplate template){jdbcTemplate = template;}

    public List<Ticket> getTickets(){
        return jdbcTemplate.query(TicketQueries.GET_TICKETS_SQL,new BeanPropertyRowMapper<>(Ticket.class));
    }

    public Ticket addTicket(Ticket ticket){
        jdbcTemplate.update(TicketQueries.ADD_TICKET,ticket.getCustomerId(), ticket.getPerformanceId());
        List <Ticket> query = jdbcTemplate.query(TicketQueries.GET_TICKETS_SQL,new BeanPropertyRowMapper<>());
        int lastId = query.get(query.size()-1).getId();
        ticket.setId(lastId);
        return ticket;
    }

    public List<Ticket> deleteTicket(int id){
        jdbcTemplate.update(TicketQueries.DELETE_TICKET,id);
        return jdbcTemplate.query(TicketQueries.GET_TICKETS_SQL,new BeanPropertyRowMapper<>(Ticket.class));
    }

    public List<Ticket> getHistory(int idCustomer){
        List <Ticket> query = jdbcTemplate.query(TicketQueries.GET_HISTORY_TICKETS,new BeanPropertyRowMapper<>(Ticket.class),idCustomer );
        if (query.stream().findAny() != null)
            if (query.size() == 0)
            {
                throw new NoHistoryFoundException(idCustomer);
            }
            else return query;
        else throw new ObjectNotFoundException("Customer with id "+ idCustomer+" was not found.");
    }

    public List<Ticket> getFutureTickets(int idCustomer){
        List <Ticket> query = jdbcTemplate.query(TicketQueries.GET_FUTURE_TICKETS,new BeanPropertyRowMapper<>(Ticket.class),idCustomer );
        if (query.stream().findAny() != null)
            if (query.size() == 0)
            {
                throw new NoFutureTicketsFoundException(idCustomer);
            }
            else return query;
        else throw new ObjectNotFoundException("Customer with id "+ idCustomer+" was not found.");
    }


}
