package Ressources;

import Model.DVD;
import REST.DvDDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class DvdResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public DvdResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DVD getDvd() {
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
        System.out.println("Test");
        DVD c = DvDDao.instance.getModel().remove(id);
        if (c == null)
            throw new RuntimeException("Delete: DVD with" + id + "not found");
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
