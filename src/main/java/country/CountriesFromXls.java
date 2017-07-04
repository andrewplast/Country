package country;

import java.io.IOException;

public class CountriesFromXls extends Countries {
    CountriesFromXls() throws IOException{
        countryController = new CountriesControllerFromXls();
    }
}
