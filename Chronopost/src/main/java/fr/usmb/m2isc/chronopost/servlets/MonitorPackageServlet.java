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

@WebServlet(name = "MonitorPackageServlet")
public class MonitorPackageServlet extends HttpServlet {

    @EJB
    private PackageEJB ejb;

    public MonitorPackageServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        long id = Long.parseLong(request.getParameter("id"));
        // call ejb to find corresponding package
        Package p = ejb.findById(id);
        // Add to the request
        request.setAttribute("package", p);
        // Send to jsp
        request.getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> ids = ejb.listPackageIds();
        request.setAttribute("ids", ids);
        this.getServletContext().getRequestDispatcher("/WEB-INF/monitor.jsp").forward(request, response);
    }
}
