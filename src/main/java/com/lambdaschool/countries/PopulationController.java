package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {
  @RequestMapping("/size")
  public ArrayList<Country> getCountriesByPopulation(
    @RequestParam(value = "people", defaultValue = "0") int people
  ) {
    return CountriesApplication.getMatches(
      country -> country.getPopulation() >= people
    );
  }

  @RequestMapping("/min")
  public Country getCountryWithSmallestPopulation() {
    CountriesApplication.sortByPopulation();

    return CountriesApplication.countryList.get(0);
  }

  @RequestMapping("/max")
  public Country getCountryWithLargestPopulation() {
    CountriesApplication.sortByPopulation();

    return CountriesApplication.countryList.get(
      CountriesApplication.countryList.size() - 1
    );
  }
}
