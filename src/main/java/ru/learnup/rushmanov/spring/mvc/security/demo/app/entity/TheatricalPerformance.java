package ru.learnup.rushmanov.spring.mvc.security.demo.app.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="performances")
public class TheatricalPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String title;
    @Column(name="date_and_time")
    private String dateAndTime;
    @Column(name="age_category")
    private String ageCategory;
    @Column(name="number_of_seats")
    private int numberOfSeats;
    @Column(name="price_group1")
    private int ticketPrice1;
    @Column(name="price_group2")
    private int ticketPrice2;
    @Column(name="price_group3")
    private int ticketPrice3;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "theatrical_performance_id")
    private List<Ticket> ticketList = new ArrayList<>();



    public TheatricalPerformance(String title,
                                 String dateAndTime,
                                 String ageCategory,
                                 int ticketPrice1,
                                 int ticketPrice2,
                                 int ticketPrice3,
                                 Integer theatricalPerformanceId) {

        this.title = title;
        this.dateAndTime = dateAndTime;
        this.ageCategory = ageCategory;
        this.ticketPrice1=ticketPrice1;
        this.ticketPrice2=ticketPrice2;
        this.ticketPrice3=ticketPrice3;
        for (int i = 0; i < 10; i ++){

            this.ticketList.add(new Ticket(title, ticketPrice1, (i +1),null));
        }
        for (int i = 10; i < 20; i ++){
            this.ticketList.add(new Ticket(title, ticketPrice2, (i +1),null));
        }
        for (int i =20; i < 30; i ++){
            this.ticketList.add(new Ticket(title, ticketPrice3,  (i +1),null));
        }
        this.numberOfSeats = ticketList.size();
    }

    public TheatricalPerformance() {

    }


    public void setTicketList(String title,int ticketPrice1,
                              int ticketPrice2,
                              int ticketPrice3, Integer theatricalPerformanceId) {

            for (int i = 0; i < 10; i++) {

                this.ticketList.add(new Ticket(title, ticketPrice1, (i + 1),null));
            }
            for (int i = 10; i < 20; i++) {
                this.ticketList.add(new Ticket(title, ticketPrice2, (i + 1),null));
            }
            for (int i = 20; i < 30; i++) {
                this.ticketList.add(new Ticket(title, ticketPrice3, (i + 1),null));
            }

        this.numberOfSeats = ticketList.size();

    }



    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTicketPrice1() {
        return ticketPrice1;
    }

    public void setTicketPrice1(int ticketPrice1) {
        this.ticketPrice1 = ticketPrice1;
    }

    public int getTicketPrice2() {
        return ticketPrice2;
    }

    public void setTicketPrice2(int ticketPrice2) {
        this.ticketPrice2 = ticketPrice2;
    }

    public int getTicketPrice3() {
        return ticketPrice3;
    }

    public void setTicketPrice3(int ticketPrice3) {
        this.ticketPrice3 = ticketPrice3;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }



    @Override
    public String toString() {
        return
                "№:" + id + " '" +
                        title + '\'' +
                        ", Дата и время:'" + dateAndTime +
                        ", Возрастное ограничение:'" + ageCategory;
    }

    public void buyTicket (int seatNumber, int price){
        ticketList.get((seatNumber-1)).buy(price);
    }

    public void returnTicket (int seatNumber, int price){
        ticketList.get((seatNumber-1)).ticketRefund(price);
    }


}
