package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class CountriesApplication {
  static ArrayList<Country> countryList;
  public static void main(String[] args) {
    countryList = new CountryList().countryList;

    // To-do: Add CountryController

    SpringApplication.run(CountriesApplication.class, args);
  }
}

