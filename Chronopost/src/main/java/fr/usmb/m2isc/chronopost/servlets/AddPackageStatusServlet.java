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

@WebServlet("/AddPackageStatusServlet")
public class AddPackageStatusServlet extends HttpServlet {

    @EJB
    PackageEJB ejb;

    public AddPackageStatusServlet()  {super();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Package
        long id = Long.parseLong(request.getParameter("packageId"));

        // Package Status
        String name = request.getParameter("name");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String state = request.getParameter("state");

        PackageStatus ps = new PackageStatus(new Coordinate(latitude, longitude), name, PackageStatus.ParseState(state));

        Package p = ejb.addStep(id, ps);

        request.setAttribute("package", p);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        request.getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }
}
