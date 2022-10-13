package Ressources;


import Model.DVD;
import REST.DvDDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/Dvd")

public class DvdsResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_XML)
    public List<DVD> getDVDBrowser() {
        List<DVD> DVD = new ArrayList<DVD>();
        DVD.addAll(DvDDao.instance.getModel().values());
        return DVD;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DVD> getDVD() {
        List<DVD> DVD = new ArrayList<DVD>();
        DVD.addAll(DvDDao.instance.getModel().values());
        return DVD;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = DvDDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newDVD(@FormParam("dvdId") String dvdId,
                       @FormParam("userId") String userId,
                       @FormParam("duration") String duration,
                       @FormParam("title") String title,
                       @FormParam("description") String description,
                       @FormParam("director") String director,
                       @FormParam("release date") String releaseDate,
                       @FormParam("rating") Integer rating,
                       @Context HttpServletResponse servletResponse) throws IOException {
        DVD dvd = new DVD(dvdId, userId, duration, title, description, director, releaseDate, rating);


    DvDDao.instance.getModel().put(dvdId, dvd);

    servletResponse.sendRedirect("../create_dvd.html");
}

    @Path("{dvd}")
    public DvdResource getDvd(@PathParam("dvd") String dvdId){
        return new DvdResource(uriInfo, request, dvdId);
    }
}
