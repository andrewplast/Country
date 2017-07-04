package country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

@Path("/")
public class SearchCountryIndex {

    public Response jsonSendListCountries(List<Country> countries){
        JSONObject jsonCountryList = new JSONObject();
        for (Country oneCountryInResult: countries) {
            jsonCountryList.put(Integer.toString(oneCountryInResult.getKeyValue()), oneCountryInResult.getNameCountry());
        }
        return Response.status(Response.Status.OK).entity(jsonCountryList.toString()).build();
    }

    @GET
    @Produces("text/html")
    public Response getIndexPage() {
        String indexHtml = new String("<a href='./fromdata/'>Поиск по загруженным данным</a><br><a href='./fromxls/'>Поиск по данным XLS</a>");
        return Response.status(Response.Status.OK).entity(indexHtml).build();
    }

    @Path("/fromdata")
    @GET
    @Produces("application/json")
    public Response getAllCountryFromData() throws JSONException {
        CountriesFromData countriesFromData = new CountriesFromData();
        return jsonSendListCountries(countriesFromData.getAllCountry());
    }

    @Path("/fromdata/{partName}")
    @GET
    @Produces("application/json")
    public Response searchCountryFromData(@PathParam("partName") String partName) throws JSONException {
        CountriesFromData countriesFromData = new CountriesFromData();
        return jsonSendListCountries(countriesFromData.getCountryBySearch(partName));
    }

    @Path("/fromxls")
    @GET
    @Produces("application/json")
    public Response getAllCountryFromXls() throws JSONException, IOException {
        CountriesFromXls countriesFromXls = new CountriesFromXls();
        return jsonSendListCountries(countriesFromXls.getAllCountry());
    }

    @Path("/fromxls/{partName}")
    @GET
    @Produces("application/json")
    public Response searchCountryFromXls(@PathParam("partName") String partName) throws JSONException, IOException {
        CountriesFromXls countriesFromXls = new CountriesFromXls();
        return jsonSendListCountries(countriesFromXls.getCountryBySearch(partName));
    }

}