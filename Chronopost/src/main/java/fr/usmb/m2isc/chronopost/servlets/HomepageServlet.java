package fr.usmb.m2isc.chronopost.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet used to provide the homepage
 */
@WebServlet(name = "HomepageServlet")
public class HomepageServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* This bit of code is just used to provide a random name to the site homepage */
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String[] names = {"Mathieu", "Robert", "Daniel", "François", "Ambroise", "Mireille", "Gilberte", "Raphaël", "Jean", "Anna", "Sylvie"};
        request.setAttribute("names", names);
        int rnd = new Random().nextInt(names.length);
        request.setAttribute("rnd", rnd);
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
