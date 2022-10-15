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


@Path("/dvd")
public class DvdsResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    @GET
    @Produces(MediaType.TEXT_XML)
    public List<DVD> getDVDBrowser() {
        List<DVD> DVDlist = new ArrayList<DVD>();
        DVDlist.addAll(DvDDao.instance.getModel().values());
        return DVDlist;
    }

    @GET
    @Path("/getAllDvd")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DVD> getDVD() {
        List<DVD> DVDlist = new ArrayList<DVD>(DvDDao.instance.getModel().values());
        System.out.println(DVDlist);
        return DVDlist;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = DvDDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public void newDVD(@QueryParam("dvdId") String dvdId,
                       @QueryParam("userId") String userId,
                       @QueryParam("duration") String duration,
                       @QueryParam("title") String title,
                       @QueryParam("description") String description,
                       @QueryParam("director") String director,
                       @QueryParam("releasedate") String releaseDate,
                       @QueryParam("rating") String rating,
                       @Context HttpServletResponse servletResponse) throws IOException {
        DVD dvd = new DVD(dvdId, userId, duration, title, description, director, releaseDate, rating);
        DvDDao.instance.getModel().put(dvdId, dvd);
        servletResponse.sendRedirect("../getDvd/" + dvdId);
    }


    @Path("/getDvd/{dvd}")
    @Produces(MediaType.APPLICATION_XML)
    public DvdResource getDvd(@PathParam("dvd") String dvdId) {
        return new DvdResource(uriInfo, request, dvdId);
    }

}
