package Ressources;

import Model.Commentaire;
import REST.ComDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/com")
public class CommentairesResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @POST
    @Path("/dvd/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public void newDVDCom(@PathParam("id") String dvdId,
                          @QueryParam("userId") String userId,
                          @QueryParam("text") String text,
                          @Context HttpServletResponse servletResponse) throws IOException {
        Commentaire com = new Commentaire(userId, "dvd", dvdId, text);
        ComDao.instance.getModel().put(dvdId, com);
        servletResponse.sendRedirect("../getDvd/" + dvdId);
    }

    @GET
    @Path("/dvd/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Commentaire getDvdCom(@PathParam("id") String dvdId) {
        System.out.println("init");
        Commentaire finalCom = null;
        List<Commentaire> ComList = new ArrayList<>();
        ComList.addAll(ComDao.instance.getModel().values());
        for (Commentaire com : ComList) {
            if (Objects.equals(com.getItemID(), dvdId) && Objects.equals(com.getItemType(), "dvd")) {
                finalCom = com;
                System.out.println("found");
                break;
            }
        }
        if (finalCom == null)
            throw new RuntimeException("Get: DVD com with" + dvdId + "not found");
        System.out.println(finalCom.getText());
        return finalCom;
    }

}
