/**
 * CountryTest.java
 */

/**
 * CS5005 Lab 5: Problem 3 - Country Class.
 * This class test the functionality of country class.
 *
 * @author Randy Lirano
 * @since 2020-06-04
 */

public class CountryTest {
    public static void main(String[] args) {
        System.out.println("Number of countries: " + Country.numberOfCountries);

        Country c1 = new Country("Indonesia", 100);
        Country c2 = new Country("USA", 500);

        System.out.println("Country 1 Seniority: " + c1.seniority());
        System.out.println("Country 2 Seniority: " + c2.seniority());

        System.out.println("Number of countries: " + Country.numberOfCountries);
    }
}

class Country {
    // Country class instances
    private String name;
    private int population;
    private int seniority;
    public static int numberOfCountries; // Have accessor, no mutator

    // No constructor without arguments because a country should have a name and population
    public Country(String name, int population) {
        if (nameCheck(name) && populationCheck(population)) {
            setName(name);
            setPopulation(population);
            this.seniority = Country.numberOfCountries;
            
            if (Country.numberOfCountries == 0) {
                Country.numberOfCountries = 1;
            } else {
                Country.numberOfCountries += 1;
            }
        } else {
            System.out.println("ERROR: Invalid Constructor Arguments");
            System.exit(1);
        }
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public int seniority() {
        return this.seniority;
    }

    // Setter methods
    private boolean nameCheck(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid Argument");
            return false;
        }
        return true;
    }

    private boolean populationCheck(int population) {
        if (population <= 0) {
            System.out.println("Invalid Argument");
            return false;
        }
        return true;
    }

    public void setName(String name) {
        if (nameCheck(name)) {
            this.name = name;
        }
    }

    public void setPopulation(int population) {
        if (populationCheck(population)) {
            this.population = population;
        }
    }
}