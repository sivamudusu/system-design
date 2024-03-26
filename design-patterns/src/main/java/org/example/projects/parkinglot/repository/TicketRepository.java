package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.TicketNotFoundException;
import org.example.projects.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> tickets;
    private static int id = 0;


    public TicketRepository() {
        this.tickets = new HashMap<>();
    }

    public Ticket getTicket(int ticketId){
        Ticket ticket = tickets.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Ticket not found for Id:"+ticketId );
        }
        return ticket;
    }
    public Ticket addTicket(Ticket ticket){
        ticket.setId(++id);
        tickets.put(ticket.getId(), ticket);
        System.out.println("ticket has been added to db successfully");
        return tickets.get(id);
    }
}
