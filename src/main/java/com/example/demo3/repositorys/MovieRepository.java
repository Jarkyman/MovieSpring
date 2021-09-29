package com.example.demo3.repositorys;

import com.example.demo3.services.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieRepository {

  public String getFirstMovie() {
    String result = "";

    result += "<h1> First movie </h1>";
    result += getOneMovie("SELECT * FROM movies LIMIT 1").toString();

    return result;
  }

  public String getRandomMovie() {
    String result = "";

    result += "<h1> First movie </h1>";
    result += getOneMovie("SELECT * FROM movies ORDER BY RAND() LIMIT 1").toString();
    return result;
  }

  public String getPopularMovies(int numOfMovie) {
    ArrayList<String> movies =  moviesToString(getMovieList("SELECT * FROM movies ORDER BY popularity DESC LIMIT 10"));
    StringBuilder result = new StringBuilder("<h1> Top " + numOfMovie + " popular movies</h1> <ol>");

    for (String movie : movies) {
      result.append("<li>").append(movie).append("</li>"); //br go to next line like \n
    }

    result.append("</ol>");

    return result.toString();
  }

  public String getAwardMovies() {
    ArrayList<String> movies = moviesToString(getMovieList("SELECT * FROM movies WHERE awards LIKE \"Yes\""));
    int numOfAwards = getCount("SELECT count(*) FROM movies WHERE awards LIKE \"Yes\"");
    StringBuilder result = new StringBuilder("<h1> List of " + numOfAwards + " movies with awards</h1> <ol>");

    for (String movie : movies) {
      result.append("<li>").append(movie).append("</li>");
    }

    result.append("</ol>");

    return result.toString();
  }

  //Hjælpe Metoder

  // Get a single movie
  private Movie getOneMovie(String SQL) {
    try {

      Connection con = DBManager.getConnection();
      //String SQL = ;
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      Movie movie;
      if (rs.next()) {
        movie = new Movie(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getInt(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
        return movie;
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());

    }

    return null;
  }

  // Get a list of movies
  private ArrayList<Movie> getMovieList(String SQL) {
    ArrayList<Movie> movies = new ArrayList<>();

    try {
      Connection con = DBManager.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      Movie movie;
      while (rs.next()) {
        movie = new Movie(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getInt(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
        movies.add(movie);
      }
      return movies;
    } catch (SQLException e) {
      System.out.println(e.getMessage());

    }

    return null;
  }

  // Get count of a row
  private int getCount(String SQL) {
    int num = -1;
    try {
      Connection con = DBManager.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        num = rs.getInt(1);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());

    }

    return num;
  }

  // make a list of movies to a list of strings
  private ArrayList<String> moviesToString(ArrayList<Movie> movies) {
    ArrayList<String> moviesStr = new ArrayList<>();

    for (Movie m : movies) {
      moviesStr.add(m.toString());
    }
    return moviesStr;
  }

}
