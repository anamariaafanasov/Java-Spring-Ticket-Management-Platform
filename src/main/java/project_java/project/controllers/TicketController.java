package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.TicketRequest;
import project_java.project.dto.TicketRequest;
import project_java.project.mapper.TicketMapper;
import project_java.project.models.Ticket;
import project_java.project.services.TicketService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private TicketService ticketService;
    private TicketMapper ticketMapper;

    public TicketController(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping("/get")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @PostMapping
    public ResponseEntity<Ticket> addTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketMapper.ticketRequestToTicket(ticketRequest);
        Ticket receivedTicket = ticketService.addTicket(ticket);
        return ResponseEntity
                .created(URI.create("/tickets" + ticketRequest.getCustomerId() + ticketRequest.getPerformanceId()))
                .body(receivedTicket);
    }
   

//    @PostMapping("buy")
//    public List<Ticket> BuyTicketByPerformance(@RequestParam int performanceId){
//        return ticketService.BuyTicketByPerformance(performanceId);
//    }

    @DeleteMapping("/delete")
    public List<Ticket> deleteTicketById(@RequestParam int id) {
        return ticketService.deleteTicketById(id);
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistoryByCustomerId(@RequestParam int customerId){
        return ResponseEntity.ok().body(ticketService.getHistoryByCustomerId(customerId));
    }

    @GetMapping("/futureTickets")
    public ResponseEntity<?>  getFutureTicketsByCustomerId(@RequestParam int customerId){
        return  ResponseEntity.ok().body(ticketService.getFutureTicketsByCustomerId(customerId));
    }

}
