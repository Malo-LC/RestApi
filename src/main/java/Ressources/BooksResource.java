package Ressources;


import Model.Book;
import REST.BookDao;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/book")
public class BooksResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Book> getBookBrowser() {
        List<Book> Booklist = new ArrayList<Book>();
        Booklist.addAll(BookDao.instance.getModel().values());
        return Booklist;
    }

    @GET
    @Path("/getAllBook")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getBook() {
        List<Book> BookList = new ArrayList<Book>(BookDao.instance.getModel().values());
        System.out.println(BookList);
        return BookList;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = BookDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public void newDVD(@QueryParam("bookId") String bookId,
                       @QueryParam("userId") String userId,
                       @QueryParam("author") String author,
                       @QueryParam("title") String title,
                       @QueryParam("type") String type,
                       @QueryParam("description") String description,
                       @QueryParam("releasedate") String releaseDate,
                       @QueryParam("editor") String editor,
                       @QueryParam("rating") String rating,
                       @Context HttpServletResponse servletResponse) throws IOException {
        Book book = new Book(bookId, userId, author, title, type, description, releaseDate, editor, rating);
        BookDao.instance.getModel().put(bookId, book);
        servletResponse.sendRedirect("../getBook/" + bookId);
    }


    @Path("/modifyBook/{book}")
    @Produces(MediaType.APPLICATION_XML)
    public BookResource getBook(@PathParam("book") String bookId, @QueryParam("userId") String userId) {
        return new BookResource(uriInfo, request, bookId, userId);
    }

}
