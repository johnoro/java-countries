package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController {
  @RequestMapping("/all")
  public ArrayList<String> getNames() {
    CountriesApplication.sortAlphabetical();

    ArrayList<String> names = new ArrayList<>();
    CountriesApplication.countryList.forEach(
      country -> names.add(country.getName())
    );

    return names;
  }

  @RequestMapping("/begin")
  public ArrayList<Country> getCountryByStart(
    @RequestParam(value = "letter", defaultValue = "A") char letter
  ) {
    CountriesApplication.sortAlphabetical();

    ArrayList<Country> matches = new ArrayList<>();
    CountriesApplication.countryList.forEach(
      country -> {
        if (country.getName().charAt(0) == letter) {
          matches.add(country);
        }
      }
    );
    return matches;
  }
}
