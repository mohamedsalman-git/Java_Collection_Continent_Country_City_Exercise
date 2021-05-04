public class City {
     private String code;
     private String name;
     private double population;
     private String countryCode;

     public City(String code, String name, double population, String countryCode) {
          this.code = code.trim();;
          this.name = name.trim();
          this.population = population;
          this.countryCode = countryCode.trim();
     }

     public String getName() {
          return name;
     }
     public double getPopulation() {
          return population;
     }
     public String getCountryCode() {
          return countryCode;
     }
}
