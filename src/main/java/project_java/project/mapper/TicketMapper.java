package project_java.project.mapper;


import org.springframework.stereotype.Component;
import project_java.project.dto.TicketRequest;
import project_java.project.models.Ticket;

@Component
public class TicketMapper {
    public Ticket ticketRequestToTicket(TicketRequest ticketRequest){
        return new Ticket(ticketRequest.getCustomerId(), ticketRequest.getPerformanceId());
    }
}

