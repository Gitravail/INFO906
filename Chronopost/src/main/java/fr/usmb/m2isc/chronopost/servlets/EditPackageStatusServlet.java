package fr.usmb.m2isc.chronopost.servlets;

import fr.usmb.m2isc.chronopost.ejb.PackageEJB;
import fr.usmb.m2isc.chronopost.jpa.PackageStatus;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/EditPackageStatusServlet")
public class EditPackageStatusServlet extends HttpServlet {

    @EJB
    private PackageEJB ejb;


    public EditPackageStatusServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long packageId = Long.parseLong(request.getParameter("packageId"));
        long packageStatusId = Long.parseLong(request.getParameter("packageStatusId"));

        PackageStatus ps = ejb.findPackageStatus(packageStatusId);

        request.setAttribute("packageStatus", ps);
        request.setAttribute("packageId", packageId);

        request.getRequestDispatcher("/WEB-INF/editStep.jsp").forward(request, response);
    }
}
