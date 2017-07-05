package country.view;

import country.dao.Country;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.Collection;

public class SearchCountryResponse {
    public Response getResponse(Collection<Country> countries) {
        JSONObject jsonCountries = new JSONObject();
        for (Country country : countries) {
            jsonCountries.put(Integer.toString(country.hashCode()), country.getName());
        }
        return Response.status(Response.Status.OK).entity(jsonCountries.toString()).build();
    }
}
