package ru.learnup.rushmanov.spring.mvc.security.demo.app.dao;



import ru.learnup.rushmanov.spring.mvc.security.demo.app.entity.Ticket;

import java.util.List;

public interface TicketDAO {

    public List<Ticket> getAllTickets(int id);

    public void buyTicket(int id, int seatNumber);

    public void refundTicket(int id, int seatNumber);
}
