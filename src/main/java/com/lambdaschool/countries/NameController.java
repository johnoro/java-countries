package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController {
  @RequestMapping("/all")
  public ArrayList<String> getCountryNames() {
    CountriesApplication.sortAlphabetical();

    ArrayList<String> names = new ArrayList<>();
    CountriesApplication.countryList.forEach(
      country -> names.add(country.getName())
    );

    return names;
  }

  @RequestMapping("/begin")
  public ArrayList<Country> getCountriesByStart(
    @RequestParam(value = "letter", defaultValue = "A") char letter
  ) {
    CountriesApplication.sortAlphabetical();

    return CountriesApplication.getMatches(
      country -> country.getName().charAt(0) == letter
    );
  }

  @RequestMapping("/size")
  public ArrayList<Country> getCountriesByNameLength(
    @RequestParam(value = "letters", defaultValue = "0") int letters
  ) {
    CountriesApplication.sortAlphabetical();

    return CountriesApplication.getMatches(
      country -> country.getName().length() >= letters
    );
  }
}
