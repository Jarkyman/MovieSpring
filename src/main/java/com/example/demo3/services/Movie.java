package com.example.demo3.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Movie {

  public Movie(Integer id, String title, Integer year, Integer length, String subject, Integer popularity, String awards) {
    this.ID = id;
    this.title = title;
    this.year = year;
    this.length = length;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = awards;
  }

  public Movie() {}

  private int ID;

  private String title;

  private int year;

  private int length;

  private String subject;

  private int popularity;

  private String awards;

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  @Override
  public String toString() {
    return "id = " + ID +
        ", title = " + title +
        ", year = " + year +
        ", length = " + length +
        ", subject = " + subject +
        ", popularity = " + popularity +
        ", awards = " + awards;
  }
}
