package controller;

import java.util.*;
import models.*;

public class TheatreController {
  private Map<String, List<Theatre>> cityVsTheatre;
  private List<Theatre> allTheatres;

  public TheatreController() {
    cityVsTheatre = new HashMap<>();
    allTheatres = new ArrayList<>();
  }

  public void addCityTheatreMapping(String city, Theatre theatre) {
    if (cityVsTheatre.containsKey(city.toLowerCase())) {
      cityVsTheatre.get(city.toLowerCase()).add(theatre);
    } else {
      List<Theatre> temp = new ArrayList<>();
      temp.add(theatre);
      cityVsTheatre.put(city.toLowerCase(), temp);
    }
  }

  public void addTheatre(Theatre theatre) {
    allTheatres.add(theatre);
  }

  public Map<String, List<Theatre>> getCityVsTheatre() {
    return cityVsTheatre;
  }

  public List<Theatre> getAllTheatres() {
    return allTheatres;
  }

  public Map<Theatre, List<Show>> getShows(Movie movie, String city) {
    List<Theatre> theatres = cityVsTheatre.getOrDefault(city.toLowerCase(), null);
    if (theatres == null)
      return null;

    Map<Theatre, List<Show>> theatreShows = new HashMap<>();
    for (Theatre theatre : theatres) {

      List<Show> givenMovieShows = new ArrayList<>();
      List<Show> shows = theatre.getShows();

      for (Show show : shows) {
        if (show.getMovie().getId() == movie.getId()) {
          givenMovieShows.add(show);
        }
      }
      if (!givenMovieShows.isEmpty()) {
        theatreShows.put(theatre, givenMovieShows);
      }
    }

    return theatreShows;
  }
}