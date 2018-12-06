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
import model.Detail;
import model.Employee;

/**
 *
 * @author huynq
 */
public class DeleteEmployeeController extends HttpServlet {


    private static final long serialVersionUID = 1L;
    EmployeeDAO empDAO;
    DetailDAO deDAO;

    public DeleteEmployeeController() {
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
        String [] idPV = request.getParameterValues("userId");
        String id = idPV[0];
        int userId = Integer.parseInt(id);
        System.out.println("String :" + userId);

        Employee emp = this.empDAO.getEmployee(userId);
        request.setAttribute("emp", emp);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/deleteEmployee.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String [] idPV= request.getParameterValues("userId");
        String id = idPV[0];
        int userId = Integer.parseInt(id);
        System.out.println("Test CTRL: "+userId);
        
        List<Detail> list = this.deDAO.getListDetail1(userId);
        int detailId = list.get(0).getDetailId();
        
        this.deDAO.deleteDetail(detailId);
        this.empDAO.deleteEmployee(userId);
        
        response.sendRedirect("search.jsp");
    }


}
