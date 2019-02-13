package com.lambdaschool.countries;

public class Country {
  String name;
  int population;
  int landMassSize;
  int ageMedian;

  public Country(String name, int population, int size, int age) {
    this.name = name;
    this.population = population;
    landMassSize = size;
    ageMedian = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public int getLandMassSize() {
    return landMassSize;
  }

  public void setLandMassSize(int size) {
    landMassSize = size;
  }

  public int getAgeMedian() {
    return ageMedian;
  }

  public void setAgeMedian(int age) {
    ageMedian = age;
  }
}
