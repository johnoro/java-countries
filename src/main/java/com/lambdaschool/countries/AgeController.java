package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {
  @RequestMapping("/age")
  public ArrayList<Country> getCountriesByAge(
    @RequestParam(value = "age", defaultValue = "0") int age
  ) {
    return CountriesApplication.getMatches(
      country -> country.getAgeMedian() >= age
    );
  }

  @RequestMapping("/min")
  public Country getCountryWithSmallestAge() {
    CountriesApplication.sortByAge();

    return CountriesApplication.countryList.get(0);
  }

  @RequestMapping("/max")
  public Country getCountryWithLargestAge() {
    CountriesApplication.sortByAge();

    return CountriesApplication.countryList.get(
      CountriesApplication.countryList.size() - 1
    );
  }
}
