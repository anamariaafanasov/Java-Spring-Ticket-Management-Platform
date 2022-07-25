package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.dto.TicketRequest;
import project_java.project.models.Ticket;
import project_java.project.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTickets(){
        return ticketRepository.getTickets();
    }

    public Ticket addTicket(Ticket Ticket){
        return ticketRepository.addTicket(Ticket);
    }

    public List <Ticket> deleteTicketById(int id){
        return ticketRepository.deleteTicket(id);
    }

    public List <Ticket> getHistoryByCustomerId(int customerId){
        return ticketRepository.getHistory(customerId);
    }

    public List <Ticket> getFutureTicketsByCustomerId(int customerId){
        return ticketRepository.getFutureTickets(customerId);
    }
}
