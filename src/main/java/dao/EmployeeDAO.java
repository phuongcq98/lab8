/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author huynq
 */
public class EmployeeDAO {

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

    public List<Employee> getListEmployee() {
        try {
            this.openSession();
            String sql = "from Employee";
            Query<Employee> query = session.createQuery(sql);
            List<Employee> list = query.list();
            this.closeSession();
            System.out.println("TEST LIST EMP: " + list.get(0).getName());
            return list;
        } catch (Exception e) {
            System.out.println("Co loi o list Emp: " + e);
            return null;
        }

    }

    public Employee getEmployee(int userId) {
        try {
            this.openSession();
            Employee emp = this.session.find(Employee.class, userId);
            this.closeSession();
            System.out.println("Test Find Emp:" + emp.getName());
            return emp;
        } catch (Exception e) {
            System.out.println("Loi o find Emp: " + e);
            return null;
        }

    }
    
        public Employee getEmployee1(int userId) {
        try {
            this.openSession();
            Employee emp = this.session.find(Employee.class, userId);
            this.closeSession();
            System.out.println("Test Find Emp:" + emp.getName());
            return emp;
        } catch (Exception e) {
            System.out.println("Loi o find Emp: " + e);
            return null;
        }

    }

    public void createEmployee(Employee emp) {
        try {
            this.openSession();
            this.session.beginTransaction();
            this.session.save(emp);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O CREATE Account: " + e);
            System.out.println("LOI O CREATE Account: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }

    public void updateEmployee(Employee emp) {
        try {
            this.openSession();
            this.session.beginTransaction();
            this.session.update(emp);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O UPDATE Account: " + e);
            System.out.println("LOI O UPDATE Account: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }

    public void deleteEmployee(int userId) {
        try {
            this.openSession();
            Employee emp = this.session.find(Employee.class, userId);
            this.session.beginTransaction();
            this.session.delete(emp);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O delete Employee: " + e);
            System.out.println("LOI O delete Employee: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }

}
