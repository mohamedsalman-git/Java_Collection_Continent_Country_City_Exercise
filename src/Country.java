public class Country {
    private String countryCode;
    private String name;
    private String continent;

    public Country(String countryCode, String name, String continent) {
        this.countryCode = countryCode.trim();
        this.name = name.trim();
        this.continent = continent;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public String getName() {
        return name;
    }
    public String getContinent() {
        return continent;
    }
}
