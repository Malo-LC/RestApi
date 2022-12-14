package Ressources;

import Model.VideoGames;
import REST.VideoGameDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import java.util.Objects;

public class VideoGameResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    String userId;

    public VideoGameResource(UriInfo uriInfo, Request request, String id, String userId) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.userId = userId;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VideoGames getVideoGame() {
        VideoGames videogames = VideoGameDao.instance.getModel().get(id);
        if (videogames == null)
            throw new RuntimeException("Get: VideoGames with" + id + "not found");
        return videogames;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public VideoGames getVideoGamesHTML() {
        VideoGames videogames = VideoGameDao.instance.getModel().get(id);
        if (videogames == null)
            throw new RuntimeException("Get: VideoGames with" + id + "not found");
        return videogames;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putVideoGames(@QueryParam("videogameId") String videogameId,
                                  @QueryParam("userId") String userId,
                                  @QueryParam("Name") String name,
                                  @QueryParam("type") String type,
                                  @QueryParam("resume") String resume,
                                  @QueryParam("editor") String editor,
                                  @QueryParam("releasedate") String releaseDate,
                                  @QueryParam("rating") String rating,
                                  @Context HttpServletResponse servletResponse) {
        VideoGames v = new VideoGames(videogameId,userId,name,type,resume,editor,releaseDate,rating);
        return putAndGetResponse(v);
    }

    @DELETE
    public void deleteVideoGames() {
        VideoGames v = VideoGameDao.instance.getModel().remove(id);
        if (v == null)
            throw new RuntimeException("Delete: VideoGame with" + id + "not found");
        else if (!Objects.equals(v.getUserId(), userId)) {
            throw new RuntimeException("Delete: userId does not match, you can't delete");
        } else {
            VideoGameDao.instance.getModel().remove(id);
        }
    }

    private Response putAndGetResponse(VideoGames videogames) {
        Response res;
        if (VideoGameDao.instance.getModel().containsKey(videogames.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        VideoGameDao.instance.getModel().put(videogames.getId(), videogames);
        return res;
    }
}
