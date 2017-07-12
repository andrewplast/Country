package country;

import country.dao.InMemoryCountryDAO;
import country.dao.XLSCountryDAO;
import country.view.SearchCountryResponse;
import org.json.JSONException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class SearchCountryIndex {

    @GET
    @Produces("text/html")
    public Response getIndexPage() {
        String indexHtml = "<a href='./memory/'>Поиск по загруженным данным</a><br><a href='./excel/'>Поиск по данным XLS</a>";
        return Response.status(Response.Status.OK).entity(indexHtml).build();
    }

    @Path("/memory")
    @GET
    @Produces(APPLICATION_JSON)
    public SearchCountryResponse getAllCountryMemory() throws JSONException {
        return new SearchCountryResponse(new InMemoryCountryDAO().getAll());
    }

    @Path("/memory/{substring}")
    @GET
    @Produces("application/json")
    public SearchCountryResponse findCountryMemory(@PathParam("substring") String substring) throws JSONException {
        return new SearchCountryResponse(new InMemoryCountryDAO().find(substring));
    }

    @Path("/excel")
    @GET
    @Produces("application/json")
    public SearchCountryResponse getAllCountryXls() throws JSONException, IOException {
        return new SearchCountryResponse(new XLSCountryDAO().getAll());
    }

    @Path("/excel/{substring}")
    @GET
    @Produces("application/json")
    public SearchCountryResponse findCountriesXls(@PathParam("substring") String substring) throws JSONException, IOException {
        return new SearchCountryResponse(new XLSCountryDAO().find(substring));
    }
}