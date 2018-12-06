/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Detail;
import model.Employee;
import dao.DetailDAO;
import dao.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author huynq
 */
public class searchDAO {
    
    Session session;
    
    //------------------------------------------------------------------------------
    private void openSession() {

        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    private void closeSession() {

        if (this.session != null && this.session.isOpen()) {
            this.session.close();
        }
    }
    //------------------------------------------------------------------------------
    
//    public List getSearch(String name) {
//        try {
//            this.openSession();
//            String sql = "from Employee where name='"+name+"'";
//            
//            Query<Employee> query = session.createQuery(sql);
//            
//            List<Employee> list = query.list();
//            
//            int id = list.get(0).getUserId();
//            
//     
//            return list;
//        } catch (Exception e) {
//            System.out.println("Co loi o list Detail: " + e);
//            return null;
//        }finally{
//            this.closeSession();
//        }
//
//    }
    
    
    
}
