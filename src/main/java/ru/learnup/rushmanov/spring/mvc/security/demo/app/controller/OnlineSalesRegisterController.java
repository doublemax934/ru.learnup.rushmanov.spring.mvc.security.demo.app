package ru.learnup.rushmanov.spring.mvc.security.demo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.learnup.rushmanov.spring.mvc.security.demo.app.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.security.demo.app.entity.Ticket;
import ru.learnup.rushmanov.spring.mvc.security.demo.app.service.OnlineSalesRegisterService;

import java.util.List;


@Controller
public class OnlineSalesRegisterController {

    @Autowired
    private OnlineSalesRegisterService onlineSalesRegisterService;

    @RequestMapping("/")
    public String showAllPerformances(Model model) {
        List<TheatricalPerformance> allPerformance = onlineSalesRegisterService.getAllPerformances();
        model.addAttribute("allPerformance", allPerformance);
        return "all-performances";
    }

    @RequestMapping("/addNewPerformance")
    public String addNewPerformance(Model model) {
        TheatricalPerformance performance = new TheatricalPerformance();
        model.addAttribute("performance", performance);
        return "performance-info";
    }

    @RequestMapping("/saveNewPerformance")
    public String saveNewPerformance(@ModelAttribute("performance") TheatricalPerformance performance) {
        onlineSalesRegisterService.saveNewPerformance(performance);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updatePerformance(@RequestParam("perfId") int id, Model model) {
        TheatricalPerformance performance = onlineSalesRegisterService.getPerformance(id);
        model.addAttribute("performance", performance);
        return "performance-info";
    }

    @RequestMapping("/deletePerformance")
    public String deletePerformance(@RequestParam("perfId") int id) {
        onlineSalesRegisterService.deletePerformance(id);
        return "redirect:/";
    }

    @RequestMapping("/viewAllTickets")
    public String viewAllTickets(@RequestParam("perfId") int id, Model model) {
        List<Ticket> allTickets = onlineSalesRegisterService.getAllTickets(id);
        model.addAttribute("allTickets", allTickets);
        return "ticket-list";
    }

    @RequestMapping("/buyTicket")
    public String buyTicket(@RequestParam("tickId") int id, @RequestParam("seatNumber") int seatNumber) {
        onlineSalesRegisterService.buyTicket(id, seatNumber);
        return "redirect:/";
    }

    @RequestMapping("/refundTicket")
    public String refundTicket(@RequestParam("tickId") int id, @RequestParam("seatNumber") int seatNumber) {
        onlineSalesRegisterService.refundTicket(id, seatNumber);
        return "redirect:/";
    }

}
