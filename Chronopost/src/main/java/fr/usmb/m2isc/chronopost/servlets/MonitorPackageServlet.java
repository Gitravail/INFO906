package fr.usmb.m2isc.chronopost.servlets;

import fr.usmb.m2isc.chronopost.ejb.PackageEJB;
import fr.usmb.m2isc.chronopost.jpa.Package;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet used to monitor a package
 */
@WebServlet("/MonitorPackageServlet")
public class MonitorPackageServlet extends HttpServlet {

    /* Inject the ejb reference */
    @EJB
    private PackageEJB ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitorPackageServlet() { super(); }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Get the information for the selected package */
        long id = Long.parseLong(request.getParameter("packageId"));
        Package p = ejb.findById(id);
        /* Add it to the request */
        request.setAttribute("package", p);
        /* Send to jsp */
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Provide the ids for the package selection */
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        request.getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }
}
