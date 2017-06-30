package main.java.Country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/")
public class SearchCountry {

    @GET
    @Produces("application/json")
    public Response searchCountryWithoutName() throws JSONException {
        Countries CountriesList = new Countries();
        return CountriesList.JSONDefaultListCountry();
    }

    @Path("{partName}")
    @GET
    @Produces("application/json")
    public Response searchCountryWithPartName(@PathParam("partName") String partName) throws JSONException {
        Countries CountriesList = new Countries();
        return CountriesList.JSONSearchListCountry(partName);
    }
}