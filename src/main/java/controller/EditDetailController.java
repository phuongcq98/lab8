/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DetailDAO;
import java.io.IOException;
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
public class EditDetailController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    DetailDAO deDAO;

    public EditDetailController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.deDAO = new DetailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String [] idPV = request.getParameterValues("detailId");
        String id = idPV[0];
        int detailId = Integer.parseInt(id);
        System.out.println("String :" + detailId);

        Detail de = this.deDAO.getDetail(detailId);
        request.setAttribute("de", de);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/editDetail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String [] DidPV = request.getParameterValues("detailId");
        String [] EidPV = request.getParameterValues("userId");
        String [] addrNamePV = request.getParameterValues("addressName");
        String [] phoneNumPV = request.getParameterValues("phoneNumber");
        
        String Did = DidPV[0];
        String Eid = EidPV[0];
        String addressname = addrNamePV[0];
        String phoneNum = phoneNumPV[0];
        int detailId = Integer.parseInt(Did);
        int userId = Integer.parseInt(Eid);
        int phoneNumber = Integer.parseInt(phoneNum);
        
        Employee emp = new Employee();
        emp.setUserId(userId);
        
        Detail de  = new Detail();
        de.setDetailId(detailId);
        de.setEmployee(emp);
        de.setAddressName(addressname);
        de.setPhoneNumber(phoneNumber);
        
        this.deDAO.updateDetail(de);
        response.sendRedirect("search.jsp");

    }

}
