import controller.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.*;
import models.enums.SeatCategory;

public class Main {
  // add movies to the controller
  // add theatres
  // add screens
  MovieController movieController;
  TheatreController theatreController;

  public Main() {
    movieController = new MovieController();
    theatreController = new TheatreController();
  }

  public static void main(String[] args) {
    Main bookMyShow = new Main();

    bookMyShow.initialize();

    // user1
    bookMyShow.createBooking("Banglore", "BAHUBALI");
    // user2
    bookMyShow.createBooking("Banglore", "BAHUBALI");
  }

  void createBooking(String userCity, String movieName) {
    // 1. search movie by my location
    List<Movie> movies = movieController.getMoviesByCity(userCity);

    // 2. select the movie which you want to see. i want to see Baahubali
    Movie interestedMovie = null;
    for (Movie movie : movies) {

      if ((movie.getName()).equals(movieName.toLowerCase())) {
        interestedMovie = movie;
        break;
      }
    }

    // 3. get all show of this movie in Bangalore location
    Map<Theatre, List<Show>> showsTheatreWise = theatreController.getShows(interestedMovie, userCity);

    // 4. select the particular show user is interested in
    Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
    Theatre interestedTheatre = entry.getKey();
    List<Show> runningShows = entry.getValue();
    Show interestedShow = runningShows.get(0);

    // 5. select the seat
    Seat seatNumber = new Seat(30, "", SeatCategory.SILVER);
    List<Seat> bookedSeats = interestedShow.getBookedSeats();
    if (!bookedSeats.contains(seatNumber)) {
      bookedSeats.add(seatNumber);
      // startPayment
      Booking booking = new Booking(1, interestedShow, seatNumber, interestedTheatre);
    } else {
      // throw exception
      System.out.println("seat already booked, try again");
      return;
    }

    System.out.println("BOOKING SUCCESSFUL");

  }

  void initialize() {

    // create movies
    createMovies();

    // create theater with screens, seats and shows
    createTheatre();
  }

  void createMovies() {
    Movie movie1 = new Movie(1, 123.45f, "Avengers");
    Movie movie2 = new Movie(2, 123.45f, "Bahubali");

    movieController.addMovie(movie1);
    movieController.addMovie(movie2);
    movieController.addCityMovieMapping("Banglore", movie1);
    movieController.addCityMovieMapping("Banglore", movie2);
  }

  List<Seat> createSeats() {
    List<Seat> seats = new ArrayList<>();

    // 1 to 40 : SILVER
    for (int i = 0; i < 40; i++) {
      Seat seat = new Seat(i, "", SeatCategory.SILVER);
      seats.add(seat);
    }

    // 41 to 70 : SILVER
    for (int i = 40; i < 70; i++) {
      Seat seat = new Seat(i, "", SeatCategory.GOLD);
      seats.add(seat);
    }

    // 1 to 40 : SILVER
    for (int i = 70; i < 100; i++) {
      Seat seat = new Seat(i, "", SeatCategory.PLATINUM);
      seats.add(seat);
    }
    return seats;
  }

  List<Screen> createScreen() {

    List<Screen> screens = new ArrayList<>();
    Screen screen1 = new Screen(1, createSeats());
    screens.add(screen1);

    return screens;
  }

  void createTheatre() {

    Movie avengerMovie = movieController.getMovieByName("AVENGERS");
    Movie baahubali = movieController.getMovieByName("BAHUBALI");

    Theatre inoxTheatre = new Theatre(1, "Banglore");
    inoxTheatre.setScreens(createScreen());
    List<Show> inoxShows = new ArrayList<>();
    Show inoxMorningShow = new Show(1, avengerMovie, LocalDateTime.now(), inoxTheatre.getScreens().get(0));
    Show inoxEveningShow = new Show(2, baahubali, LocalDateTime.now(), inoxTheatre.getScreens().get(0));
    // Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0),
    // baahubali, );
    inoxShows.add(inoxMorningShow);
    inoxShows.add(inoxEveningShow);
    inoxTheatre.setShows(inoxShows);

    Theatre pvrTheatre = new Theatre(2, "Delhi");
    pvrTheatre.setScreens(createScreen());
    List<Show> pvrShows = new ArrayList<>();
    Show pvrMorningShow = new Show(3, avengerMovie, LocalDateTime.now(), pvrTheatre.getScreens().get(0));
    Show pvrEveningShow = new Show(4, baahubali, LocalDateTime.now(), pvrTheatre.getScreens().get(0));

    pvrShows.add(pvrMorningShow);
    pvrShows.add(pvrEveningShow);
    pvrTheatre.setShows(pvrShows);

    theatreController.addCityTheatreMapping("Banglore", inoxTheatre);
    theatreController.addCityTheatreMapping("Delhi", pvrTheatre);

  }

}
