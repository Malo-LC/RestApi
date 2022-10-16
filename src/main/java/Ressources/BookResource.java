package Ressources;

import Model.Book;
import REST.BookDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class BookResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public BookResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook() {
        Book book = BookDao.instance.getModel().get(id);
        if (book == null)
            throw new RuntimeException("Get: Book with" + id + "not found");
        return book;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public Book getBookHTML() {
        Book book = BookDao.instance.getModel().get(id);
        if (book == null)
            throw new RuntimeException("Get: Book with" + id + "not found");
        return book;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putBook(JAXBElement<Book> dvd) {
        Book b = dvd.getValue();
        return putAndGetResponse(b);
    }

    @DELETE
    public void deleteBook() {
        Book b = BookDao.instance.getModel().remove(id);
        if (b == null)
            throw new RuntimeException("Delete: Book with" + id + "not found");
    }

    private Response putAndGetResponse(Book book) {
        Response res;
        if (BookDao.instance.getModel().containsKey(book.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        BookDao.instance.getModel().put(book.getId(), book);
        return res;
    }
}
