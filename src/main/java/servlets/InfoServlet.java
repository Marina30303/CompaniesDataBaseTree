package servlets;

import entities.CompanyEntity;
import repository.CompanyRepository;
import util.DbConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Марiна on 18.02.2018.
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    private DbConnector dbConnector;
    private Connection connection;
    private CompanyRepository repository;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("'/info'  ->  'DO GET' method:");
        init();

        if (request.getParameter("action") != null) delete(request);
        List<CompanyEntity> companyList = repository.getAll();

        request.setAttribute("list", companyList);
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("'/info'  ->  'DO POST' method:");
        init();
       // if (request.getParameter("action").equals("skip")) doGet(request, response);

    }

    private void delete(HttpServletRequest request) {
        if (!request.getParameter("action").equals("delete")) return;
        int id = Integer.parseInt(request.getParameter("id"));
        repository.remove(id);
    }

    public void init() throws ServletException {
        System.out.println("init/info");
        if (dbConnector != null) return;
        dbConnector = DbConnector.getINSTANCE();
        connection = dbConnector.getConnection();
        repository = new CompanyRepository(connection);
    }

}