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

@WebServlet(name = "AddPackageServlet")
public class AddPackageServlet extends HttpServlet {

    @EJB
    private PackageEJB ejb;

    public AddPackageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float weight = Float.parseFloat(request.getParameter("weight"));
        float value = Float.parseFloat(request.getParameter("value"));
        String originName = request.getParameter("originName");
        String originLat = request.getParameter("originLat");
        String originLong = request.getParameter("originLong");
        String destinationName = request.getParameter("destinationName");
        Package p = ejb.addPackage(weight, value, originName, originLat, originLong, destinationName);
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
