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

     public String getCode() {
          return code;
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

     public void setCode(String code) {
          this.code = code.trim();
     }
     public void setName(String name) {
          this.name = name.trim();
     }
     public void setPopulation(double population) {
          this.population = population;
     }
     public void setCountryCode(String countryCode) {
          this.countryCode = countryCode.trim();
     }
}
