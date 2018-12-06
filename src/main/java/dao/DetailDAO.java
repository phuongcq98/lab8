/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Detail;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author huynq
 */
public class DetailDAO {

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

    public List<Detail> getListDetail() {
        try {
            this.openSession();
            String sql = "from Detail";
            Query<Detail> query = session.createQuery(sql);
            List<Detail> list = query.list();
            this.closeSession();
            System.out.println("TEST LIST Detail: " + list.get(0).getAddressName());
            return list;
        } catch (Exception e) {
            System.out.println("Co loi o list Detail: " + e);
            return null;
        }

    }

    public Detail getDetail(int detailId) {
        try {
            this.openSession();
            Detail de = this.session.find(Detail.class, detailId);
            this.closeSession();
            System.out.println("Test Find Emp:" + de.getAddressName());
            return de;
        } catch (Exception e) {
            System.out.println("Loi o find Detail: " + e);
            return null;
        }

    }

    public List<Detail> getListDetail1(int userId) {
        try {
            this.openSession();
            String sql = "from Detail where userId='"+userId+"'";
            Query<Detail> query = session.createQuery(sql);
            List<Detail> list = query.list();
            this.closeSession();
            System.out.println("TEST LIST Detail: " + list.get(0).getAddressName());
            return list;
        } catch (Exception e) {
            System.out.println("Co loi o list Detail: " + e);
            return null;
        }

    }

    public void createDetail(Detail de) {
        try {
            this.openSession();
            this.session.beginTransaction();
            this.session.save(de);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O CREATE Detail: " + e);
            System.out.println("LOI O CREATE Detail: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }

    public void updateDetail(Detail de) {
        try {
            this.openSession();
            this.session.beginTransaction();
            this.session.update(de);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O UPDATE Detail: " + e);
            System.out.println("LOI O UPDATE Detail: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }

    public void deleteDetail(int detailId) {
        try {
            this.openSession();
            Detail emp = this.session.find(Detail.class, detailId);
            this.session.beginTransaction();
            this.session.delete(emp);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("LOI O delete Detail: " + e);
            System.out.println("LOI O delete Detail: " + e);
            this.session.getTransaction().rollback();
        } finally {
            this.closeSession();
        }
    }
}
