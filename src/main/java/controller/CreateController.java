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

public class CreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EmployeeDAO empDAO;
    DetailDAO deDAO;
    
    public CreateController(){
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uId = request.getParameter("userId");
        int userId = Integer.parseInt(uId);
        String name = request.getParameter("name");
        
        String dId1 = request.getParameter("detailId1");
        int detailId1 = Integer.parseInt(dId1);
        String addressName1 = request.getParameter("addressName1");
        String phoneNum1 = request.getParameter("phoneNumber1");
        int phoneNumber1 = Integer.parseInt(phoneNum1);
        
        String dId2 = request.getParameter("detailId2");
        int detailId2 = Integer.parseInt(dId2);
        String addressName2 = request.getParameter("addressName2");
        String phoneNum2 = request.getParameter("phoneNumber2");
        int phoneNumber2 = Integer.parseInt(phoneNum2);
        
        Employee emp = new Employee();
        emp.setUserId(userId);
        emp.setName(name);
        this.empDAO.createEmployee(emp);
        
        Detail de = new Detail();
        de.setDetailId(detailId1);
        de.setEmployee(emp);
        de.setAddressName(addressName1);
        de.setPhoneNumber(phoneNumber1);
        this.deDAO.createDetail(de);
        
        de = new Detail();
        de.setDetailId(detailId2);
        de.setEmployee(emp);
        de.setAddressName(addressName2);
        de.setPhoneNumber(phoneNumber2);
        this.deDAO.createDetail(de);
        
        response.sendRedirect("search.jsp");

    }

}
