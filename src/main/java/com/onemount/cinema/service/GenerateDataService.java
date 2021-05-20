package com.onemount.cinema.service;

import com.github.javafaker.Faker;
import com.onemount.cinema.enums.*;
import com.onemount.cinema.model.*;
import com.onemount.cinema.repository.CinemaRepository;
import com.onemount.cinema.repository.CustomerRepository;
import com.onemount.cinema.repository.EventRepository;
import com.onemount.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GenerateDataService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CustomerRepository customerRepository;

    private final Faker faker = new Faker();
    private final Random rand = new Random();

    private List<Film> films ;
    private List<Cinema> cinemas ;
    private List<Genre> genres;
    private List<Staff> staffs;
    private List<Room> rooms;
    private List<Seat> seats;
    private List<Actor> actors;
    private List<Event> events;
    private List<Customer> customers;
    private List<Order> orders;

    private void init(){
        films = new ArrayList<>();
        cinemas = new ArrayList<>();
        genres = new ArrayList<>();
        staffs = new ArrayList<>();
        rooms = new ArrayList<>();
        seats = new ArrayList<>();
        actors = new ArrayList<>();
        events = new ArrayList<>();
        customers = new ArrayList<>();
    }

    @Transactional
    public void generateCustomer(){

        Customer customer1 = new Customer("hust_dolphin", "Nguyen Van Huy", faker.code().imei(), "Ha Noi", "012909120192",
                new Date(), new Date(), 100, CustomerType.VIP);

        int randNum = rand.nextInt(2);
        List<Order> orderList1 = new ArrayList<>();
        Order order1 = new Order(PaymentMethod.values()[randNum], OrderStatus.PAID);
        List<OrderLine> orderLineList1 = new ArrayList<>();
        for(int i=0;i<3;i++){
            OrderLine orderLine = new OrderLine();
            Ticket ticket = new Ticket(faker.code().gtin8());
            orderLine.setOrder(order1);
            orderLine.setEvent(events.get(rand.nextInt((int) events.stream()
                    .filter(event -> event.getSeat().getRoom().getCinema().getName().equals("CGV Ba Trieu"))
                    .count())));
            orderLine.setStatus(OrderLineStatus.SUCCESS);
            orderLine.setTicket(ticket);
            orderLineList1.add(orderLine);
        }
        order1.setOrderLineList(orderLineList1);
        order1.setTotalAmount(orderLineList1.stream().mapToInt(orderLine -> orderLine.getEvent().getPrice()).sum());
        order1.setDiscount((float) (order1.getTotalAmount()*0.3));
        orderList1.add(order1);
        customer1.setOrders(orderList1);

        Customer customer2 = new Customer("zzzXZZZZXzzz", "Nguyen Van Z", faker.code().imei(), "Ha Noi", "0129827287312",
                new Date(), new Date(), 10, CustomerType.NORMAL);
        List<Order> orderList2 = new ArrayList<>();
        Order order2 = new Order(null, OrderStatus.NOT_PAID);
        List<OrderLine> orderLineList2 = new ArrayList<>();
        for(int i=0;i<4;i++){
            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(order2);
            orderLine.setEvent(events.get(rand.nextInt((int) events.stream()
                    .filter(event -> event.getSeat().getRoom().getCinema().getName().equals("CGV Kim Ma"))
                    .count())));
            orderLine.setStatus(OrderLineStatus.FAILURE);
            orderLineList2.add(orderLine);
        }
        order2.setOrderLineList(orderLineList2);
        orderList2.add(order2);
        customer2.setOrders(orderList2);

        customers.add(customer1);
        customers.add(customer2);
    }


    @Transactional
    public void generateGenre(){
        Genre adventure = new Genre("Adventure","");
        Genre comedy = new Genre("Comedy","");
        Genre cartoon = new Genre("Cartoon","");
        Genre fiction = new Genre("Fiction","");
        Genre fantastic = new Genre("Fantastic","");
        Genre horror = new Genre("Horror", "");
        Genre action = new Genre("Action", "");
        genres.add(adventure);
        genres.add(comedy);
        genres.add(cartoon);
        genres.add(fiction);
        genres.add(fantastic);
        genres.add(horror);
        genres.add(action);
    }


    @Transactional
    public void generateActor(){
        Actor actor1 = new Actor("Daniel Radcliffe", 31, "United Kingdom");
        Actor actor2 = new Actor("Rupert Grint", 32, "United Kingdom");
        Actor actor3 = new Actor("Emma Watson", 31, "United Kingdom");
        Actor actor4 = new Actor("Alan Rickman", "United Kingdom");
        Actor actor5 = new Actor("Wasabi Mizuta", "Japan");
        Actor actor6 = new Actor("Megumi Oohara", "Japan");
        Actor actor7 = new Actor("Subaru Kimura", "Japan");
        Actor actor8 = new Actor("Yumi Kakazu", "Japan");
        Actor actor9 = new Actor("Viktor Khorinyak", "Russia");
        Actor actor10 = new Actor("Mila Sivatskaya", "Russia");
        Actor actor11 = new Actor("Ekaterina Vilkova", "Russia");
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);
        actors.add(actor5);
        actors.add(actor6);
        actors.add(actor7);
        actors.add(actor8);
        actors.add(actor9);
        actors.add(actor10);
        actors.add(actor11);
    }

    @Transactional
    public void generateFilm() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        List<Actor> actorListFilm1 = new ArrayList<>(actors.subList(0,4));
        List<Genre> genreListFilm1 = new ArrayList<>();
        genreListFilm1.add(genres.get(0));
        genreListFilm1.add(genres.get(3));
        genreListFilm1.add(genres.get(4));
        Film film1 = new Film("Harry Potter and the deathly hallows",
                "Without the guidance and protection of their professors, Harry (Daniel Radcliffe), Ron (Rupert Grint) and Hermione (Emma Watson) begin a mission to destroy the Horcruxes, the sources of Voldemort's immortality.",
                null,120,formatter.parse("10/05/2021"),
                FilmStatus.ON_THEATER, actorListFilm1, genreListFilm1,null);

        List<Actor> actorListFilm2 = new ArrayList<>(actors.subList(4,8));
        List<Genre> genreListFilm2 = new ArrayList<>();
        genreListFilm2.add(genres.get(1));
        genreListFilm2.add(genres.get(2));
        Film film2 = new Film("DORAEMON: STAND BY ME 2",
                "Nobita - following his previous adventure - has managed to change his future for the better, making Shizuka marry him. Taken by despair, however, he decides to return to the past to re-meet his beloved grandmother, she died when he was still in kindergarten and to whom he was really fond of; grandmother is happy that Nobita came back in time to be with her, and confides in him a great desire: to meet his future bride",
                null,150,formatter.parse("15/07/2021"),
                FilmStatus.INCOMING, actorListFilm2, genreListFilm2,null);


        List<Actor> actorListFilm3 = new ArrayList<>(actors.subList(8,11));
        List<Genre> genreListFilm3 = new ArrayList<>();
        genreListFilm3.add(genres.get(0));
        genreListFilm3.add(genres.get(6));
        Film film3 = new Film("THE LAST WARRIOR: ROOT OF EVIL",
                "Peace and tranquility have set in Belogorie. The evil was defeated and Ivan is now enjoying his well-deserved fame. He is surrounded by his family, friends and small wonders from the modern world that help him lead a comfortable life. Luckily, he has his Magic Sword...",
                null,125,formatter.parse("30/04/2021"),
                FilmStatus.ON_THEATER, actorListFilm3, genreListFilm3,null);


        films.add(film1);
        films.add(film2);
        films.add(film3);

    }

    @Transactional
    public void generateSeat(){

        for(Room room: rooms){
            String[] rowList = {"A", "B", "C", "D"};
            List<Seat> roomSeat = new ArrayList<>();

            for (String row: rowList) {
                for (int i=0;i<5;i++){
                    Seat seat = new Seat(row,i);
                    seat.setRoom(room);
                    seats.add(seat);
                    roomSeat.add(seat);
                }
            }
            room.setSeats(roomSeat);
        }
    }


    @Transactional
    public void generateEvent() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        Date[] startTimeList = {formatter.parse("20/05/2021 07:00:00"), formatter.parse("20/05/2021 09:30:00"),
                                formatter.parse("20/05/2021 12:00:00"), formatter.parse("20/05/2021 14:30:00"),
                                formatter.parse("20/05/2021 17:00:00"), formatter.parse("20/05/2021 19:30:00")};

        Date[] endTimeList = {formatter.parse("20/05/2021 09:00:00"), formatter.parse("20/05/2021 11:30:00"),
                              formatter.parse("20/05/2021 14:00:00"), formatter.parse("20/05/2021 16:30:00"),
                              formatter.parse("20/05/2021 19:00:00"), formatter.parse("20/05/2021 21:30:00")};

        for(Cinema cinema: cinemas){
            for(Room room: cinema.getRooms()){
                for(Seat seat: room.getSeats()){
                    for (Film film: films){
                        List<Event> filmEvent = new ArrayList<>();
                        for(int i=0; i<startTimeList.length;i++){
                            Event event = new Event(startTimeList[i], endTimeList[i],
                                    faker.number().numberBetween(50000, 200000), EventStatus.AVAILABLE,
                                    film, seat);
                            filmEvent.add(event);
                            events.add(event);
                        }
                        film.setEvents(filmEvent);
                    }
                }
            }

        }
    }

    @Transactional
    public void generateRoomAndStaff(){

        for(Cinema cinema: cinemas){
            List<Staff> staffList = new ArrayList<>();
            List<Room> roomList = new ArrayList<>();

            for(int i=0; i<20;i++){
                Staff staff = new Staff(faker.name().fullName(), faker.code().asin(),faker.number().numberBetween(18,30));
                staffList.add(staff);
                staff.setCinema(cinema);
                staffs.add(staff);
            }
            for(int i=0;i<10;i++){
                Room room = new Room(faker.leagueOfLegends().champion());
                room.setCinema(cinema);
                rooms.add(room);
                roomList.add(room);
            }

            cinema.setRooms(roomList);
            cinema.setStaffs(staffList);
        }
    }

    @Transactional
    public void generateCinema(){
        Cinema cinema1 = new Cinema("CGV Ba Trieu", "40 Ba Trieu, Ha Noi");
        Cinema cinema2 = new Cinema("CGV Kim Ma", "120 Kim Ma, Ha Noi");
        cinemas.add(cinema1);
        cinemas.add(cinema2);
    }

    @Transactional
    public void generateSampleData() throws ParseException {

        init();
        generateActor();
        generateGenre();
        generateFilm();
        generateCinema();
        generateRoomAndStaff();
        generateSeat();
        generateEvent();
        generateCustomer();

        for(Film film: films){
            filmRepository.save(film);
        }
        for(Cinema cinema: cinemas){
            cinemaRepository.save(cinema);
        }
        for(Event event: events){
            eventRepository.save(event);
        }
        for(Customer customer: customers){
            customerRepository.save(customer);
        }
    }

}
