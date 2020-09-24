package fr.usmb.m2isc.chronopost.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "HomepageServlet")
public class HomepageServlet extends HttpServlet {

    public HomepageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String[] names = {"Mathieu", "Robert", "Daniel", "François", "Stephanie", "Mireille", "Gilberte"};
        request.setAttribute("names", names);
        int rnd = new Random().nextInt(names.length);
        request.setAttribute("rnd", rnd);
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
