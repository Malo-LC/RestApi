package Ressources;

import Model.DVD;
import REST.DvDDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import java.util.Objects;

public class DvdResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    String userId;

    public DvdResource(UriInfo uriInfo, Request request, String id, String userId) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.userId = userId;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DVD getDVD() {
        DVD dvd = DvDDao.instance.getModel().get(id);
        if (dvd == null)
            throw new RuntimeException("Get: DVD with" + id + "not found");
        return dvd;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public DVD getDVDHTML() {
        DVD dvd = DvDDao.instance.getModel().get(id);
        if (dvd == null)
            throw new RuntimeException("Get: DVD with" + id + "not found");
        return dvd;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putDVD(JAXBElement<DVD> dvd) {
        DVD c = dvd.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteDVD() {
        DVD c = DvDDao.instance.getModel().get(id);
        if (c == null)
            throw new RuntimeException("Delete: DVD with" + id + "not found");
        else if (!Objects.equals(c.getUserId(), userId)) {
            throw new RuntimeException("Delete: userId does not match, you can't delete");
        } else {
            DvDDao.instance.getModel().remove(id);
        }
    }

    private Response putAndGetResponse(DVD dvd) {
        Response res;
        if (DvDDao.instance.getModel().containsKey(dvd.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        DvDDao.instance.getModel().put(dvd.getId(), dvd);
        return res;
    }
}
