import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readCSV {
    public List<City> ReadCityCSV(String fileName,boolean firstIsHeader){
        List<City> Cities = new ArrayList<>();
        // create an instance of BufferedReader

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // read the first line from the text file which will be head column
            String line;
            line = br.readLine();

            // read first line
            if(firstIsHeader) {
                if (line != null) {
                    line = br.readLine(); // the first real data
                }
            }
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
                String[] metadata = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", 8);

                // createCity() retrieved attribute"
                // adding City into ArrayList
                Cities.add(createCity(metadata));

                // read next line before looping
                line = br.readLine();
                // if end of file reached, line would be null

            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();

        }

        return Cities;

    }
    public City createCity(String[] metadata) {

        String code= metadata[0];
        String name= metadata[1];
        String countryCode= metadata[3];

        double population= 0;
        if( metadata[2] != "" && metadata[2] != null ) {
            if( Double.parseDouble(metadata[2]) >= 0) {
                population = Double.parseDouble(metadata[2]);
            }
        }



        // create and return City of this metadata
        return new City(code , name,population, countryCode);

    }

    public List<Country> ReadCountryCSV(String fileName,boolean firstIsHeader){
        List<Country> countries = new ArrayList<>();
        // create an instance of BufferedReader

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // read the first line from the text file which will be head column
            String line;
            line = br.readLine();

            // read first line
            if(firstIsHeader) {
                if (line != null) {
                    line = br.readLine(); // the first real data
                }
            }
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
                String[] metadata = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", 8);

                // createCountry() retrieved attribute"
                // adding Country into ArrayList
                countries.add(createCountry(metadata));

                // read next line before looping
                line = br.readLine();
                // if end of file reached, line would be null

            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();

        }

        return countries;

    }
    public Country createCountry(String[] metadata) {

        String countryCode= metadata[2];
        String name= metadata[0];
        String continent= metadata[5];

        // create and return Country of this metadata
        return new Country(countryCode,name, continent);

    }
}
