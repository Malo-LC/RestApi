package Ressources;

import Model.User;
import REST.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class UserResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public UserResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getDVD() {
        User user = UserDao.instance.getModel().get(id);
        if (user == null)
            throw new RuntimeException("Get: User with" + id + "not found");
        return user;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public User getDVDHTML() {
        User user = UserDao.instance.getModel().get(id);
        if (user == null)
            throw new RuntimeException("Get: User with" + id + "not found");
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putDVD(JAXBElement<User> dvd) {
        User u = dvd.getValue();
        return putAndGetResponse(u);
    }

    @DELETE
    public void deleteUser() {
        System.out.println("Test");
        User u = UserDao.instance.getModel().remove(id);
        if (u == null)
            throw new RuntimeException("Delete: User with" + id + "not found");
    }

    private Response putAndGetResponse(User user) {
        Response res;
        if (UserDao.instance.getModel().containsKey(user.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        UserDao.instance.getModel().put(user.getId(), user);
        return res;
    }
}
