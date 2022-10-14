package Ressources;


import Model.DVD;
import REST.DvDDao;

import org.glassfish.jersey.media.multipart.FormDataParam;
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
        System.out.println("1");
        return DVDlist;
    }

    @GET
    @Path("/getAllDvd")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DVD> getDVD() {
        List<DVD> DVDlist = new ArrayList<DVD>(DvDDao.instance.getModel().values());
        System.out.println("2");
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newDVD(@FormDataParam("dvdId") String dvdId,
                       @FormDataParam ("userId") String userId,
                       @FormDataParam("duration") String duration,
                       @FormDataParam("title") String title,
                       @FormDataParam("description") String description,
                       @FormDataParam("director") String director,
                       @FormDataParam("releasedate") String releaseDate,
                       @FormDataParam("rating") String rating,
                       @Context HttpServletResponse servletResponse) throws IOException {
        DVD dvd = new DVD(dvdId, userId, duration, title, description, director, releaseDate, rating);
        DvDDao.instance.getModel().put(dvdId, dvd);
        System.out.println("post");
    }

    @Path("{dvd}")
    public DvdResource getDvd(@PathParam("dvd") String dvdId) {
        return new DvdResource(uriInfo, request, dvdId);
    }
}
