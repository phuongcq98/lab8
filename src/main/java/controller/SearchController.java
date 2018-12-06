/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DetailDAO;
import dao.EmployeeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Detail;
import model.Employee;

/**
 *
 * @author huynq
 */
public class SearchController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    EmployeeDAO empDAO;
    DetailDAO deDAO;

    public SearchController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.empDAO = new EmployeeDAO();
        this.deDAO = new DetailDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String [] idPV = request.getParameterValues("search");
        String id = idPV[0];
        int userId = Integer.parseInt(id);
        System.out.println("String :" + userId);

        Employee emp = this.empDAO.getEmployee1(userId);

        int userID = emp.getUserId();

        System.out.println("Test id " + userID);

        List<Detail> list = this.deDAO.getListDetail1(userID);

        String name = emp.getName();

        HttpSession session = request.getSession();
        session.removeAttribute("USERS");
        session.setAttribute("USERS", name);

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/show.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        
//        String name = request.getParameter("search");
//        
//        Employee emp = this.empDAO.getEmployee1(name);
//        
//        request.setAttribute("emp", emp);
//        
//        
//        int userId = emp.getUserId();
//        
//        List<Detail> list = this.deDAO.getListDetail1(userId);
//        request.setAttribute("list", list);
//        
//        
//        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/show.jsp");
//        dispatcher.forward(request, response);

    }

}
