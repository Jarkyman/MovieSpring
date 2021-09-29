package com.example.demo3.controllers;

import com.example.demo3.repositorys.DBManager;
import com.example.demo3.repositorys.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.util.ArrayList;

@Controller
@ResponseBody
public class MovieController {
  private MovieRepository mr = new MovieRepository();

  @GetMapping("/")
  @ResponseBody
  public String welcomePage() {
    return "<h1> Welcome to my movie database </h1>";
  }

  @GetMapping("/getfirst")
  @ResponseBody
  public String getFirst() {return mr.getFirstMovie();}

  @GetMapping("/getrandom")
  @ResponseBody
  public String getRandom() {return mr.getRandomMovie();}

  @GetMapping("/getTenSortByPopularity")
  @ResponseBody
  public String getTenPopular() {return mr.getPopularMovies(10);}

  @GetMapping("/howManyWonAnAward")
  @ResponseBody
  public String getAwards() {return mr.getAwardMovies();}

  @GetMapping("/check")
  @ResponseBody
  public String checkConnection() {

    Connection connection = DBManager.getConnection();

    if (connection != null) {
      return "Connected";
    } else {
      return "Not connected";
    }

  }

}
