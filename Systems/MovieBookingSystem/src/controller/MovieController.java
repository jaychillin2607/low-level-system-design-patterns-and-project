package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Movie;

public class MovieController {
  private Map<String, List<Movie>> cityVsMovie;
  private List<Movie> allMovies;

  public MovieController() {
    cityVsMovie = new HashMap<>();
    allMovies = new ArrayList<>();
  }

  public void addCityMovieMapping(String city, Movie movie) {
    if (cityVsMovie.containsKey(city.toLowerCase())) {
      cityVsMovie.get(city.toLowerCase()).add(movie);
    } else {
      List<Movie> temp = new ArrayList<>();
      temp.add(movie);
      cityVsMovie.put(city.toLowerCase(), temp);
    }
  }

  public void addMovie(Movie movie) {
    allMovies.add(movie);
  }

  public List<Movie> getMoviesByCity(String city) {
    List<Movie> movies = cityVsMovie.get(city.toLowerCase());
    return movies;
  }

  public List<Movie> getAllMovies() {
    return allMovies;
  }

  public Movie getMovieByName(String movieName) {

    for (Movie movie : allMovies) {
      if ((movie.getName()).equals(movieName.toLowerCase())) {
        return movie;
      }
    }
    return null;
  }

}