package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Comparator;

@SpringBootApplication
public class CountriesApplication {
  static ArrayList<Country> countryList;

  public static void sortAlphabetical() {
    countryList.sort(
      (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())
    );
  }

  public static void sortByAge() {
    countryList.sort(
      Comparator.comparingInt(Country::getAgeMedian)
    );
  }

  public static ArrayList<Country> getMatches(CheckCountry tester) {
    ArrayList<Country> matches = new ArrayList<>();

    countryList.forEach(
      country -> {
        if (tester.test(country)) {
          matches.add(country);
        }
      }
    );

    return matches;
  };

  public static void main(String[] args) {
    countryList = new CountryList().countryList;

    SpringApplication.run(CountriesApplication.class, args);
  }
}

