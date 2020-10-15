package fr.usmb.m2isc.chronopost.servlets;

import fr.usmb.m2isc.chronopost.ejb.PackageEJB;
import fr.usmb.m2isc.chronopost.jpa.Coordinate;
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
 * Servlet used when adding a new package status
 */
@WebServlet("/AddPackageStatusServlet")
public class AddPackageStatusServlet extends HttpServlet {

    /* Inject the ejb reference */
    @EJB
    PackageEJB ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackageStatusServlet()  {super();}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Get the concerned package id */
        long id = Long.parseLong(request.getParameter("packageId"));

        /* Get the new package status information */
        String location = request.getParameter("name");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String state = request.getParameter("state");

        /* Instantiate a new package status */
        PackageStatus ps = new PackageStatus(new Coordinate(latitude, longitude), location, PackageStatus.parseState(state));

        /* Add the package status using the ejb so it will update the database */
        Package p = ejb.addPackageStatus(id, ps);

        /* Forward the package to the jsp */
        request.setAttribute("package", p);

        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Provide the list of available package ids, used in the combobox on the monitor page */
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        request.getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }
}
