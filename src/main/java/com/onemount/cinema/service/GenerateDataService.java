package com.onemount.cinema.service;

import com.github.javafaker.Faker;
import com.onemount.cinema.enums.*;
import com.onemount.cinema.model.*;
import com.onemount.cinema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CastRepository castRepository;

    @Autowired
    FilmGenreRepository filmGenreRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    private final Faker faker = new Faker();
    private final Random rand = new Random();

    private List<Cinema> cinemas ;
    private List<Genre> genres;
    private List<Staff> staffs;
    private List<Room> rooms;
    private List<Seat> seats;
    private List<Actor> actors;
    private List<Event> events;
    private List<Customer> customers;
    private List<Booking> bookings;
    private List<Cast> casts;
    private List<FilmGenre> filmGenres;
    private List<Film> films;
    private List<Order> orders;
    private List<OrderLine> orderLines;
//    private List<Order> orders;

    private void init(){
        cinemas = new ArrayList<>();
        genres = new ArrayList<>();
        staffs = new ArrayList<>();
        rooms = new ArrayList<>();
        seats = new ArrayList<>();
        actors = new ArrayList<>();
        events = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
        casts = new ArrayList<>();
        filmGenres = new ArrayList<>();
        films = new ArrayList<>();
        orders = new ArrayList<>();
        orderLines = new ArrayList<>();
    }

    @Transactional
    public void generateCustomer(){

        Customer customer1 = new Customer("hust_dolphin", "Nguyen Van Huy", faker.code().imei(), "Ha Noi", "012909120192",
                new Date(), new Date(), 100, CustomerType.VIP);

        int randNum = rand.nextInt(2);
        List<Order> orderList1 = new ArrayList<>();
        Order order1 = new Order(PaymentMethod.values()[randNum], OrderStatus.SUCCESS);
        List<OrderLine> orderLineList1 = new ArrayList<>();
        for(int i=0;i<3;i++){
            OrderLine orderLine = new OrderLine();
            Ticket ticket = new Ticket(faker.code().gtin8());
            orderLine.setOrder(order1);
            Booking booking = bookings.get(rand.nextInt((int) bookings.stream()
                    .filter(event -> event.getSeat().getRoom().getCinema().getName().equals("VinCinema Ba Trieu"))
                    .count()));
            booking.setStatus(BookingStatus.RESERVED);
            orderLine.setBooking(booking);
            orderLine.setTime(new Time(new Date(), new Date()));
            orderLine.setTicket(ticket);
            orderLine.setCustomer(customer1);
            orderLine.setOrder(order1);
            orderLineList1.add(orderLine);
            orderLines.add(orderLine);
        }
        order1.setTotalAmount(orderLineList1.stream().mapToInt(orderLine -> orderLine.getBooking().getPrice()).sum());
        order1.setDiscount((float) (order1.getTotalAmount()*0.3));
        order1.setCustomer(customer1);
        orderList1.add(order1);
        orders.add(order1);
        Customer customer2 = new Customer("zzzXZZZZXzzz", "Nguyen Van Z", faker.code().imei(), "Ha Noi", "0129827287312",
                new Date(), new Date(), 10, CustomerType.NORMAL);
        List<Order> orderList2 = new ArrayList<>();
        Order order2 = new Order(null, OrderStatus.FAILURE);
        List<OrderLine> orderLineList2 = new ArrayList<>();
        for(int i=0;i<4;i++){
            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(order2);
            orderLine.setBooking(bookings.get(rand.nextInt((int) bookings.stream()
                    .filter(event -> event.getSeat().getRoom().getCinema().getName().equals("VinCinema Nguyen Du"))
                    .count())));
            orderLine.setTime(new Time(new Date(), new Date()));
            orderLine.setCustomer(customer2);
            orderLine.setOrder(order2);
            orderLineList2.add(orderLine);
            orderLines.add(orderLine);
        }
        order2.setCustomer(customer2);
        orderList2.add(order2);
        orders.add(order2);
        customers.add(customer1);
        customers.add(customer2);
    }


    @Transactional
    public void generateGenre(){
        Genre adventure = new Genre("Adventure","Implies a narrative that is defined by a journey (often including some form of pursuit) and is usually located within a fantasy or exoticized setting");
        Genre comedy = new Genre("Comedy","Defined by events that are primarily intended to make the audience laugh");
        Genre cartoon = new Genre("Cartoon","");
        Genre fiction = new Genre("Fiction","Adventure fiction is a genre of fiction that usually presents danger, or gives the reader a sense of excitement.");
        Genre fantastic = new Genre("Fantastic","Films defined by situations that transcend natural laws and/or by settings inside a fictional universe, with narratives that are often inspired by or involve human myths. The genre typically incorporates non-scientific concepts such as magic, mythical creatures, and supernatural elements.");
        Genre horror = new Genre("Horror", "");
        Genre action = new Genre("Action", "Associated with particular types of spectacle");
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
        Actor actor12 = new Actor("Millie Bobby Brown", "US");
        Actor actor13 = new Actor("Alexander Skarsgård", "US");
        Actor actor14 = new Actor("Rebecca Hall", "US");
        Actor actor15 = new Actor("Eiza González", "US");
        Actor actor16 = new Actor("Lewis Tan", "US");
        Actor actor17 = new Actor("Jessica McNamee", "US");
        Actor actor18 = new Actor("Josh Lawson", "US");
        Actor actor19 = new Actor("Joe Taslim", "US");
        Actor actor20 = new Actor("Tadanobu Asano", "US");
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
        actors.add(actor12);
        actors.add(actor13);
        actors.add(actor14);
        actors.add(actor15);
        actors.add(actor16);
        actors.add(actor17);
        actors.add(actor18);
        actors.add(actor19);
        actors.add(actor20);
    }

    @Transactional
    public void generateFilm() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Film film1 = new Film("Harry Potter and the deathly hallows",
                "Without the guidance and protection of their professors, Harry (Daniel Radcliffe), Ron (Rupert Grint) and Hermione (Emma Watson) begin a mission to destroy the Horcruxes, the sources of Voldemort's immortality.",
                null,120,formatter.parse("10/05/2021"),
                FilmStatus.ON_THEATER, null, "src/main/resources/images/hp.jpg");

        casts.add(new Cast(actors.get(0), film1));
        casts.add(new Cast(actors.get(1), film1));
        casts.add(new Cast(actors.get(2), film1));
        casts.add(new Cast(actors.get(3), film1));

        filmGenres.add(new FilmGenre(genres.get(0), film1));
        filmGenres.add(new FilmGenre(genres.get(1), film1));
        filmGenres.add(new FilmGenre(genres.get(2), film1));



        Film film2 = new Film("DORAEMON: STAND BY ME 2",
                "Nobita - following his previous adventure - has managed to change his future for the better, making Shizuka marry him. Taken by despair, however, he decides to return to the past to re-meet his beloved grandmother, she died when he was still in kindergarten and to whom he was really fond of; grandmother is happy that Nobita came back in time to be with her, and confides in him a great desire: to meet his future bride",
                null,150,formatter.parse("15/07/2021"),
                FilmStatus.INCOMING, null, "src/main/resources/images/doremon.jpg");


        casts.add(new Cast(actors.get(4), film2));
        casts.add(new Cast(actors.get(5), film2));
        casts.add(new Cast(actors.get(6), film2));
        casts.add(new Cast(actors.get(7), film2));

        filmGenres.add(new FilmGenre(genres.get(1), film2));
        filmGenres.add(new FilmGenre(genres.get(2), film2));

        Film film3 = new Film("THE LAST WARRIOR: ROOT OF EVIL",
                "Peace and tranquility have set in Belogorie. The evil was defeated and Ivan is now enjoying his well-deserved fame. He is surrounded by his family, friends and small wonders from the modern world that help him lead a comfortable life. Luckily, he has his Magic Sword...",
                null,125,formatter.parse("30/04/2021"),
                FilmStatus.ON_THEATER, null, "src/main/resources/images/tlw.jpeg");

        casts.add(new Cast(actors.get(8), film3));
        casts.add(new Cast(actors.get(9), film3));
        casts.add(new Cast(actors.get(10), film3));

        filmGenres.add(new FilmGenre(genres.get(0), film3));
        filmGenres.add(new FilmGenre(genres.get(6), film3));

        Film film4 = new Film("MORTAL KOMBAT",
                "A washed-up mixed martial arts fighter named Cole Young is unaware of his hidden lineage or why he is being hunted down by Sub-Zero of the Lin-Kuei clan of assassins. Concerned for the safety of his family, he seeks out a clique of fighters that were chosen to defend Earthrealm in a high-stakes battle against the forces of Outworld.",
                null,150,formatter.parse("30/04/2021"),
                FilmStatus.ON_THEATER, null, "src/main/resources/images/mc.jpg");

        casts.add(new Cast(actors.get(11), film4));
        casts.add(new Cast(actors.get(12), film4));
        casts.add(new Cast(actors.get(13), film4));
        casts.add(new Cast(actors.get(14), film4));

        filmGenres.add(new FilmGenre(genres.get(0), film4));
        filmGenres.add(new FilmGenre(genres.get(6), film4));

        Film film5 = new Film("GODZILLA VS. KONG",
                "Legends collide in “Godzilla vs. Kong” as these mythic adversaries meet in a spectacular battle for the ages, with the fate of the world hanging in the balance. Kong and his protectors undertake a perilous journey to find his true home, and with them is Jia, a young orphaned girl with whom he has formed a unique and powerful bond. But they unexpectedly find themselves in the path of an enraged Godzilla, cutting a swath of destruction across the globe. The epic clash between the two titans—instigated by unseen forces—is only the beginning of the mystery that lies deep within the core of the Earth.",
                null,120,formatter.parse("30/04/2021"),
                FilmStatus.ON_THEATER, null, "src/main/resources/images/gvk.jpg");

        casts.add(new Cast(actors.get(15), film5));
        casts.add(new Cast(actors.get(16), film5));
        casts.add(new Cast(actors.get(17), film5));
        casts.add(new Cast(actors.get(18), film5));
        casts.add(new Cast(actors.get(19), film5));

        filmGenres.add(new FilmGenre(genres.get(0), film5));
        filmGenres.add(new FilmGenre(genres.get(6), film5));
        filmGenres.add(new FilmGenre(genres.get(4), film5));

        films.add(film1);
        films.add(film2);
        films.add(film3);
        films.add(film4);
        films.add(film5);
    }

    @Transactional
    public void generateSeat(){

        for(Room room: rooms){
//            String[] rowList = {"A", "B", "C", "D", "E", "F", "G", "H"};
            String[] rowList = {"A", "B", "C", "D", "E"};
            List<Seat> roomSeat = new ArrayList<>();
            for (String row: rowList) {
                for (int i=0;i<10;i++){
                    Seat seat = new Seat(row,i);
                    SeatType seatType = SeatType.values()[rand.nextInt(2)];
                    seat.setRoom(room);
                    seat.setType(seatType);
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

        for(Room room: rooms){
            for(int i=0; i<startTimeList.length;i++){
                List<Event> filmEvent = new ArrayList<>();
                Random random = new Random();
                int n = random.nextInt(films.size());
                Film film = films.get(n);
                Event event = new Event(startTimeList[i], endTimeList[i], film, room);
                filmEvent.add(event);
                events.add(event);
                film.setEvents(filmEvent);
            }
        }
    }

    @Transactional
    public void generateBooking(){
        for(Event event: events){
            for (Seat seat: event.getRoom().getSeats()){
                Booking booking = new Booking(event, seat, calPrice(event, seat), BookingStatus.AVAILABLE);
                bookings.add(booking);
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
            for(int i=0;i<4;i++){
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
        Cinema cinema1 = new Cinema("VinCinema Ba Trieu", "40 Ba Trieu, Ha Noi", "Ha Noi");
        Cinema cinema2 = new Cinema("VinCinema Nguyen Du", "116 Nguyen Du, District 1, TP.HCM", "TP.Ho Chi Minh");
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
        generateBooking();
        generateCustomer();

        for(Film film: films){
            filmRepository.save(film);
        }

        for(Cast cast: casts){
            castRepository.save(cast);
        }

        for(FilmGenre filmGenre: filmGenres){
            filmGenreRepository.save(filmGenre);
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

        for(Booking booking : bookings){
            bookingRepository.save(booking);
        }

        for(Order order: orders){
            orderRepository.save(order);
        }

        for(OrderLine orderLine: orderLines){
            orderLineRepository.save(orderLine);
        }
    }

    private int calPrice(Event event, Seat seat){
        int initPrice = faker.number().numberBetween(50,100)*1000;
        if(seat.getType() == SeatType.VIP)
            return (int) (initPrice*1.5);
        return initPrice;
    }
}
