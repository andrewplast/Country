package country.view;

import country.Country;
import org.json.JSONObject;


import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

public class SearchCountryResponse {

    private Collection<Country> countries;

    public SearchCountryResponse(Collection<Country> countries) {
        this.countries = countries;
    }

    public Collection<Country> getCountries() {
        return countries;
    }

    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }
}
