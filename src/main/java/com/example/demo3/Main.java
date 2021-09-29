package com.example.demo3;

import com.example.demo3.repositorys.MovieRepository;

public class Main {

  public static void main(String[] args) {
    MovieRepository mr = new MovieRepository();
    System.out.println(mr.getPopularMovies(10));
  }

}
