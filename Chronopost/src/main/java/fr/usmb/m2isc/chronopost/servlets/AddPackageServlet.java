package fr.usmb.m2isc.chronopost.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class AddPackageServlet extends HttpServlet {

    public AddPackageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("timestamp", new Timestamp(System.currentTimeMillis()));
        this.getServletContext().getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }
}
