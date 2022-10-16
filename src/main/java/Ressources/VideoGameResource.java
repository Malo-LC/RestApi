package Ressources;

import Model.VideoGames;
import REST.VideoGameDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class VideoGameResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public VideoGameResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
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
    public Response putVideoGames(JAXBElement<VideoGames> videogames) {
        VideoGames v = videogames.getValue();
        return putAndGetResponse(v);
    }

    @DELETE
    public void deleteVideoGames() {
        VideoGames v = VideoGameDao.instance.getModel().remove(id);
        if (v == null)
            throw new RuntimeException("Delete: VideoGame with" + id + "not found");
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
