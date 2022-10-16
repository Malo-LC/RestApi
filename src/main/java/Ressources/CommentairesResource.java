package Ressources;

import Model.Commentaire;
import REST.ComDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Path("/com")
public class CommentairesResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @POST
    @Path("/dvd/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void newDVDCom(@PathParam("id") String dvdId,
                          @QueryParam("userId") String userId,
                          @QueryParam("text") String text,
                          @Context HttpServletResponse servletResponse) {
        Commentaire com = new Commentaire(userId, "dvd", dvdId, text);
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        ComDao.instance.getModel().put(generatedString, com);
    }

    @GET
    @Path("/dvd/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Commentaire> getDvdCom(@PathParam("id") String dvdId) {
        System.out.println("init");
        List<Commentaire> finalCom = new ArrayList<>();
        List<Commentaire> ComList = new ArrayList<>(ComDao.instance.getModel().values());
        for (Commentaire com : ComList) {
            if (Objects.equals(com.getItemID(), dvdId) && Objects.equals(com.getItemType(), "dvd")) {
                finalCom.add(com);
            }
        }
        if (finalCom.size() == 0)
            throw new RuntimeException("Get: DVD com with " + dvdId + " not found");
        return finalCom;
    }

    @POST
    @Path("/videogame/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void newVideoGameCom(@PathParam("id") String videogameId,
                                @QueryParam("userId") String userId,
                                @QueryParam("text") String text,
                                @Context HttpServletResponse servletResponse) {
        Commentaire com = new Commentaire(userId, "videogame", videogameId, text);
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        ComDao.instance.getModel().put(generatedString, com);
    }

    @GET
    @Path("/videogame/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Commentaire> getVideoGameCom(@PathParam("id") String videogameId) {
        System.out.println("init");
        List<Commentaire> finalCom = new ArrayList<>();
        List<Commentaire> ComList = new ArrayList<>(ComDao.instance.getModel().values());
        for (Commentaire com : ComList) {
            if (Objects.equals(com.getItemID(), videogameId) && Objects.equals(com.getItemType(), "videogame")) {
                finalCom.add(com);
                System.out.println("found");
            }
        }
        if (finalCom.size() == 0)
            throw new RuntimeException("Get: VideoGame com with" + videogameId + "not found");
        return finalCom;
    }


    @POST
    @Path("/book/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void newBookCom(@PathParam("id") String bookId,
                           @QueryParam("userId") String userId,
                           @QueryParam("text") String text,
                           @Context HttpServletResponse servletResponse) {
        Commentaire com = new Commentaire(userId, "book", bookId, text);
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        ComDao.instance.getModel().put(generatedString, com);
    }

    @GET
    @Path("/book/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Commentaire> getBookCom(@PathParam("id") String bookId) {
        System.out.println("init");
        List<Commentaire> finalCom = new ArrayList<>();
        List<Commentaire> ComList = new ArrayList<>(ComDao.instance.getModel().values());
        for (Commentaire com : ComList) {
            if (Objects.equals(com.getItemID(), bookId) && Objects.equals(com.getItemType(), "book")) {
                finalCom.add(com);
                System.out.println("found");
            }
        }
        if (finalCom.size() == 0)
            throw new RuntimeException("Get: Book com with" + bookId + "not found");
        return finalCom;
    }
}