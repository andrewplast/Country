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
    @Produces("application/json")
    public Response getAllCountryMemory() throws JSONException {
        return new SearchCountryResponse().getResponse(new InMemoryCountryDAO().getAll());
    }

    @Path("/memory/{substring}")
    @GET
    @Produces("application/json")
    public Response findCountryMemory(@PathParam("substring") String substring) throws JSONException {
        return new SearchCountryResponse().getResponse(new InMemoryCountryDAO().find(substring));
    }

    @Path("/excel")
    @GET
    @Produces("application/json")
    public Response getAllCountryXls() throws JSONException, IOException {
        return new SearchCountryResponse().getResponse(new XLSCountryDAO().getAll());
    }

    @Path("/excel/{substring}")
    @GET
    @Produces("application/json")
    public Response findCountriesXls(@PathParam("substring") String substring) throws JSONException, IOException {
        return new SearchCountryResponse().getResponse(new XLSCountryDAO().find(substring));
    }
}