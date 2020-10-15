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
 * Servlet used for the package status edition
 */
@WebServlet("/EditPackageStatusServlet")
public class EditPackageStatusServlet extends HttpServlet {

    /* Inject the ejb reference */
    @EJB
    private PackageEJB ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPackageStatusServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Retrieve the package and package status concerned by the request */
        long packageId = Long.parseLong(request.getParameter("packageId"));
        long packageStatusId = Long.parseLong(request.getParameter("packageStatusId"));

        /* Get the package status updated information */
        String location = request.getParameter("name");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String state = request.getParameter("state");

        /* Update the package status with new information in database */
        Package p = ejb.editPackageStatus(packageId, packageStatusId, location, latitude, longitude, state);
        request.setAttribute("package", p);

        /* Return the list of ids for the combobox */
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        request.getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Retrieve the package and package status concerned by the request */
        long packageId = Long.parseLong(request.getParameter("packageId"));
        long packageStatusId = Long.parseLong(request.getParameter("packageStatusId"));

        /* Get the package status to fill in the page form */
        PackageStatus ps = ejb.findPackageStatus(packageStatusId);

        request.setAttribute("packageStatus", ps);

        /* Send the package id for the step update in the post request */
        request.setAttribute("packageId", packageId);

        request.getRequestDispatcher("/WEB-INF/editStep.jsp").forward(request, response);
    }
}
