package Ressources;


import Model.User;
import REST.UserDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/user")
public class UsersResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    @GET
    @Produces(MediaType.TEXT_XML)
    public List<User> getDVDBrowser() {
        List<User> UserList = new ArrayList<User>();
        UserList.addAll(UserDao.instance.getModel().values());
        return UserList;
    }

    @GET
    @Path("/getAllUser")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> getUser() {
        List<User> UserList = new ArrayList<User>(UserDao.instance.getModel().values());
        System.out.println(UserList);
        return UserList;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = UserDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public void newUser(@QueryParam("userId") String userId,
                       @QueryParam("name") String name,
                       @QueryParam("firstname") String fistname,
                        @QueryParam("city") String city,
                       @Context HttpServletResponse servletResponse) throws IOException {
        User user = new User(userId, name, fistname,city);
        UserDao.instance.getModel().put(userId, user);
        servletResponse.sendRedirect("../getUser/" + userId);
    }


    @Path("/getUser/{user}")
    @Produces(MediaType.APPLICATION_XML)
    public UserResource getUser(@PathParam("user") String userId) {
        return new UserResource(uriInfo, request, userId);
    }

}
