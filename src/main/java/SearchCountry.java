package main.java.country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

@Path("/")
public class SearchCountry {

    public Response jsonSendListCountries(List<Country> countries){
        JSONObject jsonCountryList = new JSONObject();
        for (Country oneCountryInResult: countries) {
            jsonCountryList.put(Integer.toString(oneCountryInResult.getKeyValue()), oneCountryInResult.getNameCountry());
        }
        return Response.status(Response.Status.OK).entity(jsonCountryList.toString()).build();
    }

    @GET
    @Produces("application/json")
    public Response searchCountryWithoutName() throws JSONException {
        Countries countries = new CountriesJson();
        return jsonSendListCountries(countries.getAllCountry());
    }

    @Path("{partName}")
    @GET
    @Produces("application/json")
    public Response searchCountryWithPartName(@PathParam("partName") String partName) throws JSONException {
        Countries countries = new CountriesJson();
        return jsonSendListCountries(countries.getCountryBySearch(partName));
    }
}