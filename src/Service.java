import java.util.*;

public class Service {
    public Map<String, List<City>> CitiesInCountry(List<City> cities){
        // Create a map that uses the country code as keys and a list of cities as the value for each country
        Map<String, List<City>> CitiesInCountryMap = new HashMap<>();

        Iterator<City> citiesIterator = cities.iterator();
        while (citiesIterator.hasNext()) {
            City city = citiesIterator.next();
            String countryCode = city.getCountryCode();

            if (CitiesInCountryMap.containsKey(countryCode)) {
                List<City> countryCitiesList = CitiesInCountryMap.get(countryCode);
                countryCitiesList.add(city);
            } else {
                List<City> countryCitiesList=new ArrayList<>();
                countryCitiesList.add(city);
                CitiesInCountryMap.put(countryCode, countryCitiesList);
            }
        }
        return CitiesInCountryMap;
    }
    public void printCitiesInCountryMap(Map<String, List<City>> CitiesInCountryMap){
        System.out.println("Cities in country map that uses the country code as keys and a list of cities as the value for each country:");

        Set<Map.Entry<String, List<City>>> CitiesInCountryMapEntries = CitiesInCountryMap.entrySet();
        Iterator<Map.Entry<String, List<City>>> CitiesInCountryMapIterator = CitiesInCountryMapEntries.iterator();
        int j=0;
        while (CitiesInCountryMapIterator.hasNext()) {
            Map.Entry<String, List<City>> entry = CitiesInCountryMapIterator.next();
            j++;
            System.out.print(j);
            System.out.print(String.format("\tcountry of code:%-2s\thas the cities:",entry.getKey()));
            Iterator<City> countryCitiesListIterator = entry.getValue().iterator();
            while (countryCitiesListIterator.hasNext()) {
                System.out.print(" "+countryCitiesListIterator.next().getName()+",");
            }
            System.out.println("\b.");
        }
    }
    public void sortCitiesList(List<City> citiesList,String rule){
       citiesList.sort(Comparator.comparing(City::getPopulation));
       if(rule=="desc"){
           Collections.reverse(citiesList);
       }
    }
    public void printNames(List<City> list){
        Iterator<City> CitiesListIterator = list.iterator();
        while (CitiesListIterator.hasNext()) {
            System.out.print(" "+CitiesListIterator.next().getName()+",");
        }
        System.out.println("\b.");

    }

    public Map<String, String> CountriesMap(List<Country> countries){
        // Create a map that uses the country code as keys and a list of cities as the value for each country
        Map<String, String> countriesMap = new HashMap<>();

        Iterator<Country> countiesIterator = countries.iterator();
        while (countiesIterator.hasNext()) {
            Country country = countiesIterator.next();
            String countryCode = country.getCountryCode();
            String name=country.getName();

            if (countriesMap.containsKey(countryCode)) {
                if(name!= countriesMap.get(countryCode)){
                    System.out.println("Two countries with same countryCode: \""+countryCode+"\"are detected.");
                    System.out.println("Only the first one is saved.");
                }
            } else {
                countriesMap.put(countryCode, name);
            }
        }
        return countriesMap;
    }
    public void printHighestPopulation(Map<String, List<City>> cityMap, Map<String, String> countryMap) {
        Set<Map.Entry<String, List<City>>> cityMapEntries = cityMap.entrySet();
        Iterator<Map.Entry<String, List<City>>> cityMapIterator = cityMapEntries.iterator();
        int j=0;
        while (cityMapIterator.hasNext()) {
            Map.Entry<String, List<City>> entry = cityMapIterator.next();
            j++;
            System.out.print(j);
            sortCitiesList(entry.getValue(),"desc");

            String countryName=countryMap.get(entry.getKey().trim());
            if (countryName==null){
                countryName="of code: "+entry.getKey().trim()+" (no name info)";
            }
            String highestPopName=entry.getValue().get(0).getName();

            System.out.println(String.format("\tFor the country: %-40s the highest population city is:  \"%s\".",
                    countryName,highestPopName ));
        }
    }

    public Map<String,List<City>> ContinentCountriesCities(List<Country> countries,
                                                            Map<String, List<City>> CitiesInCountry){
        // Create a map that uses the country code as keys and a list of cities as the value for each country
        Map<String,List<City>> continentCountriesCities = new HashMap<>();

        Iterator<Country> countiesIterator = countries.iterator();
        while (countiesIterator.hasNext()) {
            Country country = countiesIterator.next();
            String continent =country.getContinent();
            if(continent.trim()=="" || continent==null) {
                    continent="of country:\""+country.getName()+"\"";
                }
            if (CitiesInCountry.containsKey(country.getCountryCode())) {
                List<City> countryCities = CitiesInCountry.get(country.getCountryCode());

                if (continentCountriesCities.containsKey(continent)) {
                    List<City> continentCodesList = continentCountriesCities.get(continent);
                    continentCodesList.addAll(countryCities);
                    sortCitiesList(continentCodesList,"desc");


                } else {
                    List<City> continentCodesList=new ArrayList<>();
                    continentCodesList.addAll(countryCities);
                    sortCitiesList(continentCodesList,"desc");
                    continentCountriesCities.put(continent, continentCodesList);
                }
            }
            else{
                continue;
            }



        }
        return continentCountriesCities;
    }
    public void printContinentHighestPopulation(Map<String, List<City>> continentCitiesMap) {

        Set<Map.Entry<String, List<City>>> continentCitiesMapEntries = continentCitiesMap.entrySet();
        Iterator<Map.Entry<String, List<City>>> continentCitiesMapIterator = continentCitiesMapEntries.iterator();
        int j=0;
        while (continentCitiesMapIterator.hasNext()) {
            Map.Entry<String, List<City>> entry = continentCitiesMapIterator.next();
            j++;
            System.out.print(j);
            String continentName=entry.getKey().trim();
            String highestPopName=entry.getValue().get(0).getName();

            System.out.println(String.format("\tFor the continent: %-20s the highest population city is:  \"%s\".",
                    continentName,highestPopName ));
        }
    }
}
