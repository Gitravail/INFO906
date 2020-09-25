package fr.usmb.m2isc.chronopost.servlets;

import fr.usmb.m2isc.chronopost.ejb.PackageEJB;
import fr.usmb.m2isc.chronopost.jpa.Package;
import fr.usmb.m2isc.chronopost.jpa.PackageStatus;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddPackageServlet extends HttpServlet {

    @EJB
    private PackageEJB ejb;

    public AddPackageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Package p = ejb.addPackage((float) 50.20, (float) 21.1, "Origin", "Destination", "21.5458", "65.122", "Here");
        List<PackageStatus> packageStatusList = p.getPackageStatusList();
        PackageStatus first = packageStatusList.get(0);
        request.setAttribute("coordinate", first.getCoordinate().getLatitude() + ", " + first.getCoordinate().getLongitude());
        request.setAttribute("timestamp", first.getDate());
        request.setAttribute("id", p.getId());
        this.getServletContext().getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }
}
