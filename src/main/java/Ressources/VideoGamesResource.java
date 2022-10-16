package Ressources;


import Model.VideoGames;
import REST.VideoGameDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/videogame")
public class VideoGamesResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    @GET
    @Produces(MediaType.TEXT_XML)
    public List<VideoGames> getDVDBrowser() {
        List<VideoGames> VideoGamelist = new ArrayList<VideoGames>();
        VideoGamelist.addAll(VideoGameDao.instance.getModel().values());
        return VideoGamelist;
    }

    @GET
    @Path("/getAllVideoGame")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VideoGames> getVideoGame() {
        List<VideoGames> VideoGamelist = new ArrayList<VideoGames>(VideoGameDao.instance.getModel().values());
        System.out.println(VideoGamelist);
        return VideoGamelist;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = VideoGameDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public void newDVD(@QueryParam("videogameId") String videogameId,
                       @QueryParam("userId") String userId,
                       @QueryParam("Name") String name,
                       @QueryParam("type") String type,
                       @QueryParam("resume") String resume,
                       @QueryParam("editor") String editor,
                       @QueryParam("releasedate") String releaseDate,
                       @QueryParam("rating") String rating,
                       @Context HttpServletResponse servletResponse) throws IOException {
        VideoGames videogames = new VideoGames(videogameId, userId, name, type, resume, editor, releaseDate, rating);
        VideoGameDao.instance.getModel().put(videogameId, videogames);
        servletResponse.sendRedirect("../getVideoGame/" + videogameId);
    }


    @Path("/getVideoGame/{videogames}")
    @Produces(MediaType.APPLICATION_XML)
    public VideoGameResource getVideoGame(@PathParam("videogames") String videogameId) {
        return new VideoGameResource(uriInfo, request, videogameId);
    }

}
