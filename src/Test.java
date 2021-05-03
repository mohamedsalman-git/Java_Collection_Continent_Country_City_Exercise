import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        testCity();
        testCountryOp();

    }

    private static void testCity() {
        readCSV readcsv = new readCSV();
        List<City> cities = readcsv.ReadCityCSV("Cities.txt",false);

        System.out.println("\nMapping country code ang cities in country :-\n");

        Service cityService=new Service();
        Map<String, List<City>> map = cityService.CitiesInCountry(cities);

        cityService.printCitiesInCountryMap(map);

        System.out.println("\nTesting sorting a list:-\n");

        String key=" AFG ";
        key=key.trim();
        if(map.containsKey(key)) {
            System.out.print("Before sorting the key \"" +key+"\" have the cities:");
            cityService.printNames(map.get(key.trim()));

            cityService.sortCitiesList(map.get(key.trim()),"asc");

            System.out.print("After sorting the key \"" +key+"\" have the cities:");
            cityService.printNames(map.get(key.trim()));
            System.out.println("\n\t\t\"Please, Be noted that the original list has been sorted.\"");

        }
        else {
            System.out.println("key doesn't exist");
        }
    }

    private static void testCountryOp() {
        readCSV readcsv = new readCSV();
        List<City> cities = readcsv.ReadCityCSV("Cities.txt",false);

        Service cityService=new Service();
        Map<String, List<City>> cityMap = cityService.CitiesInCountry(cities);

        readCSV readcsv1 = new readCSV();
        List<Country> countries = readcsv1.ReadCountryCSV("countryContinent.csv",true);

        Service countryService=new Service();
        Map<String, String> countryMap = countryService.CountriesMap(countries);

        System.out.println("\nPrinting Highest population city of countries:-\n");
        countryService.printHighestPopulation(cityMap,countryMap);

        Map<String, List<City>> continentCities = countryService.ContinentCountriesCities(countries, cityMap);

        System.out.println("\nPrinting Highest population city of continents:-\n");
        countryService.printContinentHighestPopulation(continentCities);



    }
}
