package Ressources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

public class ComentaireResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public ComentaireResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }


}
