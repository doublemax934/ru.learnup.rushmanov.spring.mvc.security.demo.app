package ru.learnup.rushmanov.spring.mvc.security.demo.app.service;


import ru.learnup.rushmanov.spring.mvc.security.demo.app.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.security.demo.app.entity.Ticket;

import java.util.List;

public interface OnlineSalesRegisterService {

    public List<TheatricalPerformance> getAllPerformances();

    public void saveNewPerformance(TheatricalPerformance performance);

    public TheatricalPerformance getPerformance(int id);

    public void deletePerformance (int id);

    public List<Ticket> getAllTickets(int id);

    public void buyTicket(int id, int seatNumber);

    public void refundTicket(int id, int seatNumber);
}
