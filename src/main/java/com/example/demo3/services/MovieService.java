package com.example.demo3.services;

import com.example.demo3.repositorys.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

  //Find first



  // Search retrieves all matches, including search by substring

  public List<Movie> findMoviesByTitle(String title) {
    ArrayList<Movie> movies = new ArrayList<>();
    Movie tmp;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM movies WHERE title like ?";
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, "%" + title + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        tmp = new Movie(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getInt(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7)
        );
        movies.add(tmp);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return movies;
  }

}
