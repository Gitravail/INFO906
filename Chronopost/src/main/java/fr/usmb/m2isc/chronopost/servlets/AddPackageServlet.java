package fr.usmb.m2isc.chronopost.servlets;

import fr.usmb.m2isc.chronopost.ejb.PackageEJB;
import fr.usmb.m2isc.chronopost.jpa.Package;
import fr.usmb.m2isc.chronopost.jpa.PackageStatus;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet used when adding a package
 */
@WebServlet(name = "AddPackageServlet")
public class AddPackageServlet extends HttpServlet {

    /* Inject the ejb reference */
    @EJB
    private PackageEJB ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackageServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Get the package informations */
        float weight = Float.parseFloat(request.getParameter("weight"));
        float value = Float.parseFloat(request.getParameter("value"));
        String originName = request.getParameter("originName");
        String originLat = request.getParameter("originLat");
        String originLong = request.getParameter("originLong");
        String destinationName = request.getParameter("destinationName");
        /* Instantiate the package with the received information */
        /* Instantiating a package will also add a first PackageStatus record */
        Package p = ejb.addPackage(weight, value, originName, originLat, originLong, destinationName);
        /* Return the freshly added package to display some of its information */
        request.setAttribute("package", p);
        /* Forward the request to the page for adding a new package */
        this.getServletContext().getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }
}
