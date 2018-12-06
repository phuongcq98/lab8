/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Employee;

/**
 *
 * @author huynq
 */
public class EditEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    EmployeeDAO empDAO;

    public EditEmployeeController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.empDAO = new EmployeeDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String [] idPV = request.getParameterValues("userId");
        String id = idPV[0];
        int userId = Integer.parseInt(id);
        System.out.println("String :" + userId);

        Employee emp = this.empDAO.getEmployee(userId);
        request.setAttribute("emp", emp);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/editEmp.jsp");
        dispatcher.forward(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String [] idPV = request.getParameterValues("userId");
        String [] namePV = request.getParameterValues("name");
        
        String id = idPV[0];
        int userId = Integer.parseInt(id);
        String name = namePV[0];
        
        Employee emp = new Employee();
        emp.setUserId(userId);
        emp.setName(name);
        this.empDAO.updateEmployee(emp);
        
        response.sendRedirect("search.jsp");
        
    }

}
