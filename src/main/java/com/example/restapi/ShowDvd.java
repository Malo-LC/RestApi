package com.example.restapi;

import Model.DVD;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "showDvd", value = "/show-dvd")
public class ShowDvd extends HttpServlet{
    DVD Fightclub = new DVD("1","1","2:40","Fight Club", "Fight Club is a 1999 American film directed by David " +
            "Fincher and starring Brad Pitt, Edward Norton, and Helena Bonham Carter. It is based on the 1996 novel of the same name by Chuck Palahniuk." +
            " Norton plays the unnamed narrator, who is discontented with his white-collar job","1999","David Fincher","4");

    DVD LOTR = new DVD("2","2","2:40","Lord of The Rings", "Fight Club is a 1999 American film directed by David " +
            "Fincher and starring Brad Pitt, Edward Norton, and Helena Bonham Carter. It is based on the 1996 novel of the same name by Chuck Palahniuk." +
            " Norton plays the unnamed narrator, who is discontented with his white-collar job","1999","David Fincher","4");


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + Fightclub.getTitle() + "</h1>");
        out.println("<p>" + LOTR.getTitle() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }


}
